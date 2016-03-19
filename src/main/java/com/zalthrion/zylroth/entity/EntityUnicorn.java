package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.world.World;

public class EntityUnicorn extends EntityHorse {
	
	public EntityUnicorn(World world) {
		super(world);
		this.isImmuneToFire = true;
	}
	
	@Override
	public HorseArmorType getType() {
		return HorseArmorType.HORSE;
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
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
}