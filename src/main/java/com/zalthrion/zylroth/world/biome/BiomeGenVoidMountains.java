package com.zalthrion.zylroth.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoidMountains extends BiomeGenBase {
	public BiomeGenVoidMountains(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x423E45;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x423E45;
	}
	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x1E2224;
	}
}