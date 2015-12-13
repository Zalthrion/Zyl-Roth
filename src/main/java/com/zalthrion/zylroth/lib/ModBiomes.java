package com.zalthrion.zylroth.lib;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.zalthrion.zylroth.world.gen.biome.*;

public class ModBiomes {
	public static BiomeGenBase dreadWastes;
	public static BiomeGenBase hauntedForest;
	public static BiomeGenBase ashBarrens;
	public static BiomeGenBase voidMountains;
	
	
	public static BiomeGenBase jadePlains;
	public static BiomeGenBase autumnForest;
	public static BiomeGenBase sapphireOcean;
	public static BiomeGenBase rainbowForest;
	
	public static BiomeGenBase frozenSea;
	public static BiomeGenBase coldOcean;
	public static BiomeGenBase frozenWastes;
	
	public static void init() {
		initBiomes();
		registerBiomes();
	}
	
	public static void initBiomes() {
		dreadWastes = new BiomeGenDreadWastes(180);
		hauntedForest = new BiomeGenHauntedForest(181);
		ashBarrens = new BiomeGenAshBarrens(182);
		voidMountains = new BiomeGenVoidMountains(183);
		
		jadePlains = new BiomeGenJadePlains(210);
		autumnForest = new BiomeGenAutumnForest(211);
		sapphireOcean = new BiomeGenSapphireOcean(212);
		rainbowForest = new BiomeGenRainbowForest(213);
		
		frozenSea = new BiomeGenFrozenSea(240);
		coldOcean = new BiomeGenColdOcean(241);
		frozenWastes = new BiomeGenFrozenWastes(242);
	}
	
	public static void registerBiomes() {
		BiomeDictionary.registerBiomeType(dreadWastes, Type.PLAINS);
		BiomeDictionary.registerBiomeType(hauntedForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(ashBarrens, Type.DRY);
		BiomeDictionary.registerBiomeType(voidMountains, Type.HILLS);
		
		BiomeDictionary.registerBiomeType(jadePlains, Type.PLAINS);
		BiomeDictionary.registerBiomeType(autumnForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(sapphireOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(rainbowForest, Type.MAGICAL);
		
		BiomeDictionary.registerBiomeType(frozenSea, Type.COLD);
		BiomeDictionary.registerBiomeType(coldOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(frozenWastes, Type.COLD);
		// BiomeManager.addSpawnBiome(DreadWastes);
	}
}