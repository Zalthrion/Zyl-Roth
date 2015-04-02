package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.world.gen.biome.*;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class ModBiomes {
	
	public static BiomeGenBase AgonyPlains;
	
	public static BiomeGenBase HauntedForest;
	
	public static BiomeGenBase AshBarrens;
	
	
	public static BiomeGenBase JadePlains;
	
	public static void init(){
		initBiomes();
		registerBiomes();
	}
	
	public static void initBiomes(){
		
		AgonyPlains = new BiomeGenAgonyPlains(180);
		
		HauntedForest = new BiomeGenHauntedForest(181);
		
		AshBarrens = new BiomeGenAshBarrens(182);
		
		
		JadePlains = new BiomeGenJadePlains(210);
		
	}
	
	public static void registerBiomes(){
		
		BiomeDictionary.registerBiomeType(AgonyPlains, Type.PLAINS);
		BiomeDictionary.registerBiomeType(HauntedForest, Type.FOREST);
		BiomeDictionary.registerBiomeType(AshBarrens, Type.DRY);
		
		BiomeDictionary.registerBiomeType(JadePlains, Type.PLAINS);
		
//		BiomeManager.addSpawnBiome(AgonyPlains);
		
	}
	
}
