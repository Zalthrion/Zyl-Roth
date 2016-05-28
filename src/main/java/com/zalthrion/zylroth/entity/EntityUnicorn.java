package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.world.World;

public class EntityUnicorn extends EntityHorse {
	
	/* Constructors */
	
	public EntityUnicorn(World world) {
		super(world);
		this.isImmuneToFire = true;
	}
	
	/* Overridden */
	
	@Override public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override public int getMaxSpawnedInChunk() {
		return 1;
	}
	
	@Override public HorseType getType() {
		return HorseType.HORSE;
	}
	
	@Override public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
}