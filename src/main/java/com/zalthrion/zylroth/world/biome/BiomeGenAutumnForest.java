package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenAutumnForest extends Biome {
	public BiomeGenAutumnForest(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityBadger.class, 1, 1, 1));
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random par1Random) {
		return new WorldGenTrees(true, 4, Blocks.LOG.getDefaultState(), BlockInit.IRIDIS_LEAF_BLOCK.getDefaultState(), false);
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0x4DAD0C;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x4DAD0C;
	}
	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x3CA7B5;
	}
}