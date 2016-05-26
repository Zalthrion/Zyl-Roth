package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.world.gen.biome.BiomeGenAshBarrens;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenAutumnForest;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenColdOcean;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenDreadWastes;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenDryDesert;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenFrozenSea;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenFrozenWastes;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenHauntedForest;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenJadePlains;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenRainbowForest;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenSakuraForest;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenSapphireOcean;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenSnowMountains;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenSnowPlateau;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenStoneQuarry;
import com.zalthrion.zylroth.world.gen.biome.BiomeGenVoidMountains;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class ModBiomes {
	
	// Ky'rul
	
	public static BiomeGenBase DreadWastes;
	
	public static BiomeGenBase HauntedForest;
	
	public static BiomeGenBase AshBarrens;
	
	public static BiomeGenBase VoidMountains;
	
	// Iri'dis
	
	public static BiomeGenBase JadePlains;
	
	public static BiomeGenBase AutumnForest;
	
	public static BiomeGenBase SapphireOcean;
	
	public static BiomeGenBase RainbowForest;
	
	public static BiomeGenBase SnowMountains;
	
	public static BiomeGenBase StoneQuarry;
	
	public static BiomeGenBase DryDesert;
	
	public static BiomeGenBase SakuraForest;
	
	// Glaciem
	
	public static BiomeGenBase FrozenSea;
	
	public static BiomeGenBase ColdOcean;
	
	public static BiomeGenBase FrozenWastes;
	
	public static BiomeGenBase SnowPlateau;
	
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
		
		SnowMountains = new BiomeGenSnowMountains(214);
		
		StoneQuarry = new BiomeGenStoneQuarry(215);
		
		DryDesert = new BiomeGenDryDesert(216);
		
		SakuraForest = new BiomeGenSakuraForest(217);
		
		
		FrozenSea = new BiomeGenFrozenSea(240);
		
		ColdOcean = new BiomeGenColdOcean(241);
		
		FrozenWastes = new BiomeGenFrozenWastes(242);
		
		SnowPlateau = new BiomeGenSnowPlateau(243);
		
	}
	
	public static void registerBiomes() {
		
		BiomeDictionary.registerBiomeType(DreadWastes, Type.PLAINS);
		BiomeDictionary.registerBiomeType(HauntedForest, Type.FOREST, Type.SPOOKY);
		BiomeDictionary.registerBiomeType(AshBarrens, Type.DRY);
		BiomeDictionary.registerBiomeType(VoidMountains, Type.HILLS);
		
		BiomeDictionary.registerBiomeType(JadePlains, Type.PLAINS);
		BiomeDictionary.registerBiomeType(AutumnForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(SapphireOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(RainbowForest, Type.MAGICAL, Type.FOREST);
		BiomeDictionary.registerBiomeType(SnowMountains, Type.COLD, Type.SNOWY);
		BiomeDictionary.registerBiomeType(StoneQuarry, Type.MOUNTAIN);
		BiomeDictionary.registerBiomeType(DryDesert, Type.HOT, Type.SANDY, Type.DRY);
		BiomeDictionary.registerBiomeType(SakuraForest, Type.FOREST, Type.MAGICAL);
		
		BiomeDictionary.registerBiomeType(FrozenSea, Type.COLD, Type.OCEAN, Type.SNOWY);
		BiomeDictionary.registerBiomeType(ColdOcean, Type.OCEAN);
		BiomeDictionary.registerBiomeType(FrozenWastes, Type.COLD, Type.PLAINS, Type.SNOWY);
		BiomeDictionary.registerBiomeType(SnowPlateau, Type.COLD, Type.MOUNTAIN, Type.SNOWY);
	}
	
}
