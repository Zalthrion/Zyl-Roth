package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import com.zalthrion.zylroth.world.mapstructures.BenzennHut;
import com.zalthrion.zylroth.world.mapstructures.IceHouse;

public class BiomeGenSnowPlateau extends Biome {
	public BiomeGenSnowPlateau(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.topBlock = Blocks.SNOW.getDefaultState();
		this.fillerBlock = Blocks.SNOW.getDefaultState();
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x0CA833;
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x16BA40;
	}
	
	@Override public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
	@Override public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		if (rand.nextInt(100) < 5) {
			int k = pos.getX() + rand.nextInt(16) + 8;
			int l = pos.getZ() + rand.nextInt(16) + 8;
			
			BenzennHut benzennHut = new BenzennHut();
			benzennHut.generate(worldIn, rand, worldIn.getHeight(new BlockPos(k, 0, l)).up());
		}
		
		if (rand.nextInt(100) < 15) {
			int k = pos.getX() + rand.nextInt(16) + 8;
			int l = pos.getZ() + rand.nextInt(16) + 8;
			
			IceHouse iceHouse = new IceHouse();
			iceHouse.generate(worldIn, rand, worldIn.getHeight(new BlockPos(k, 0, l)).up());
		}
	}
	
	@Override public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		int i = worldIn.getSeaLevel();
		IBlockState iblockstate = this.topBlock;
		IBlockState iblockstate1 = this.fillerBlock;
		int j = -1;
		int k = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int l = x & 15;
		int i1 = z & 15;
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		
		for (int j1 = 255; j1 >= 0; -- j1) {
			if (j1 <= rand.nextInt(5)) {
				chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
			} else {
				IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);
				
				if (iblockstate2.getMaterial() == Material.AIR) {
					j = -1;
				} else if (iblockstate2.getBlock() == Blocks.PACKED_ICE) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = AIR;
							iblockstate1 = Blocks.PACKED_ICE.getDefaultState();
						} else if (j1 >= i - 4 && j1 <= i + 1) {
							iblockstate = this.topBlock;
							iblockstate1 = this.fillerBlock;
						}
						
						if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR)) {
							if (this.getFloatTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F) {
								iblockstate = ICE;
							} else {
								iblockstate = WATER;
							}
						}
						
						j = k;
						
						if (j1 >= i - 1) {
							chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
						} else if (j1 < i - 7 - k) {
							iblockstate = AIR;
							iblockstate1 = Blocks.PACKED_ICE.getDefaultState();
							chunkPrimerIn.setBlockState(i1, j1, l, GRAVEL);
						} else {
							chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
						}
					} else if (j > 0) {
						-- j;
						chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
						
						if (j == 0 && iblockstate1.getBlock() == Blocks.SAND) {
							j = rand.nextInt(4) + Math.max(0, j1 - 63);
							iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
						}
					}
				}
			}
		}
	}
}