package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.world.gen.structures.TreeGenerator;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenSakuraForest extends BiomeGenBase {
	
	public BiomeGenSakuraForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 4;
		this.theBiomeDecorator.grassPerChunk = 4;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
		this.setHeight(height_MidPlains);
		this.setBiomeName("Sakura Forest");
				
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random par1Random) {
		return new TreeGenerator(true, 4, Blocks.log, ModBlocks.iridisLeafBlock, 0, 1, false);
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x6FC72B;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x6FC72B;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}