package com.zalthrion.zylroth.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeGenColdOcean extends Biome {
	public BiomeGenColdOcean(BiomeProperties properties) {
		super(properties);
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = ICE;
		this.fillerBlock = Blocks.PACKED_ICE.getDefaultState();
	}
	
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
		return Biome.TempCategory.OCEAN;
	}
}