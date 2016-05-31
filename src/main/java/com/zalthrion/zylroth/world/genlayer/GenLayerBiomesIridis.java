package com.zalthrion.zylroth.world.genlayer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.zalthrion.zylroth.lib.ModInit.BiomeInit;

//TODO Check mappings, constructors, etc.
public class GenLayerBiomesIridis extends GenLayer {
	protected Biome[] allowedBiomes = {BiomeInit.JADE_PLAINS, BiomeInit.AUTUMN_FOREST, BiomeInit.SAPPHIRE_OCEAN, BiomeInit.RAINBOW_FOREST, BiomeInit.SNOW_MOUNTAINS, BiomeInit.STONE_QUARRY, BiomeInit.DRY_DESERT, BiomeInit.SAKURA_FOREST};
	
	public GenLayerBiomesIridis(long seed) {
		super(seed);
	}
	
	public GenLayerBiomesIridis(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz ++) {
			for (int dx = 0; dx < width; dx ++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
}