package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenJadePlains extends BiomeGenBase {
	
	public BiomeGenJadePlains(int id) {
		super(id);
		
		// this.blockMaterial = Material.water;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = (Blocks.grass).getDefaultState();
		this.fillerBlock = (Blocks.dirt).getDefaultState();
		
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 3);
		this.addFlower(Blocks.red_flower.getDefaultState(), 20);
		this.addFlower(Blocks.red_flower.getDefaultState(), 20);
		this.addFlower(Blocks.red_flower.getDefaultState(), 20);
		this.addFlower(Blocks.yellow_flower.getDefaultState(), 30);
		
		this.setHeight(height_LowPlains);
		this.setBiomeName("Jade Plains");
		
		this.waterColorMultiplier = 0x38CAE0;
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