package com.zalthrion.zylroth.world.gen.biome;

import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.reference.Reference;

public class BiomeGenVoidMountains extends BiomeGenBase {
	
	@SuppressWarnings("unchecked")
	public BiomeGenVoidMountains(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.flowers.clear();
		
	    this.theBiomeDecorator.generateLakes = false;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.stone);
		
		this.setHeight(height_HighPlateaus);
		this.setBiomeName(StatCollector.translateToLocal("biome" + "." + Reference.MOD_ID + ":" + "voidMountains"));
		
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityUndeadMinion.class, 2 , 1, 1));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityUndeadWarrior.class, 1 , 1, 1));

		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x423E45;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x423E45;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x474747;
	}
	
}