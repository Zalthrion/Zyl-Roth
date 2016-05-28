package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.world.World;

//TODO Check all mappings, reorganize methods, etc.
public class EntitySkeletalHorse extends EntityHorse {
	public EntitySkeletalHorse(World world) {
		super(world);
		this.isEntityUndead();
		this.isImmuneToFire = true;
	}
	
	@Override public HorseType getType() {
		return HorseType.SKELETON;
	}
	
	@Override public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	@Override public boolean canBreatheUnderwater() {
		return true;
	}
}