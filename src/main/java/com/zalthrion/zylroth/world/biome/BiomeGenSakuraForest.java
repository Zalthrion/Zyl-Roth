package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.block.tree.IridisLeafBlock;
import com.zalthrion.zylroth.block.tree.IridisTreeType;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenSakuraForest extends Biome {
	public BiomeGenSakuraForest(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 4;
		this.theBiomeDecorator.grassPerChunk = 4;
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random par1Random) {
		return new WorldGenTrees(true, 4, Blocks.LOG.getDefaultState(), BlockInit.IRIDIS_LEAF_BLOCK.getDefaultState().withProperty(IridisLeafBlock.LEAF_TYPE, IridisTreeType.SAKURA), false);
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x6FC72B;
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x6FC72B;
	}
	
	@Override public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
}