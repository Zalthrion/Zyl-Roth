package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.entity.boss.EntityPyroKnight;
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
		
		registerEntity(EntityBird.class, "Bird", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityRainbowPig.class, "RainbowPig", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityBadger.class, "Badger", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityFancyBadger.class, "FancyBadger", false, 0, 0);
		
		// Mobs

		registerEntity(EntityEmpoweredTenebraeGolem.class, "EmpoweredTenebraeGolem", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntitySkeletalHorse.class, "SkeletalHorse", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityPyroKnight.class, "PyroKnight", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityTenebraeGolem.class, "TenebraeGolem", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityUndeadMinion.class, "UndeadMinion", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityUndeadWarrior.class, "UndeadWarrior", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityUnicorn.class, "Unicorn", true, 0xeaeae9, 0xc99a03);
		registerEntity(EntityVoidDragon.class, "VoidDragon", true, 0xeaeae9, 0xc99a03);
		
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