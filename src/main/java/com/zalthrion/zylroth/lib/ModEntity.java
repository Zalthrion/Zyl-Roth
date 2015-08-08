package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.mount.*;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModEntity {
	
	// Main
	
	private static int nextEntityID = 1;
	
	private static int getNextEntityID() {
		nextEntityID ++;
		return nextEntityID - 1;
	}
	
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
		EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true);
	}
	
	private static void registerEntityEgg(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		EntityRegistry.registerModEntity(entityClass, entityName, getNextEntityID(), Zylroth.instance, 80, 4, true);
		registerSpawnEgg(entityName, bkEggColor, fgEggColor);
	}
	
	private static void registerSpawnEgg(String name, int bkEggColor, int fgEggColor) {
		Item itemSpawnEgg = new SpawnEgg(name, bkEggColor, fgEggColor).setUnlocalizedName("spawn_egg_" + name.toLowerCase()).setTextureName("zylroth:spawnEgg");
		GameRegistry.registerItem(itemSpawnEgg, "spawnEgg" + name);
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
		
		registerEntityEgg(EntityBird.class, "Bird (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityRainbowPig.class, "Rainbow Pig (ZYR)", 0xeaeae9, 0xc99a03);
		
		// Mobs
		
		registerEntityEgg(EntityEmpoweredTenebraeGolem.class, "Empowered Tenebrae Golem (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityPyroKnight.class, "Pyro Knight (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntitySkeletalHorse.class, "Skeletal Horse (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityTenebraeGolem.class, "Tenebrae Golem (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityUndeadMinion.class, "Undead Minion (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityUndeadWarrior.class, "Undead Warrior (ZYR)", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityVoidDragon.class, "Void Dragon (ZYR)", 0xeaeae9, 0xc99a03);
		
		// Mounts
		
		registerEntity(MountDeathcharger.class, "Deathcharger (ZYR)");
		
		registerEntity(MountPlaguedHorse.class, "Plagued Horse (ZYR)");
		
		registerEntity(MountWarTortoise.class, "War Tortoise (ZYR)");
		
	}
}