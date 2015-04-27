package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSapphireOcean extends BiomeGenBase {
	
	public BiomeGenSapphireOcean(int id) {
		super(id);
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = (Blocks.flowing_water).getDefaultState();
		this.fillerBlock = (Blocks.flowing_water).getDefaultState();
		
		this.setBiomeName("Sapphire Ocean");
		this.setHeight(height_Oceans);
		
		this.waterColorMultiplier = 0x38CAE0;
		
	}
	
	public BiomeGenBase.TempCategory getTempCategory() {
		return BiomeGenBase.TempCategory.OCEAN;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x0CA833;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0x16BA40;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}