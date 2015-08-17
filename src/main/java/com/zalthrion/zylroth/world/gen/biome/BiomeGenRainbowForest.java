package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.entity.EntityRainbowPig;

public class BiomeGenRainbowForest extends BiomeGenBase {
	
	@SuppressWarnings("unchecked")
	public BiomeGenRainbowForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 3;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
		this.setHeight(height_LowIslands);
		this.setBiomeName("Rainbow Forest");
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRainbowPig.class, 4, 1, 2));
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x9BD61C;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x11ADC2;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}