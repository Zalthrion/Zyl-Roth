package com.zalthrion.zylroth.world.gen.biome;

import java.util.List;

import com.zalthrion.zylroth.entity.EntityRainbowPig;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenJadePlains extends BiomeGenBase {
	
	public final Material blockMaterial;
	
	public BiomeGenJadePlains(int id) {
		super(id);
		
		this.blockMaterial = Material.water;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.flowers.clear();
		
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = 8;
		
		this.topBlock = (Blocks.grass);
		this.fillerBlock = (Blocks.dirt);
		
        this.setHeight(height_LowPlains);
		
        this.addFlower(Blocks.red_flower,    4,  3);
        this.addFlower(Blocks.red_flower,    5,  3);
        this.addFlower(Blocks.red_flower,    6,  3);
        this.addFlower(Blocks.red_flower,    7,  3);
        this.addFlower(Blocks.red_flower,    0, 20);
        this.addFlower(Blocks.red_flower,    3, 20);
        this.addFlower(Blocks.red_flower,    8, 20);
        this.addFlower(Blocks.yellow_flower, 0, 30);
        
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRainbowPig.class, 4 , 1, 2));
		
		this.setBiomeName("Jade Plains");
		
		this.waterColorMultiplier = 0x38CAE0;
	}
	
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x0EC93D;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x0EC93D;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
}