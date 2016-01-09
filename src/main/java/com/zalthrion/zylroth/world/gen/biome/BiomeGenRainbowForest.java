package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.world.gen.structures.TreeGenerator;

public class BiomeGenRainbowForest extends BiomeGenBase {
	
	@SuppressWarnings("unchecked")
	public BiomeGenRainbowForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 3;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
		this.setHeight(height_LowIslands);
		this.setBiomeName("Rainbow Forest");
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRainbowPig.class, 4, 1, 2));
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityUnicorn.class, 1, 1, 1));
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random par1Random) {
		int i = par1Random.nextInt(7);
		if (i <= 1) {
			return new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL, 0, 0, false);
		}
		else if (i <= 2) {
			return new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL, 0, 1, false);
		}
		else if (i <= 3) {
			return new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL, 0, 2, false);
		}
		else if (i <= 4) {
			return new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL, 0, 3, false);
		}
		else if (i <= 5) {
			return new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL_2, 0, 0, false);
		}
		
		else return new TreeGenerator(true, 4, Blocks.log, ModBlocks.rainbowLeafBlockZL_2, 0, 1, false);
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x9BD61C;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x60E409;
	}
	
	@Override public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}