package com.zalthrion.zylroth.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import com.zalthrion.zylroth.lib.ModRegistry;

public class BiomeGenJadePlains extends Biome {
	public BiomeGenJadePlains(BiomeProperties properties) {
		super(properties);
		this.setRegistryName(ModRegistry.createRegistryNameFor("jadePlains"));
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 3);
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 3);
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 3);
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 3);
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 20);
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 20);
		this.addFlower(Blocks.RED_FLOWER.getDefaultState(), 20);
		this.addFlower(Blocks.YELLOW_FLOWER.getDefaultState(), 30);
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