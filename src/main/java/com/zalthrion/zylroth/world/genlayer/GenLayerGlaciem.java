package com.zalthrion.zylroth.world.genlayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

//TODO Check mappings, constructors, etc.
public class GenLayerGlaciem extends GenLayer {
	
	public GenLayerGlaciem(long seed) {
		super(seed);
	}
	
	public static GenLayer[] makeTheWorld(long seed, WorldType type) {
		GenLayer biomes = new GenLayerBiomesGlaciem(1L);
		
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerZoom(1004L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);
		
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);
		
		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);
		
		return new GenLayer[] {biomes, genlayervoronoizoom};
	}
	
	@Override public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
		return null;
	}
}