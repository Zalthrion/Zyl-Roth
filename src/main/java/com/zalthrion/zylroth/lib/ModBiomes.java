package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.world.gen.biome.*;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ModBiomes {
	
	public static BiomeGenBase DreadWastes;
	
	public static BiomeGenBase HauntedForest;
	
	public static BiomeGenBase AshBarrens;
	
	public static BiomeGenBase VoidMountains;
	
	
	public static BiomeGenBase JadePlains;
	
	public static BiomeGenBase AutumnForest;
	
	public static BiomeGenBase SapphireOcean;
	
	public static BiomeGenBase RainbowForest;
	
	public static void init(){
		initBiomes();
		registerBiomes();
	}
	
	public static void initBiomes(){
		
		DreadWastes = new BiomeGenDreadWastes(180);
		
		HauntedForest = new BiomeGenHauntedForest(181);
		
		AshBarrens = new BiomeGenAshBarrens(182);
		
		VoidMountains = new BiomeGenVoidMountains(183);
		
		
		JadePlains = new BiomeGenJadePlains(210);
		
		AutumnForest = new BiomeGenAutumnForest(211);
		
		SapphireOcean = new BiomeGenSapphireOcean(212);
		
		RainbowForest = new BiomeGenRainbowForest(213);
		
	}
	
	public static void registerBiomes(){
		
		BiomeDictionary.registerBiomeType(DreadWastes, Type.PLAINS);
		BiomeDictionary.registerBiomeType(HauntedForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(AshBarrens, Type.DRY);
		BiomeDictionary.registerBiomeType(VoidMountains, Type.HILLS);
		
		BiomeDictionary.registerBiomeType(JadePlains, Type.PLAINS);
		BiomeDictionary.registerBiomeType(AutumnForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(SapphireOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(RainbowForest, Type.MAGICAL);
		
//		BiomeManager.addSpawnBiome(DreadWastes);
		
	}
	
}
