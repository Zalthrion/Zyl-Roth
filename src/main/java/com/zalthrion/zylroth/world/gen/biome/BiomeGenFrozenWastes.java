package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenFrozenWastes extends BiomeGenBase {
	
	public BiomeGenFrozenWastes(int id) {
		super(id);
		
		this.setDisableRain();
		this.setEnableSnow();
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.topBlock = Blocks.ice.getDefaultState();
		this.fillerBlock = Blocks.flowing_water.getDefaultState();
		
		this.setHeight(height_LowPlains);
		this.setBiomeName("Frozen Wastes");
		
		this.waterColorMultiplier = 0x38CAE0;
		
		this.setTemperatureRainfall(0.0F, 0.5F); 
	}
	
	@Override public BiomeGenBase.TempCategory getTempCategory() {
		return BiomeGenBase.TempCategory.COLD;
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
	
	@Override public void decorate(World world, Random rand, BlockPos pos) {}
}