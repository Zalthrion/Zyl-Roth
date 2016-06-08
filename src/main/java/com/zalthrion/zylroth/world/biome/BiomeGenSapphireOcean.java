package com.zalthrion.zylroth.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import com.zalthrion.zylroth.lib.ModRegistry;

public class BiomeGenSapphireOcean extends Biome {
	public BiomeGenSapphireOcean(BiomeProperties properties) {
		super(properties);
		this.setRegistryName(ModRegistry.createRegistryNameFor("sapphireOcean"));
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
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
	
	@Override public Biome.TempCategory getTempCategory() {
		return Biome.TempCategory.OCEAN;
	}
}