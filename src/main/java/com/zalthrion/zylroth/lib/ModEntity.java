package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityPyroKnight;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntity {
	
	// Main
	
	private static int nextEntityID = 1;
	
	private static int getNextEntityID() {
		nextEntityID ++;
		return nextEntityID - 1;
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName, boolean hasEgg, int bgEggColor, int fgEggColor) {
		EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true);
		if (hasEgg) {
			// Item spawnEgg = new SpawnEgg(entityName, bgEggColor, fgEggColor);
			// GameRegistry.registerItem(spawnEgg, "spawnEgg" + entityName);
		}
	}
	
	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
		}
	}
	
	public static void init() {
		registerEntities();
	}
	
	private static void registerEntities() {
		
		// Animals
		
		registerEntity(EntityBird.class, "bird", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityRainbowPig.class, "rainbowPig", true, 0xeaeae9, 0xc99a03);
		
		// Mobs
		
		registerEntity(EntityEmpoweredTenebraeGolem.class, "empoweredTenebraeGolem", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityPyroKnight.class, "pyroKnight", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityTenebraeGolem.class, "tenebraeGolem", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityVoidDragon.class, "voidDragon", true, 0xeaeae9, 0xc99a03);
		
		// Mounts
		
		registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
		
		registerEntity(MountPlaguedHorse.class, "Plagued Horse", false, 0, 0);
		
		registerEntity(MountWarTortoise.class, "War Tortoise", false, 0, 0);
		
	}
}