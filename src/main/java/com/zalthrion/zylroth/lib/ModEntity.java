package com.zalthrion.zylroth.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityMutantTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityPyroKnight;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.reference.Reference;

public class ModEntity {
	
	// Main
	
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
	}
	
	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		int id = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
	}
	
	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.CREATURE, biomes);
		}
	}
	
	public void registerEntity() {
	
		//Animals
		
		EntityRegistry.registerModEntity(EntityBird.class, "Bird", 1, this, 80, 4, true);
		
		EntityRegistry.registerModEntity(EntityRainbowPig.class, "Rainbow Pig", 2, this, 80, 4, true);

		
		//Mobs

		EntityRegistry.registerModEntity(EntityMutantTenebraeGolem.class, "Mutant Obsidian Golem", 3, this, 80, 4, true);

		EntityRegistry.registerModEntity(EntitySkeletalHorse.class, "Skeletal Horse", 4, this, 80, 4, true);

		EntityRegistry.registerModEntity(EntityPyroKnight.class, "Pyro Knight", 5, this, 80, 4, true);

		EntityRegistry.registerModEntity(EntityTenebraeGolem.class, "Tenebrae Golem", 6, this, 80, 4, true);
		
		EntityRegistry.registerModEntity(EntityUndeadMinion.class, "Undead Minion", 7, this, 80, 4, true);

		EntityRegistry.registerModEntity(EntityUndeadWarrior.class, "Undead Warrior", 8, this, 80, 4, true);

		EntityRegistry.registerModEntity(EntityVoidDragon.class, "Void Dragon", 9, this, 80, 4, true);

		
		//Mounts
		
		EntityRegistry.registerModEntity(MountDeathcharger.class, "Deathcharger", 10, this, 80, 4, true);
		
		EntityRegistry.registerModEntity(MountPlaguedHorse.class, "Plagued Horse", 11, this, 80, 4, true);
		
		
	}
	
	public static void init() {
		registerEntities();
	}
	
	private static void registerEntities() {
		
		//Animals
		
		registerEntityEgg(EntityBird.class, Reference.MOD_ID + ":" + "Bird", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityRainbowPig.class, Reference.MOD_ID + ":" + "Rainbow_Pig", 0xeaeae9, 0xc99a03);

		
		//Mobs
		
		registerEntityEgg(EntityMutantTenebraeGolem.class, Reference.MOD_ID + ":" + "Mutant_Tenebrae_Golem", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityPyroKnight.class, Reference.MOD_ID + ":" + "Pyro_Knight", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityRainbowPig.class, Reference.MOD_ID + ":" + "Rainbow_Pig", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntitySkeletalHorse.class, Reference.MOD_ID + ":" + "Skeletal_Horse", 0xeaeae9, 0xc99a03);

		registerEntityEgg(EntityTenebraeGolem.class, Reference.MOD_ID + ":" + "Tenebrae_Golem", 0xeaeae9, 0xc99a03);

		registerEntityEgg(EntityUndeadMinion.class, Reference.MOD_ID + ":" + "Undead_Minion", 0xeaeae9, 0xc99a03);
		
		registerEntityEgg(EntityUndeadWarrior.class, Reference.MOD_ID + ":" + "Undead_Warrior", 0xeaeae9, 0xc99a03);
				
		registerEntityEgg(EntityVoidDragon.class, Reference.MOD_ID + ":" + "Void_Dragon", 0xeaeae9, 0xc99a03);
		
		
		//Mounts
		
		registerEntity(MountDeathcharger.class, Reference.MOD_ID + ":" + "Deathcharger");
		
		registerEntity(MountPlaguedHorse.class, Reference.MOD_ID + ":" + "Plagued_Horse");
		

	}
}