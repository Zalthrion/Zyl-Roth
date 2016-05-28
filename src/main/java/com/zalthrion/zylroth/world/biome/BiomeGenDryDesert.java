package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import com.zalthrion.zylroth.world.mapstructures.DesertHouse;
import com.zalthrion.zylroth.world.mapstructures.TreasureWell;

public class BiomeGenDryDesert extends Biome {
	
	public BiomeGenDryDesert(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.theBiomeDecorator.generateLakes = false;
		
		this.topBlock = Blocks.SAND.getDefaultState();
		this.fillerBlock = Blocks.SAND.getDefaultState();
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0xE2C976;
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0xE2C976;
	}
	
	@Override public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
	@Override public void decorate(World world, Random rand, BlockPos pos) {
		super.decorate(world, rand, pos);
		
		if (rand.nextInt(100) < 5) {
			int k = pos.getX() + rand.nextInt(16) + 8;
			int l = pos.getZ() + rand.nextInt(16) + 8;
			
			DesertHouse desertHouse = new DesertHouse();
			TreasureWell treasureWell = new TreasureWell();
			
			if (rand.nextInt(100) < 50) {
				desertHouse.generate(world, rand, world.getHeight(new BlockPos(k, 0, l)).up());
			} else {
				treasureWell.generate(world, rand, world.getHeight(new BlockPos(k, 0, l)).up());
			}
		}
		
		if (rand.nextInt(100) < 15) {
			int k = pos.getX() + rand.nextInt(16) + 8;
			int l = pos.getZ() + rand.nextInt(16) + 8;
			
			DesertHouse desertHouse = new DesertHouse();
			
			desertHouse.generate(world, rand, world.getHeight(new BlockPos(k, 0, l)).up());
		}
	}
}