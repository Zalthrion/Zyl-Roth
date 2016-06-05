package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.block.tree.TreeVariantRainbow;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenRainbowForest extends Biome {
	public BiomeGenRainbowForest(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 3;
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRainbowPig.class, 4, 1, 2));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityUnicorn.class, 1, 1, 1));
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random rand) {
		int i = rand.nextInt(6);
		IBlockState leafState = Blocks.AIR.getDefaultState();
		switch (i) {
			case 0:
				leafState = BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.RED);
				break;
			case 1:
				leafState = BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.ORANGE);
				break;
			case 2:
				leafState = BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.YELLOW);
				break;
			case 3:
				leafState = BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.GREEN);
				break;
			case 4:
				leafState = BlockInit.RAINBOW_LEAF_BLOCK_2.getDefaultState().withProperty(RainbowLeafBlock2.VARIANT, TreeVariantRainbow.BLUE);
				break;
			case 5:
				leafState = BlockInit.RAINBOW_LEAF_BLOCK_2.getDefaultState().withProperty(RainbowLeafBlock2.VARIANT, TreeVariantRainbow.PURPLE);
				break;
		}
		return new WorldGenTrees(true, 4, Blocks.LOG.getDefaultState(), leafState, false);
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x9BD61C;
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x60E409;
	}
	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x3CA7B5;
	}
}