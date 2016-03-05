package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.boss.*;
import com.zalthrion.zylroth.entity.dev.*;
import com.zalthrion.zylroth.entity.mount.*;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModEntity {
	
	private static int nextEntityID = 0;
	
	private static int getNextEntityID() {
		nextEntityID ++;
		return nextEntityID;
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName, boolean hasEgg, int bkEggColor, int fgEggColor) {
		EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true);
		if (hasEgg) {
			Item spawnEgg = new SpawnEgg(entityName, bkEggColor, fgEggColor).setTextureName("zylroth:spawnEgg");
			GameRegistry.registerItem(spawnEgg, "spawnEgg" + "." + entityName);
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
		
		registerEntity(EntityBadger.class, "badger", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityFancyBadger.class, "fancyBadger", false, 0, 0);
		
		registerEntity(EntityBoar.class, "boar", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUnicorn.class, "unicorn", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityDeer.class, "deer", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityStag.class, "stag", true, 0xeaeae9, 0xc99a03);
		
		// Mobs
		
		registerEntity(EntityTenebraeGuardian.class, "tenebraeGuardian", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityVoidLordBoss.class, "voidLord", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntitySkeletalHorse.class, "skeletalHorse", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityTenebraeProtector.class, "tenebraeProtector", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadMinion.class, "undeadMinion", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadWarrior.class, "undeadWarrior", true, 0xeaeae9, 0xc99a03);
				
		registerEntity(EntityVoidDragon.class, "voidDragon", true, 0xeaeae9, 0xc99a03);
		
		// Mounts
		
		registerEntity(MountDeathcharger.class, "Deathcharger", false, 0, 0);
		
		registerEntity(MountPlaguedHorse.class, "Plagued Horse", false, 0, 0);
		
		registerEntity(MountWarTortoise.class, "War Tortoise", false, 0, 0);
		
		registerEntity(MountSavageBadger.class, "Savage Badger", false, 0, 0);
		
		registerEntity(MountSwiftUnicorn.class, "Swift Unicorn", false, 0, 0);
		
		/** Developers */
		
		registerEntity(EntityZalthrion.class, "Zalthrion", true, 0xeaeae9, 0xc99a03);
		
		registerEntity(EntitySixOneThree.class, "Six-One-Three", true, 0xeaeae9, 0xc99a03);
		
	}
}