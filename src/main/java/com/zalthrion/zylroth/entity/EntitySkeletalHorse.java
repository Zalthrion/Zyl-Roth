package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.World;

public class EntitySkeletalHorse extends EntityHorse {
	
	public EntitySkeletalHorse(World world) {
		super(world);
		this.isEntityUndead();
		this.isImmuneToFire = true;
	}
	
	/** Returns the horse type. 0 = Normal, 1 = Donkey, 2 = Mule, 3 = Undead
	 * Horse, 4 = Skeleton Horse */
	@Override
	public int getHorseType() {
		return 4;
	}
	
	/** Returns true if the horse is an Undead horse */
	@Override
	public boolean isUndead() {
		return true;
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
	
}
