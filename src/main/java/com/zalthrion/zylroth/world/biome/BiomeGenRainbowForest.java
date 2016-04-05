package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.block.tree.TreeColor;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenRainbowForest extends BiomeGenBase {
	public BiomeGenRainbowForest(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 3;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRainbowPig.class, 4, 1, 2));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityUnicorn.class, 1, 1, 1));
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random rand) {
		int i = rand.nextInt(6);
		IBlockState leafState = Blocks.air.getDefaultState();
		switch (i) {
			case 0:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.RED);
				break;
			case 1:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.ORANGE);
				break;
			case 2:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.YELLOW);
				break;
			case 3:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.GREEN);
				break;
			case 4:
				leafState = BlockInit.rainbowLeafBlock2.getDefaultState().withProperty(RainbowLeafBlock2.COLOR, TreeColor.BLUE);
				break;
			case 5:
				leafState = BlockInit.rainbowLeafBlock2.getDefaultState().withProperty(RainbowLeafBlock2.COLOR, TreeColor.PURPLE);
				break;
		}
		return new WorldGenTrees(true, 4, Blocks.log.getDefaultState(), leafState, false);
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