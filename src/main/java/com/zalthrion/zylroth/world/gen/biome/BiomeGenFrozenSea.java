package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenFrozenSea extends BiomeGenBase {
	
	public BiomeGenFrozenSea(int id) {
		super(id);
		
		this.setDisableRain();
		this.setEnableSnow();
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = (Blocks.ice);
		this.fillerBlock = (Blocks.packed_ice);
		
		this.setBiomeName("Frozen Sea");
		this.setHeight(height_Oceans);
		
		this.waterColorMultiplier = 0x3CA7B5;
		
		this.setTemperatureRainfall(0.0F, 0.5F);
	}
	
	public BiomeGenBase.TempCategory getTempCategory() {
		return BiomeGenBase.TempCategory.OCEAN;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x1DC3F6;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x1DC3F6;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
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
			}
			else {
				Block block2 = p_150573_3_[i2];
				
				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == Blocks.packed_ice) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = Blocks.packed_ice;
							}
							else if (l1 >= 59 && l1 <= 64) {
								block = this.topBlock;
								b0 = (byte) (this.topBlockMetadata & 255);
								block1 = this.fillerBlock;
							}
							
							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(p_150573_5_, l1, p_150573_6_) < 0.15F) {
									block = Blocks.ice;
									b0 = 0;
								}
								else {
									block = Blocks.water;
									b0 = 0;
								}
							}
							
							k = l;
							
							if (l1 >= 62) {
								p_150573_3_[i2] = block;
								p_150573_4_[i2] = b0;
							}
							else {
								p_150573_3_[i2] = block1;
							}
						}
					}
				}
				else {
					k = -1;
				}
			}
		}
	}
}