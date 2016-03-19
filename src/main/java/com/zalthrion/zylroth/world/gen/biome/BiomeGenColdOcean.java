package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenColdOcean extends BiomeGenBase {
	
	public BiomeGenColdOcean(BiomeGenBase.BiomeProperties properties) {
		super(properties);
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = Blocks.ice.getDefaultState();
		this.fillerBlock = Blocks.packed_ice.getDefaultState();
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