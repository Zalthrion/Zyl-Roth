package com.zalthrion.zylroth.entity.mount;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.zalthrion.zylroth.handler.MountData;

public class MountBase extends EntityTameable {
	
	public boolean isSummoned = false;
	
	public boolean canDespawn;
	
	protected Entity entity;
	
	protected EntityPlayer player;
	
	protected EntityTameable tameableMount;
	
	protected NBTTagCompound tagCompound;
	
	public MountBase(World world) {
		super(world);
		this.setSize(1.0F, 1.0F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.7D));
		
		this.isImmuneToFire = true;
	}
	
	/** Checks if the entity summoned is alive. */
	public boolean isSummonAlive() {
		return this.isSummoned;
	}
	
	/** Entity check */
	public boolean isEntity(Entity entity) {
		
		if (entity instanceof Entity) {
			entity = this.entity;
		}
		
		if (entity instanceof EntityPlayer) {
			entity = this.player;
		}
		
		if (entity instanceof EntityTameable) {
			entity = this.tameableMount;
		}
		
		return this.isEntity(entity);
	}
	
	/** Gives the horse special attributes */
	public boolean isSummoned(boolean summoned) {
		
		if (summoned == true) {
			this.isSummoned = true;
			
			this.isTamed();
		}
		
		return summoned;
	}
	
	public boolean setTamedBy(EntityPlayer p_110263_1_) {
		this.func_152115_b(p_110263_1_.getUniqueID().toString());
		this.setTamed(true);
		return true;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		
		tagCompound.setBoolean("Summoned", this.isSummoned(true));
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		
		this.tagCompound = tagCompund;
		this.isSummoned(tagCompund.getBoolean("Summoned"));
		
		this.tagCompound.getBoolean("Summoned");
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override public boolean isAIEnabled() {
		return true;
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	}
	
	@Override protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
	
	/** Returns true if the rider of the entity should be dismounted on water */
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	/** Returns true if the entity can breath underwater */
	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}
	
	/** Returns true if the entity can despawn */
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	/** Checks if the entity can be leashed or not */
	@Override
	public boolean allowLeashing() {
		return false;
	}
	
	/** Checks if the entity is invulnerable or not */
	@Override
	public boolean isEntityInvulnerable() {
		
		if (!this.isSummoned) {
			return false;
		}
		
		else return true;
	}
	
	/**
	 * returns true if all the conditions for steering the entity are met. For pigs, this is true if it is being ridden
	 * by a player and the player is holding a carrot-on-a-stick
	 */
	@Override public boolean canBeSteered() {
		EntityPlayer riding = ((EntityPlayer) this.riddenByEntity);
		return riding != null && !this.isChild();
	}
	
	/**
	* Moves the entity based on the specified heading.  Args: strafe, forward
	*/
	@Override public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase) {
			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			
			p_70612_1_ = ((EntityLivingBase) this.riddenByEntity).moveStrafing * 0.5F;
			p_70612_2_ = ((EntityLivingBase) this.riddenByEntity).moveForward;
			
			this.stepHeight = 1.0F;
			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
			
			if (!this.worldObj.isRemote) {
				this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue());
				super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
			}
			
			this.prevLimbSwingAmount = this.limbSwingAmount;
			
			double d1 = this.posX - this.prevPosX;
			double d0 = this.posZ - this.prevPosZ;
			float f4 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0F;
			
			if (f4 > 1.0F) {
				f4 = 1.0F;
			}
			
			this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
		
		else {
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		}
	}
	
	/* Functionality replaced in 1.8.9 by EntityMountEvent */
	@Override public void onLivingUpdate() {
		if (this.riddenByEntity == null && this.entityAge > 20) {
			this.setDead();
		} else {
			this.entityAge ++;
			super.onLivingUpdate();
		}
	}
	
	/* Functionality replaced in 1.8.9 by EntityMountEvent */
	@Override public void setDead() {
		String ownerUUID = this.func_152113_b();
		if (ownerUUID.length() > 0) {
			Iterator<?> iterator = this.worldObj.loadedEntityList.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				if (obj instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) obj;
					if (player.getUniqueID().toString().equalsIgnoreCase(ownerUUID)) {
						MountData data = MountData.get(player);
						data.disownMount();
					}
				}
			}
		}
		super.setDead();
	}
}