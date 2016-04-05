package com.zalthrion.zylroth.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.world.World;

//TODO Check all mappings, reorganize methods, etc.
public class EntityUnicorn extends EntityHorse {
	public EntityUnicorn(World world) {
		super(world);
		this.isImmuneToFire = true;
	}
	
	@Override public HorseArmorType getType() {
		return HorseArmorType.HORSE;
	}
	
	@Override public boolean shouldDismountInWater(Entity rider) {
		return true;
	}
	
	@Override public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override public int getMaxSpawnedInChunk() {
		return 1;
	}
}