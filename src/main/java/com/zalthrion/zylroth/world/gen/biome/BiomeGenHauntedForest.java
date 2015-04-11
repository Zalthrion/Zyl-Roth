package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenHauntedForest extends BiomeGenBase {
	
	public BiomeGenHauntedForest(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
		this.setHeight(height_Default);
		this.setBiomeName("Haunted Forest");
		
		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x3B314D;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x473A52;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x474747;
	}
	
}