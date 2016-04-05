package com.zalthrion.zylroth.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class BiomeGenAutumnForest extends BiomeGenBase {
	public BiomeGenAutumnForest(BiomeProperties properties) {
		super(properties);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBadger.class, 1, 1, 1));
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random par1Random) {
		return new WorldGenTrees(true, 4, Blocks.log.getDefaultState(), BlockInit.iridisLeafBlock.getDefaultState(), false);
	}
	
	@Override public int getModdedBiomeFoliageColor(int original) {
		return 0xDB8018;
	}
	
	@Override public int getModdedBiomeGrassColor(int original) {
		return 0x4DAD0C;
	}
	
	@Override public int getSkyColorByTemp(float currentTemperature) {
		return 0x3CA7B5;
	}
}