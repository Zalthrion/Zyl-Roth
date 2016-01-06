package com.zalthrion.zylroth.entity.boss;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTools;

public class EntityVoidLordBoss extends EntityMob implements IBossDisplayData {
	
	public EntityVoidLordBoss(World world) {
		super(world);
		this.setSize(0.5F, 2.1F);
		this.isImmuneToFire = true;
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, false, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityVillager>(this, EntityVillager.class, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		
		this.setCurrentItemOrArmor(4, new ItemStack(ModArmors.voidLordHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(ModArmors.voidLordChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(ModArmors.voidLordLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(ModArmors.voidLordBoots));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(450.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40.0D);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		
		boolean KyrulMinions = ((entity instanceof EntityVoidLordBoss) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon) || (entity instanceof EntitySkeletalHorse));
		
		if (!KyrulMinions) {
			this.worldObj.setEntityState(this, (byte) 4);
			
			boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
			
			if (flag) {
				entity.motionY += 0.1D;
			}
			
			if (entity instanceof EntityPlayer) {
				
				EntityPlayer player = (EntityPlayer) entity;
				
				boolean hasArmor = true;
				for (int i = 0; i < 4; i ++) {
					if (player.inventory.armorInventory[i] != null) hasArmor = false;
				}
				
				if (!player.worldObj.isRemote && !hasArmor) {
					this.playSound("mob.blaze.hit", 0.5F, 1.0F);
				}
			}
			
			int i = this.worldObj.getDifficulty().getDifficultyId();
			entity.setFire(10 * i);
			
		}
		
		return KyrulMinions;
	}
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return "mob.blaze.breathe";
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.wither.hurt";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.wither.death";
	}
	
	@Override
	protected void collideWithEntity(Entity entity) {
		boolean KyrulMinions = ((entity instanceof EntityVoidLordBoss) || (entity instanceof EntityUndeadWarrior) || (entity instanceof EntityUndeadMinion) || (entity instanceof EntityVoidDragon) || (entity instanceof EntitySkeletalHorse));
		
		if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(KyrulMinions)) {
			this.setAttackTarget((EntityLivingBase) entity);
		}
		
		super.collideWithEntity(entity);
	}
	
	@Override
	public void onLivingUpdate() {
		
		for (int i = 0; i < 2; ++ i) {
			this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
		}
		
		if (worldObj.isRemote) {
			BossStatus.setBossStatus(this, true);
		}
		
		for (int l = 0; l < 4; ++ l) {
			
			int x = MathHelper.floor_double(this.posX);
			int y = MathHelper.floor_double(this.posY);
			int z = MathHelper.floor_double(this.posZ);
			
			x = MathHelper.floor_double(this.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
			y = MathHelper.floor_double(this.posY);
			z = MathHelper.floor_double(this.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
			BlockPos pos = new BlockPos(x, y, z);
			
			if (this.worldObj.getBlockState(pos).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, pos)) {
				this.worldObj.setBlockState(pos, Blocks.fire.getDefaultState());
			}
		}
		
		super.onLivingUpdate();
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public void onKillEntity(EntityLivingBase p_70074_1_) {
		super.onKillEntity(p_70074_1_);
		
		if ((this.worldObj.getDifficulty() == EnumDifficulty.NORMAL || this.worldObj.getDifficulty() == EnumDifficulty.HARD) && p_70074_1_ instanceof EntityVillager) {
			if (this.worldObj.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) { return; }
			
			EntityUndeadMinion entityundeadminion = new EntityUndeadMinion(this.worldObj);
			entityundeadminion.copyLocationAndAnglesFrom(p_70074_1_);
			this.worldObj.removeEntity(p_70074_1_);
			entityundeadminion.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(this.posX, this.posY, this.posZ)), (IEntityLivingData) null);
			
			this.worldObj.spawnEntityInWorld(entityundeadminion);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016, new BlockPos(this.posX, this.posY, this.posZ), 0);
		}
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int amount = this.rand.nextInt(3) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ModItems.darkShard, 1, 6), 0f);
		}
	}
	
	@Override
	public ItemStack getHeldItem() {
		return defaultHeldItem;
	}
	
	private static final ItemStack defaultHeldItem;
	
	static {
		defaultHeldItem = new ItemStack(ModTools.tenebraeSword, 1);
	}
	
	@Override public boolean canAttackClass(Class<? extends EntityLivingBase> par1Class) {
		return EntityVoidLordBoss.class != par1Class && EntityUndeadWarrior.class != par1Class && EntityUndeadMinion.class != par1Class && EntityVoidDragon.class != par1Class && EntitySkeletalHorse.class != par1Class;
	}
	
	@Override protected boolean canDespawn() {
		return false;
	}
}