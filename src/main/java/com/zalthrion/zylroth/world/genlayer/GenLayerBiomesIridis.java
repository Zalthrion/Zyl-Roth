package com.zalthrion.zylroth.world.genlayer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.zalthrion.zylroth.lib.ModInit.BiomeInit;

//TODO Check mappings, constructors, etc.
public class GenLayerBiomesIridis extends GenLayer {
	protected Biome[] allowedBiomes = {BiomeInit.jadePlains, BiomeInit.autumnForest, BiomeInit.sapphireOcean, BiomeInit.rainbowForest, BiomeInit.snowMountains, BiomeInit.stoneQuarry, BiomeInit.dryDesert, BiomeInit.sakuraForest};
	
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