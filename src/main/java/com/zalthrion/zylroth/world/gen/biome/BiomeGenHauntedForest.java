package com.zalthrion.zylroth.world.gen.biome;

import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenHauntedForest extends BiomeGenBase {
	
	public BiomeGenHauntedForest(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
		
		this.topBlock = (Blocks.grass).getDefaultState();
		this.fillerBlock = (Blocks.dirt).getDefaultState();
		
		this.setHeight(height_Default);
		this.setBiomeName("Haunted Forest");
		
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityUndeadMinion.class, 2, 1, 1));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityUndeadWarrior.class, 1, 1, 1));
		
		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x3B314D;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0x473A52;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x151617;
	}
}