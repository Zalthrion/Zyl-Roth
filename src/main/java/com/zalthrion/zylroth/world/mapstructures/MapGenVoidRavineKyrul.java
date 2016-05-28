package com.zalthrion.zylroth.world.mapstructures;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenRavine;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class MapGenVoidRavineKyrul extends MapGenRavine {
	private boolean isExceptionBiome(Biome biome) {
		if (biome == Biomes.BEACH) return true;
		if (biome == Biomes.DESERT) return true;
		if (biome == Biomes.MUSHROOM_ISLAND) return true;
		if (biome == Biomes.MUSHROOM_ISLAND_SHORE) return true;
		return false;
	}
	
	@Override protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop) {
		Biome biome = worldObj.getBiome(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
		IBlockState state = data.getBlockState(x, y, z);
		IBlockState top = isExceptionBiome(biome) ? Blocks.GRASS.getDefaultState() : biome.topBlock;
		IBlockState filler = isExceptionBiome(biome) ? Blocks.DIRT.getDefaultState() : biome.fillerBlock;
		
		if (state.getBlock() == BlockInit.voidStone || state.getBlock() == top.getBlock() || state.getBlock() == filler.getBlock()) {
			if (y - 1 < 10) {
				data.setBlockState(x, y, z, FLOWING_LAVA);
			} else {
				data.setBlockState(x, y, z, AIR);
				
				if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == filler.getBlock()) {
					data.setBlockState(x, y - 1, z, top.getBlock().getDefaultState());
				}
			}
		}
	}
}