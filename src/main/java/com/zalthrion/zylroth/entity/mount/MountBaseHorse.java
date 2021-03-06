package com.zalthrion.zylroth.entity.mount;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.zalthrion.zylroth.handler.MountData;

public class MountBaseHorse extends EntityTameableHorse {
	
	public boolean isSummoned = false;
	
	public boolean canDespawn;
	
	protected Entity entity;
	
	protected EntityPlayer player;
	
	protected EntityTameableHorse tameableHorse;
	
	protected NBTTagCompound tagCompound;
	
	public MountBaseHorse(World world) {
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
		
		if (entity instanceof EntityTameableHorse) {
			entity = this.tameableHorse;
		}
		
		return this.isEntity(entity);
	}
	
	/** Gives the horse special attributes */
	public boolean isSummoned(boolean summoned) {
		
		if (summoned == true) {
			this.isSummoned = true;
			this.setHorseTamed(true);
			this.setHorseSaddled(true);
			this.isHorseSaddled();
			
			this.isTamed();
		}
		
		return summoned;
	}
	
	@Override
	public boolean setTamedBy(EntityPlayer p_110263_1_) {
		this.func_152115_b(p_110263_1_.getUniqueID().toString());
		this.setTamed(true);
		return true;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setBoolean("Tame", this.isTame());
		tagCompound.setBoolean("Saddled", this.isHorseSaddled());
		tagCompound.setBoolean("Summoned", this.isSummoned(true));
		tagCompound.setString("OwnerUUID", this.func_152113_b());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		
		this.tagCompound = tagCompund;
		this.setHorseTamed(tagCompund.getBoolean("Tame"));
		this.setHorseSaddled(tagCompund.getBoolean("Saddled"));
		this.isSummoned(tagCompund.getBoolean("Summoned"));
		
		this.tagCompound.getBoolean("Summoned");
		
		if (tagCompund.hasKey("OwnerUUID", 8)) {
			this.func_152120_b(tagCompund.getString("OwnerUUID"));
		}
	}
	
	@Override protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
	
	/** Sets what GUI should open when the player opens his inventory while
	 * mounting the entity */
	@Override
	public void openGUI(EntityPlayer p_110199_1_) {
		
		if (this.isSummoned)
			;
		
		else super.openGUI(p_110199_1_);
	}
	
	/** Returns true if the horse is an Undead horse */
	@Override
	public boolean isUndead() {
		return false;
	}
	
	/** Returns true if the rider of the entity should be dismounted on water */
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	/** Returns true if the entity can breath underwater */
	@Override
	public boolean canBreatheUnderwater() {
		return true;
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
	
	@Override
	public boolean isChild() {
		return false;
	}
	
	@Override
	public double getMountedYOffset() {
		return 1.2F;
	}
}