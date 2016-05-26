package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import com.zalthrion.zylroth.world.gen.structures.BenzennHut;
import com.zalthrion.zylroth.world.gen.structures.IceHouse;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSnowPlateau extends BiomeGenBase {
	
	public BiomeGenSnowPlateau(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.topBlock = (Blocks.snow);
		this.fillerBlock = (Blocks.snow);
		
		this.setHeight(height_HighPlateaus);
		this.setBiomeName("Snow Plateau");
		
		this.setEnableSnow();
		this.setTemperatureRainfall(0.0F, 0.5F);
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x0CA833;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x16BA40;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
	@Override
	public void decorate(World world, Random rand, int x, int z) {
		super.decorate(world, rand, x, z);
		
		if (rand.nextInt(100) < 5) {
			int k = x + rand.nextInt(16) + 8;
			int l = z + rand.nextInt(16) + 8;
			
			BenzennHut benzennHut = new BenzennHut();
			benzennHut.generate(world, rand, k, world.getHeightValue(k, l) + 1, l);
		}
		
		if (rand.nextInt(100) < 15) {
			int k = x + rand.nextInt(16) + 8;
			int l = z + rand.nextInt(16) + 8;
			
			IceHouse iceHouse = new IceHouse();
			iceHouse.generate(world, rand, k, world.getHeightValue(k, l) + 1, l);
		}
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
					if (block2 == Blocks.packed_ice) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = Blocks.packed_ice;
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
								block1 = Blocks.packed_ice;
								p_150573_3_[i2] = Blocks.gravel;
							} else {
								p_150573_3_[i2] = block1;
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