package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.world.gen.structures.TreeGenerator;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenAutumnForest extends BiomeGenBase {
	
	@SuppressWarnings("unchecked")
	public BiomeGenAutumnForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
		this.setHeight(height_MidPlains);
		this.setBiomeName("Autumn Forest");
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBadger.class, 1, 1, 1));
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random par1Random) {
		return new TreeGenerator(true, 4, Blocks.log, ModBlocks.iridisLeafBlock, 0, 0, false);
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x4DAD0C;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0xDB8018;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}