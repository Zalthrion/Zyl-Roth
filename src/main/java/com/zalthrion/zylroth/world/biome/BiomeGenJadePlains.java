package com.zalthrion.zylroth.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenJadePlains extends BiomeGenBase {
	public BiomeGenJadePlains(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
		
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 20);
		this.addFlower(Blocks.red_flower.getDefaultState(), 20);
		this.addFlower(Blocks.red_flower.getDefaultState(), 20);
		this.addFlower(Blocks.yellow_flower.getDefaultState(), 30);
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x16BA40;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x0CA833;
	}
	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x3CA7B5;
	}
}