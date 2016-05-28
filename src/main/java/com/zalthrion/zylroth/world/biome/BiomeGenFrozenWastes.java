package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class BiomeGenFrozenWastes extends Biome {
	public BiomeGenFrozenWastes(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.topBlock = ICE;
		this.fillerBlock = WATER;
	}
	
	@Override public void decorate(World worldIn, Random rand, BlockPos pos) {}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x1DC3F6;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x1DC3F6;
	}

	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x3CA7B5;
	}
	
	@Override public Biome.TempCategory getTempCategory() {
		return Biome.TempCategory.COLD;
	}
}