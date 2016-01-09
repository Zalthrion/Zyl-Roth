package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;

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
			// GameRegistry.registerItem(spawnEgg, "spawnEgg" + entityName); //TODO Figure out why this makes more than one spawn egg.
		}
	}
	
	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.CREATURE, biomes);
		}
	}
	
	public static void registerEntity() {
		
		// Animals
		
		registerEntity(EntityBird.class, "bird", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityRainbowPig.class, "rainbowPig", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityBadger.class, "badger", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityFancyBadger.class, "fancyBadger", false, 0, 0);
		
		// Mobs

		registerEntity(EntityTenebraeGuardian.class, "tenebraeGuardian", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityVoidLordBoss.class, "voidLord", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityTenebraeProtector.class, "tenebraeProtector", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityUnicorn.class, "unicorn", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityVoidDragon.class, "voidDragon", true, 0xeaeae9, 0xc99a03);
		
		// Mounts
		
		registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
		registerEntity(MountPlaguedHorse.class, "PlaguedHorse", false, 0, 0);
		registerEntity(MountWarTortoise.class, "WarTortoise", false, 0, 0);
		registerEntity(MountSavageBadger.class, "SavageBadger", false, 0, 0);
		registerEntity(MountSwiftUnicorn.class, "SwiftUnicorn", false, 0, 0);
	}
	
	public static void init() {
		registerEntity();
	}
}