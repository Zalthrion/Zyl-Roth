package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.lib.ModBlocks;

public class BiomeGenAutumnForest extends BiomeGenBase {
	
	public BiomeGenAutumnForest(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = (Blocks.grass).getDefaultState();
		this.fillerBlock = (Blocks.dirt).getDefaultState();
		
		this.setHeight(height_MidPlains);
		this.setBiomeName("Autumn Forest");
		
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBadger.class, 1, 1, 1));
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override public WorldGenAbstractTree genBigTreeChance(Random par1Random) {
		return new WorldGenTrees(true, 4, Blocks.log.getDefaultState(), ModBlocks.iridisLeafBlock.getDefaultState(), false);
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x4DAD0C;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0xDB8018;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
}