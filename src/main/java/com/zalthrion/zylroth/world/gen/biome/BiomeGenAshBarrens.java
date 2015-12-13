package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.lib.ModBlocks;

public class BiomeGenAshBarrens extends BiomeGenBase {
	
	public BiomeGenAshBarrens(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = (ModBlocks.ashBlock);
		this.fillerBlock = (ModBlocks.ashBlock);
		
		this.setHeight(height_Default);
		this.setBiomeName("Ash Barrens");
		
		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x423E45;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x423E45;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x1E2224;
	}
	
}