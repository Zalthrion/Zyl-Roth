package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import com.zalthrion.zylroth.world.gen.structures.DesertHouse;
import com.zalthrion.zylroth.world.gen.structures.TreasureWell;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDryDesert extends BiomeGenBase {
	
	public BiomeGenDryDesert(int id) {
		super(id);
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		
		this.theBiomeDecorator.generateLakes = false;
		
		this.topBlock = (Blocks.sand);
		this.fillerBlock = (Blocks.sand);
		
		this.setBiomeName("Dry Desert");
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0xE2C976;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0xE2C976;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
	@Override
	public boolean canSpawnLightningBolt() {
		return false;
	}
	
	@Override
	public void decorate(World world, Random rand, int x, int z) {
		super.decorate(world, rand, x, z);
		
		if (rand.nextInt(100) < 5) {
			int k = x + rand.nextInt(16) + 8;
			int l = z + rand.nextInt(16) + 8;
			
			DesertHouse desertHouse = new DesertHouse();
			TreasureWell treasureWell = new TreasureWell();
			
			if(rand.nextInt(100) < 50) {
			desertHouse.generate(world, rand, k, world.getHeightValue(k, l) + 1, l);
			} else {
				treasureWell.generate(world, rand, k, world.getHeightValue(k, l) + 1, 1);
			}
		}
		
		if (rand.nextInt(100) < 15) {
			int k = x + rand.nextInt(16) + 8;
			int l = z + rand.nextInt(16) + 8;
			
			DesertHouse desertHouse = new DesertHouse();
			
			desertHouse.generate(world, rand, k, world.getHeightValue(k, l) + 1, l);
		}
	}
}