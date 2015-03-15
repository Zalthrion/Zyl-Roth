package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityMutantTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityPyroKnight;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntity {
	
	// Main
	
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
	}
	
	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
		}
	}
	
	public void registerEntity()
	
	{
		EntityRegistry.registerModEntity(EntityMutantTenebraeGolem.class, "Mutant Obsidian Golem", 1, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityPyroKnight.class, "Pyro Knight", 1, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityUndeadWarrior.class, "Undead Warrior", 1, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityUndeadMinion.class, "Undead Minion", 1, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityBird.class, "Bird", 1, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityTenebraeGolem.class, "Tenebrae Golem", 1, this, 80, 4, true);
	}
	
	public static void init() {
		registerEntities();
	}
	
	private static void registerEntities() {
		
		registerEntity(EntityMutantTenebraeGolem.class, "Mutant_Tenebrae_Golem", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityPyroKnight.class, "Pyro_Knight", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadWarrior.class, "Undead_Warrior", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadMinion.class, "Undead_Minion", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityBird.class, "Bird", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityTenebraeGolem.class, "Tenebrae_Golem", 0xeaeae9, 0xc99a03);
		
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i ++) {
			if (BiomeGenBase.getBiomeGenArray()[i] != null) {
				EntityRegistry.addSpawn(EntityPyroKnight.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
				EntityRegistry.addSpawn(EntityUndeadWarrior.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
			}
		}
	}
}