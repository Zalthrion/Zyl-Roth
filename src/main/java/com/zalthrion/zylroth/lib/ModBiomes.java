package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.world.gen.biome.*;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ModBiomes {
	
	//Ky'rul
	
	public static BiomeGenBase DreadWastes;
	
	public static BiomeGenBase HauntedForest;
	
	public static BiomeGenBase AshBarrens;
	
	public static BiomeGenBase VoidMountains;
	
	
	//Iri'dis
	
	public static BiomeGenBase JadePlains;
	
	public static BiomeGenBase AutumnForest;
	
	public static BiomeGenBase SapphireOcean;
	
	public static BiomeGenBase RainbowForest;
	
	
	//Glaciem
	
	public static BiomeGenBase FrozenOcean;
	
	public static BiomeGenBase ColdOcean;
	
	public static BiomeGenBase FrozenWastes;

	public static void init() {
		initBiomes();
		registerBiomes();
	}
	
	public static void initBiomes() {
		
		DreadWastes = new BiomeGenDreadWastes(180);
		
		HauntedForest = new BiomeGenHauntedForest(181);
		
		AshBarrens = new BiomeGenAshBarrens(182);
		
		VoidMountains = new BiomeGenVoidMountains(183);
		
		
		JadePlains = new BiomeGenJadePlains(210);
		
		AutumnForest = new BiomeGenAutumnForest(211);
		
		SapphireOcean = new BiomeGenSapphireOcean(212);
		
		RainbowForest = new BiomeGenRainbowForest(213);
		
		
		FrozenOcean = new BiomeGenFrozenOcean(240);
		
		ColdOcean = new BiomeGenColdOcean(241);
		
		FrozenWastes = new BiomeGenFrozenWastes(242);
		
	}
	
	public static void registerBiomes() {
		
		BiomeDictionary.registerBiomeType(DreadWastes, Type.PLAINS);
		BiomeDictionary.registerBiomeType(HauntedForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(AshBarrens, Type.DRY);
		BiomeDictionary.registerBiomeType(VoidMountains, Type.HILLS);
		
		BiomeDictionary.registerBiomeType(JadePlains, Type.PLAINS);
		BiomeDictionary.registerBiomeType(AutumnForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(SapphireOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(RainbowForest, Type.MAGICAL);
		
		BiomeDictionary.registerBiomeType(FrozenOcean, Type.COLD);
		BiomeDictionary.registerBiomeType(ColdOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(FrozenWastes, Type.COLD);
		
		// BiomeManager.addSpawnBiome(DreadWastes);
		
	}
	
}
