package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntity {
	
	// Main
	
	@SuppressWarnings("unchecked")
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
		EntityRegistry.registerModEntity(EntityBird.class, "Bird", 1, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityMutantTenebraeGolem.class, "Mutant Obsidian Golem", 2, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityPyroKnight.class, "Pyro Knight", 3, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityRainbowPig.class, "Rainbow Pig", 4, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityUndeadMinion.class, "Undead Minion", 5, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityUndeadWarrior.class, "Undead Warrior", 6, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityTenebraeGolem.class, "Tenebrae Golem", 7, this, 80, 4, true);
	}
	
	{
		EntityRegistry.registerModEntity(EntityVoidDragon.class, "Void Dragon", 8, this, 80, 4, true);
	}
	
	public static void init() {
		registerEntities();
	}
	
	private static void registerEntities() {
		
		registerEntity(EntityBird.class, Reference.MOD_ID + ":" + "Bird", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityMutantTenebraeGolem.class, Reference.MOD_ID + ":" + "Mutant_Tenebrae_Golem", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityPyroKnight.class, Reference.MOD_ID + ":" + "Pyro_Knight", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityRainbowPig.class, Reference.MOD_ID + ":" + "Rainbow_Pig", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadMinion.class, Reference.MOD_ID + ":" +"Undead_Minion", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityUndeadWarrior.class, Reference.MOD_ID + ":" +"Undead_Warrior", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityTenebraeGolem.class, Reference.MOD_ID + ":" + "Tenebrae_Golem", 0xeaeae9, 0xc99a03);
		
		registerEntity(EntityVoidDragon.class, Reference.MOD_ID + ":" +"Void_Dragon", 0xeaeae9, 0xc99a03);
		
		
		//Spawns
		
//		EntityRegistry.addSpawn(EntityRainbowPig.class, 2, 1,2, EnumCreatureType.ambient, ModBiomes.RainbowPlains);
		
/*		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i ++) {
			if (BiomeGenBase.getBiomeGenArray()[i] != null) {
				EntityRegistry.addSpawn(EntityPyroKnight.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
				EntityRegistry.addSpawn(EntityUndeadWarrior.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
				EntityRegistry.addSpawn(EntityRainbowPig.class, 1, 2, 4, EnumCreatureType.ambient, ModBiomes.RainbowPlains);
			}
		}*/
	}
}