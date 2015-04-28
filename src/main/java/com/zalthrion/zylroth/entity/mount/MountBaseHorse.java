package com.zalthrion.zylroth.entity.mount;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MountBaseHorse extends EntityTameableHorse {
	
	public MountBaseHorse(World world) {
		super(world);
	}
	
	public boolean isSummoned = false;
	
	public boolean canDespawn;
	
	protected Entity entity;
	
	protected EntityPlayer player;
	
	protected EntityTameableHorse tameableHorse;
	
	protected NBTTagCompound tagCompound;
	
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
			this.setOwnerId(tagCompund.getString("OwnerUUID"));
		}
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
	public boolean isEntityInvulnerable(DamageSource source) {
		if (!this.isSummoned || source == DamageSource.outOfWorld) {
			return false;
		}
		
		return true;
	}
}