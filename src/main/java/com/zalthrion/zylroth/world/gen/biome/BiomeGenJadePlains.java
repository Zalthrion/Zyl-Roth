package com.zalthrion.zylroth.world.gen.biome;

import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenJadePlains extends BiomeGenBase {
	
//	public final Material blockMaterial;
	
	public BiomeGenJadePlains(int id) {
		super(id);
		
//		this.blockMaterial = Material.water;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.flowers.clear();
		
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
        this.addFlower(Blocks.red_flower,    4,  3);
        this.addFlower(Blocks.red_flower,    5,  3);
        this.addFlower(Blocks.red_flower,    6,  3);
        this.addFlower(Blocks.red_flower,    7,  3);
        this.addFlower(Blocks.red_flower,    0, 20);
        this.addFlower(Blocks.red_flower,    3, 20);
        this.addFlower(Blocks.red_flower,    8, 20);
        this.addFlower(Blocks.yellow_flower, 0, 30);
		
        this.setHeight(height_LowPlains);
		this.setBiomeName(StatCollector.translateToLocal("biome" + "." + Reference.MOD_ID + ":" + "jadePlains")
);
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x0CA833;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x16BA40;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}