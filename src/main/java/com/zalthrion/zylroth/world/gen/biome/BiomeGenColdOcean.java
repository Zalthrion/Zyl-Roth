package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenColdOcean extends BiomeGenBase {
	
	public BiomeGenColdOcean(int id) {
		super(id);
		
		this.setDisableRain();
		this.setEnableSnow();
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = Blocks.ice.getDefaultState();
		this.fillerBlock = Blocks.packed_ice.getDefaultState();
		
		this.setBiomeName("Cold Ocean");
		this.setHeight(height_Oceans);
		
		this.waterColorMultiplier = 0x38CAE0;
		
		this.setTemperatureRainfall(0.3F, 0.5F);
	}
	
	@Override public BiomeGenBase.TempCategory getTempCategory() {
		return BiomeGenBase.TempCategory.OCEAN;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x1DC3F6;
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x1DC3F6;
	}
	
	@Override public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
}