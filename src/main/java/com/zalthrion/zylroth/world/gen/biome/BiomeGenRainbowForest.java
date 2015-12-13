package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.lib.ModBlocks;

public class BiomeGenRainbowForest extends BiomeGenBase {
	
	public BiomeGenRainbowForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 3;
		
		this.topBlock = (Blocks.grass).getDefaultState();
		this.fillerBlock = (Blocks.dirt).getDefaultState();
		
		this.setHeight(height_LowIslands);
		this.setBiomeName("Rainbow Forest");
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRainbowPig.class, 4, 1, 2));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityUnicorn.class, 1, 1, 1));
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public WorldGenAbstractTree genBigTreeChance(Random par1Random) {
		int i = par1Random.nextInt(6);
		return new WorldGenTrees(true, 4, Blocks.log.getDefaultState(), ModBlocks.rainbowLeafBlockZL.getStateFromMeta(i), false);
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x9BD61C;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0x60E409;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
}