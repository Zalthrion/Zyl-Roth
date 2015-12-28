package com.zalthrion.zylroth.entity.boss;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.lib.ModItems;

public class EntityEmpoweredTenebraeGolem extends EntityMob implements IBossDisplayData {
	private int attackTimer;
	public int deathTicks;
	
	public EntityEmpoweredTenebraeGolem(World world) {
		super(world);
		this.setSize(2.1F, 4.2F);
		((PathNavigateGround) this.getNavigator()).setAvoidsWater(true);
		this.isImmuneToFire = true;
		this.experienceValue = 75;
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		boolean hardcore = ConfigurationHandler.getHardcoreModeEnabled();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(hardcore ? 1250.0D : 750.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(hardcore ? 0.28D : 0.27D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(hardcore ? 25.0D : 15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(hardcore ? 15.0D : 5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(60.0D);
	}
	
	/** Decrements the entity's air supply when underwater */
	@Override
	protected int decreaseAirSupply(int par1) {
		return par1;
	}
	
	@Override
	protected void collideWithEntity(Entity entity) {
		if (entity instanceof IMob && this.getRNG().nextInt(20) == 0) {
			this.setAttackTarget((EntityLivingBase) entity);
		}
		
		super.collideWithEntity(entity);
	}
	
	/** Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn. */
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
			
			if (this.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock().getRenderType() != -1) {
				this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double) this.rand.nextFloat() - 0.5D) * (double) this.width, 4.0D * ((double) this.rand.nextFloat() - 0.5D), 0.5D, ((double) this.rand.nextFloat() - 0.5D) * 4.0D, Block.getStateId(this.worldObj.getBlockState(new BlockPos(i, j, k))));
			}
		}
		
		if (worldObj.isRemote) {
			BossStatus.setBossStatus(this, true);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		this.attackTimer = 40;
		this.worldObj.setEntityState(this, (byte) 4);
		
		boolean strike = super.attackEntityAsMob(entity);
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
		
		if (strike && this.attackTimer > 10) {
			if (this.getRNG().nextBoolean()) {
				this.attackTimer = 0;
				entity.motionY += 1.0D;
				return flag;
			}
		}
		
		if (strike && this.attackTimer > 25) {
			if (this.getRNG().nextBoolean()) {
				this.attackTimer = 400;
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
				return strike;
			}
		}
		
		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return flag;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte par1) {
		if (par1 == 4) {
			this.attackTimer = 10;
			this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		} else {
			super.handleStatusUpdate(par1);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return "mob.wither.idle";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.zombie.metal";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}
	
	/** Plays step sound at given x, y, z for the entity */
	@Override
	protected void playStepSound(BlockPos pos, Block block) {
		this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
	}
	
	/** Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob. */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(ModItems.voidGem, 1);
		this.dropItem(ModItems.voidEssence, 4);
		
		int amount = this.rand.nextInt(4) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ModItems.tenebraeOre, 1, 6), 0f);
		}
	}
	
	@Override protected void onDeathUpdate() {
		this.deathTicks ++;
		
		if (this.deathTicks >= 180 && this.deathTicks <= 200) {
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double) f, this.posY + 2.0D + (double) f1, this.posZ + (double) f2, 0.0D, 0.0D, 0.0D);
		}
		
		int i;
		int j;
		
		if (!this.worldObj.isRemote) {
			if (this.deathTicks == 1) {
				this.worldObj.playBroadcastSound(1018, new BlockPos(this.posX, this.posY, this.posZ), 0);
			}
		}
		
		this.moveEntity(0.D, 0.1D, 0.0D);
		for (int countparticles = 900; countparticles <= 1000; ++ countparticles) {
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 1.1F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 0.1F);
			this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, (double) this.posX - 0.0F, (double) this.posY - -1.5F, (double) this.posZ - 0.0F, (double) ((float) rand.nextFloat() - 0.5F), (double) ((float) rand.nextFloat() - 0.1F), (double) ((float) rand.nextFloat()) - 1.1F);
		}
		this.renderYawOffset = this.rotationYaw += 1000.0F;
		
		if (this.deathTicks == 200 && !this.worldObj.isRemote) {
			i = 2000;
			
			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}
			
			this.setDead();
		}
	}
	
	public boolean isPlayerCreated() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
	
	public void setPlayerCreated(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		
		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 1)));
		} else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -2)));
		}
	}
	
	@Override
	public boolean canBeCollidedWith() {
		if (this.deathTicks >= 1) {
			return false;
		} else return true;
	}
	
	@Override public void fall(float distance, float damageMultiplier) {}
	
	@Override protected boolean canDespawn() {
		return false;
	}
	
	/* private void applyAttribute(IAttribute attribute, double baseValue) {
	 * IAttributeInstance attr = this.getEntityAttribute(attribute); if (attr ==
	 * null) { this.getAttributeMap().registerAttribute(attribute);
	 * this.getEntityAttribute(attribute).setBaseValue(baseValue); } else {
	 * attr.setBaseValue(baseValue); } } */
	
	/** Returns true if this entity can attack entities of the specified class. */
	@Override
	@SuppressWarnings("rawtypes")
	public boolean canAttackClass(Class par1Class) {
		return EntityEmpoweredTenebraeGolem.class != par1Class && EntityTenebraeGolem.class != par1Class;
	}
}