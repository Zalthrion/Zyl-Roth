package com.zalthrion.zylroth.world.gen.biome;

import java.util.List;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.lib.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenAshBarrens extends BiomeGenBase {
	
	public final Material blockMaterial;
	
	public BiomeGenAshBarrens(int id) {
		super(id);

		this.blockMaterial = Material.sand;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 8;
        this.theBiomeDecorator.deadBushPerChunk = 2;
		
		this.topBlock = (ModBlocks.Ash_Block);
		this.fillerBlock = (ModBlocks.Ash_Block);
		
		this.setHeight(height_Default);
		
		this.setBiomeName("Ash Barrens");
		
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