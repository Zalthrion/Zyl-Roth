package com.zalthrion.zylroth.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

//TODO Check all mappings, reorganize methods, etc.
public class EntityTenebraeProtector extends EntityMob {
	protected static final DataParameter<Byte> PLAYER_CREATED = EntityDataManager.<Byte>createKey(EntityTenebraeGuardian.class, DataSerializers.BYTE);
	private int attackTimer;
	
	public EntityTenebraeProtector(World world) {
		super(world);
		this.setSize(1.4F, 2.9F);
		((PathNavigateGround) this.getNavigator()).setCanSwim(false);
		this.isImmuneToFire = true;
		this.experienceValue = 15;
	}
	
	@Override protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(PLAYER_CREATED, Byte.valueOf((byte) 0));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
		this.getCustomNameTag();
		
	}
	
	@Override protected int decreaseAirSupply(int par1) {
		return par1;
	}
	
	@Override
	protected void collideWithEntity(Entity p_82167_1_) {
		if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
			this.setAttackTarget((EntityLivingBase) p_82167_1_);
		}
		
		super.collideWithEntity(p_82167_1_);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if (this.attackTimer > 0) {
			-- this.attackTimer;
		}
		
		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double) this.getYOffset());
			int k = MathHelper.floor_double(this.posZ);
			
			if (!this.worldObj.isAirBlock(new BlockPos(i, j, k))) {
				this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D, ((double) this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(this.worldObj.getBlockState(new BlockPos(i, j, k))));
			}
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		this.attackTimer = 10;
		this.worldObj.setEntityState(this, (byte) 4);
		boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
		
		if (flag) {
			p_70652_1_.motionY += 0.4000000059604645D;
		}
		
		this.playSound(SoundEvents.entity_irongolem_attack, 1.0F, 1.0F); // TODO Irongolem throw?
		return flag;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte par1) {
		if (par1 == 4) {
			this.attackTimer = 10;
			this.playSound(SoundEvents.entity_irongolem_attack, 1.0F, 1.0F); // TODO Irongolem throw?
		} else {
			super.handleStatusUpdate(par1);
		}
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.entity_irongolem_hurt;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.entity_irongolem_death;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		this.playSound(SoundEvents.entity_irongolem_step, 1.0F, 1.0F);
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(ItemInit.unstableTenebraeCore, 1);
		
		int amount = this.rand.nextInt(4) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; def ++) {
			this.entityDropItem(new ItemStack(ItemInit.tenebraeIOre, 1, 6), 0f);
		}
	}
	
	public boolean isPlayerCreated() {
		return (((Byte) this.dataManager.get(PLAYER_CREATED)).byteValue() & 1) != 0;
	}
	
	public void setPlayerCreated(boolean par1) {
		byte b0 = ((Byte) this.dataManager.get(PLAYER_CREATED)).byteValue();
		
		if (par1) {
			this.dataManager.set(PLAYER_CREATED, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataManager.set(PLAYER_CREATED, Byte.valueOf((byte) (b0 & -2)));
		}
	}
	
	@Override
	public void onDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);
	}
	
	@Override public void fall(float distance, float damageMultipler) {}
	@Override protected boolean canDespawn() {
		return false;
	}
	
	@Override public boolean canAttackClass(Class<? extends EntityLivingBase> clazz) {
		return EntityTenebraeGuardian.class != clazz && EntityTenebraeProtector.class != clazz;
	}
	
	@SideOnly(Side.CLIENT) public int getAttackTimer() {
		return this.attackTimer;
	}
}