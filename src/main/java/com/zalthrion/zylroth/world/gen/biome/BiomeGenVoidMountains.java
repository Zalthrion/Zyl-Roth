package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoidMountains extends BiomeGenBase {
	
	public BiomeGenVoidMountains(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = 0; //TODO If flowers and trees still generate, change this to -999
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
		
		this.setHeight(height_HighPlateaus);
		this.setBiomeName("Void Mountains");
		
		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x423E45;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0x423E45;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x1E2224;
	}
}