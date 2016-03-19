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
		dreadWastes = new BiomeGenDreadWastes((new BiomeProps.PropsBuilder("Dread Wastes")).withHeight(BiomeProps.HEIGHT_LOW_PLAINS).withWaterColor(Integer.valueOf(0xE42D17)).withRainDisabled().build());
		hauntedForest = new BiomeGenHauntedForest((new BiomeProps.PropsBuilder("Haunted Forest").withHeight(BiomeProps.HEIGHT_DEFAULT).withWaterColor(Integer.valueOf(0xE42D17)).withRainDisabled().build()));
		ashBarrens = new BiomeGenAshBarrens((new BiomeProps.PropsBuilder("Ash Barrens")).withWaterColor(Integer.valueOf(0xE42D17)).withRainfall(Float.valueOf(0.0F)).withRainDisabled().build());
		voidMountains = new BiomeGenVoidMountains((new BiomeProps.PropsBuilder("Void Mountains")).withHeight(BiomeProps.HEIGHT_HIGH_PLATEAUS).withWaterColor(Integer.valueOf(0xE42D17)).withRainDisabled().build());
		
		jadePlains = new BiomeGenJadePlains((new BiomeProps.PropsBuilder("Jade Plains")).withHeight(BiomeProps.HEIGHT_LOW_PLAINS).withWaterColor(Integer.valueOf(0x38CAE0)).build());
		autumnForest = new BiomeGenAutumnForest((new BiomeProps.PropsBuilder("Autumn Forest")).withHeight(BiomeProps.HEIGHT_MID_PLAINS).withWaterColor(Integer.valueOf(0xE42D17)).build());
		sapphireOcean = new BiomeGenSapphireOcean((new BiomeProps.PropsBuilder("Sapphire Ocean")).withHeight(BiomeProps.HEIGHT_OCEAN).withWaterColor(Integer.valueOf(0x38CAE0)).build());
		rainbowForest = new BiomeGenRainbowForest((new BiomeProps.PropsBuilder("Rainbow Forest")).withHeight(BiomeProps.HEIGHT_LOW_ISLANDS).withWaterColor(Integer.valueOf(0x38CAE0)).build());
		
		frozenSea = new BiomeGenFrozenSea((new BiomeProps.PropsBuilder("Frozen Sea")).withHeight(BiomeProps.HEIGHT_OCEAN).withWaterColor(Integer.valueOf(0x3CA7B5)).withRainDisabled().withSnowEnabled().withTemperature(Float.valueOf(0.0F)).build());
		coldOcean = new BiomeGenColdOcean((new BiomeProps.PropsBuilder("Cold Ocean")).withHeight(BiomeProps.HEIGHT_OCEAN).withWaterColor(Integer.valueOf(0x38CAE0)).withRainDisabled().withSnowEnabled().withTemperature(Float.valueOf(0.3F)).build());
		frozenWastes = new BiomeGenFrozenWastes((new BiomeProps.PropsBuilder("Frozen Wastes")).withHeight(BiomeProps.HEIGHT_LOW_PLAINS).withWaterColor(Integer.valueOf(0x38CAE0)).withRainDisabled().withSnowEnabled().withTemperature(Float.valueOf(0.0F)).build());
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