package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.entity.EntityRainbowPig;

public class BiomeGenRainbowForest extends BiomeGenBase {
	
	public BiomeGenRainbowForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 3;
		
		this.topBlock = (Blocks.grass).getDefaultState();
		this.fillerBlock = (Blocks.dirt).getDefaultState();
		
		this.setHeight(height_LowIslands);
		this.setBiomeName("Rainbow Forest");
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRainbowPig.class, 4, 1, 2));
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x9BD61C;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0x11ADC2;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}