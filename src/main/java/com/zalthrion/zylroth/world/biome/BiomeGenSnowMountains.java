package com.zalthrion.zylroth.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeGenSnowMountains extends Biome {
	public BiomeGenSnowMountains(BiomeProperties properties) {
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
}