package com.zalthrion.zylroth.entity;

import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.lib.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTenebraeProtector extends EntityMob {
	private int attackTimer;
	
	public EntityTenebraeProtector(World world) {
		super(world);
		this.setSize(1.4F, 2.9F);
		this.getNavigator().setAvoidsWater(true);
		this.isImmuneToFire = true;
		this.experienceValue = 15;
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 0.9D));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}
	
	/** Returns true if the newer Entity AI code should be run */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10.0D);
		this.getCustomNameTag();
		
	}
	
	/** Decrements the entity's air supply when underwater */
	@Override
	protected int decreaseAirSupply(int par1) {
		return par1;
	}
	
	@Override
	protected void collideWithEntity(Entity p_82167_1_) {
		if (p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
			this.setAttackTarget((EntityLivingBase) p_82167_1_);
		}
		
		super.collideWithEntity(p_82167_1_);
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
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - this.yOffset);
			int k = MathHelper.floor_double(this.posZ);
			Block block = this.worldObj.getBlock(i, j, k);
			
			if (block.getMaterial() != Material.air) {
				this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + this.worldObj.getBlockMetadata(i, j, k), this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.boundingBox.minY + 0.1D, this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, 4.0D * (this.rand.nextFloat() - 0.5D), 0.5D, (this.rand.nextFloat() - 0.5D) * 4.0D);
			}
		}
	}
	
	/** Returns true if this entity can attack entities of the specified class. */
	/* public boolean canAttackClass(Class par1Class) { return
	 * this.isPlayerCreated(); } */
	
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		this.attackTimer = 10;
		this.worldObj.setEntityState(this, (byte) 4);
		boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(15));
		
		if (flag) {
			p_70652_1_.motionY += 0.4000000059604645D;
		}
		
		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return flag;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 4) {
			this.attackTimer = 10;
			this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		}
		else {
			super.handleHealthUpdate(par1);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	} // TODO What was this?
	
	/** Returns the sound this mob makes while it's alive. */
	@Override
	protected String getLivingSound() {
		return null;
	}
	
	/** Returns the sound this mob makes when it is hurt. */
	@Override
	protected String getHurtSound() {
		return "mob.irongolem.hit";
	}
	
	/** Returns the sound this mob makes on death. */
	@Override
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}
	
	/** Plays step sound at given x, y, z for the entity */
	@Override
	protected void playStepSound(int x, int y, int z, Block block) {
		this.playSound("mob.irongolem.walk", 1.0F, 1.0F);
	}
	
	/** Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob. */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		this.dropItem(ModItems.celestialCore, 1);
		
		int amount = this.rand.nextInt(4) + 2 + this.rand.nextInt(1 + par2 * 2);
		
		for (int def = 0; def < amount; ++ def) {
			this.entityDropItem(new ItemStack(ModItems.tenebraeOre, 1, 6), 0f);
		}
	}
	
	public boolean isPlayerCreated() {
		return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}
	
	public void setPlayerCreated(boolean par1) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);
		
		if (par1) {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 1)));
		}
		else {
			this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -2)));
		}
	}
	
	/** Called when the mob's health reaches 0. */
	@Override
	public void onDeath(DamageSource par1DamageSource) {
		super.onDeath(par1DamageSource);
	}
	
	/** Called when the mob is falling. Calculates and applies fall damage. */
	@Override
	protected void fall(float distance) {}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	/** Returns true if this entity can attack entities of the specified class. */
	@Override
	@SuppressWarnings("rawtypes")
	public boolean canAttackClass(Class par1Class) {
		return EntityTenebraeGuardian.class != par1Class && EntityTenebraeProtector.class != par1Class;
	}
}