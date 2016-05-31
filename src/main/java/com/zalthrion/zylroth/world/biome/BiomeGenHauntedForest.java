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
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenHauntedForest extends Biome {
	public BiomeGenHauntedForest(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityUndeadMinion.class, 2, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityUndeadWarrior.class, 1, 1, 1));
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random rand) {
		return new WorldGenTrees(true, 4, BlockInit.KYRUL_LOG_BLOCK.getDefaultState(), BlockInit.KYRUL_LEAF_BLOCK.getDefaultState(), false);
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x473A52;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x3B314D;
	}
	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x151617;
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
				} else if (iblockstate2.getBlock() == BlockInit.VOID_STONE) {
					if (j == -1) {
						if (k <= 0) {
							iblockstate = AIR;
							iblockstate1 = BlockInit.VOID_STONE.getDefaultState();
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
							iblockstate1 = BlockInit.VOID_STONE.getDefaultState();
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