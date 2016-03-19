package com.zalthrion.zylroth.world.gen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.zalthrion.zylroth.lib.ModBiomes;

public class GenLayerBiomesIridis extends GenLayer {
	
	protected BiomeGenBase[] allowedBiomes = {ModBiomes.jadePlains, ModBiomes.autumnForest, ModBiomes.sapphireOcean, ModBiomes.rainbowForest};
	
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
				dest[(dx + dz * width)] = BiomeGenBase.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
}