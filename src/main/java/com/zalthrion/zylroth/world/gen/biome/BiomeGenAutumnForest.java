package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenAutumnForest extends BiomeGenBase {
	
	public BiomeGenAutumnForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = (Blocks.grass).getDefaultState();
		this.fillerBlock = (Blocks.dirt).getDefaultState();
		
		this.setHeight(height_MidPlains);
		this.setBiomeName("Autumn Forest");
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x4DAD0C;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0xDB8018;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}