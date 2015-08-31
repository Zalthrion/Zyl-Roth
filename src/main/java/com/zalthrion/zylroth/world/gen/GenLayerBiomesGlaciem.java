package com.zalthrion.zylroth.world.gen;

import com.zalthrion.zylroth.lib.ModBiomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesGlaciem extends GenLayer {
	
	protected BiomeGenBase[] allowedBiomes = {ModBiomes.FrozenOcean, ModBiomes.ColdOcean, ModBiomes.FrozenWastes};
	
	public GenLayerBiomesGlaciem(long seed) {
		super(seed);
	}
	
	public GenLayerBiomesGlaciem(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz ++) {
			for (int dx = 0; dx < width; dx ++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}