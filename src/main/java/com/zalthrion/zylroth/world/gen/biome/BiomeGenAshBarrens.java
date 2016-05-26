package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import com.zalthrion.zylroth.lib.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenAshBarrens extends BiomeGenBase {
	
	public BiomeGenAshBarrens(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = (ModBlocks.ashBlock);
		this.fillerBlock = (ModBlocks.ashBlock);
		
		this.setHeight(height_Default);
		this.setBiomeName("Ash Barrens");
		
		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x423E45;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x423E45;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x1E2224;
	}
	
	@Override
	public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
		@SuppressWarnings("unused")
		boolean flag = true;
		Block block = this.topBlock;
		byte b0 = (byte) (this.topBlockMetadata & 255);
		Block block1 = this.fillerBlock;
		int k = -1;
		int l = (int) (p_150573_7_ / 3.0D + 3.0D + p_150573_2_.nextDouble() * 0.25D);
		int i1 = p_150573_5_ & 15;
		int j1 = p_150573_6_ & 15;
		int k1 = p_150573_3_.length / 256;
		
		for (int l1 = 255; l1 >= 0; -- l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;
			
			if (l1 <= 0 + p_150573_2_.nextInt(5)) {
				p_150573_3_[i2] = Blocks.bedrock;
			} else {
				Block block2 = p_150573_3_[i2];
				
				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == ModBlocks.voidStone) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = ModBlocks.voidStone;
							} else if (l1 >= 59 && l1 <= 64) {
								block = this.topBlock;
								b0 = (byte) (this.topBlockMetadata & 255);
								block1 = this.fillerBlock;
							}
							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(p_150573_5_, l1, p_150573_6_) < 0.15F) {
									block = Blocks.ice;
									b0 = 0;
								} else {
									block = Blocks.water;
									b0 = 0;
								}
							}
							
							k = l;
							
							if (l1 >= 62) {
								p_150573_3_[i2] = block;
								p_150573_4_[i2] = b0;
							} else if (l1 < 56 - l) {
								block = null;
								block1 = ModBlocks.voidStone;
								p_150573_3_[i2] = Blocks.gravel;
							} else {
								p_150573_3_[i2] = block1;
							}
						} else if (k > 0) {
							-- k;
							p_150573_3_[i2] = block1;
							
							if (k == 0 && block1 == Blocks.sand) {
								k = p_150573_2_.nextInt(4) + Math.max(0, l1 - 63);
								block1 = Blocks.sandstone;
							}
						}
					} else {
						k = -1;
					}
				}
			}
		}
	}
}