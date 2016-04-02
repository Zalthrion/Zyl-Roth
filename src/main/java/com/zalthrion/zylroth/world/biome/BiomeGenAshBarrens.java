package com.zalthrion.zylroth.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenAshBarrens extends BiomeGenBase {
	public BiomeGenAshBarrens(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = BlockInit.ashBlock.getDefaultState();
		this.fillerBlock = BlockInit.ashBlock.getDefaultState();
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