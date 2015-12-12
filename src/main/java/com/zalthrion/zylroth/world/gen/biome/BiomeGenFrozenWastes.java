package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenFrozenWastes extends BiomeGenBase {
	
	public BiomeGenFrozenWastes(int id) {
		super(id);
		
		this.setDisableRain();
		this.setEnableSnow();
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.topBlock = Blocks.ice.getDefaultState();
		this.fillerBlock = Blocks.flowing_water.getDefaultState();
		
		this.setHeight(height_LowPlains);
		this.setBiomeName("Frozen Wastes");
		
		this.waterColorMultiplier = 0x38CAE0;
		
		this.setTemperatureRainfall(0.0F, 0.5F); 
	}
	
	@Override public BiomeGenBase.TempCategory getTempCategory() {
		return BiomeGenBase.TempCategory.COLD;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x1DC3F6;
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x1DC3F6;
	}
	
	@Override public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
	@Override public void decorate(World world, Random rand, BlockPos pos) {}
	
	@Override public void genTerrainBlocks(World world, Random random, ChunkPrimer primer, int param4, int param5, double param6) {
		IBlockState blockState = this.topBlock;
		IBlockState blockState2 = this.fillerBlock;
		int k = -1;
		int l = (int) (param6 / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		int i1 = param4 & 15;
		int j1 = param5 & 15;
		
		for (int k1 = 255; k1 >= 0; k1 --) {
			if (k1 <= random.nextInt(5)) {
				primer.setBlockState(k1, Blocks.bedrock.getDefaultState());
			} else {
				IBlockState blockState3 = primer.getBlockState(j1, k1, i1);
				
				if (blockState3.getBlock().getMaterial() == Material.air) {
					k = -1;
				} else if (blockState3.getBlock() == Blocks.packed_ice) {
					if (k == -1) {
						if (l <= 0) {
							blockState = null;
							blockState2 = Blocks.packed_ice.getDefaultState();
						} else if (k1 >= 59 && k1 <= 64) {
							blockState = this.topBlock;
							blockState2 = this.fillerBlock;
						}
						
						k = l;
						
						if (k1 >= 62) {
							primer.setBlockState(j1, k1, i1, blockState);
						} else {
							primer.setBlockState(j1, k1, i1, blockState2);
						}
					}
				}
			}
		}
	}
}