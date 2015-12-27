package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import com.zalthrion.zylroth.block.BlockBase;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class VoidiumOre extends BlockBase {
	
	private String name = "voidiumOre";
	
	public VoidiumOre() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	public void randomDisplayTick(World par1World, int x, int y, int z, Random par5Random) {
		super.randomDisplayTick(par1World, x, y, z, par5Random);
		
		double d0 = (double) ((float) x + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
		double d1 = (double) ((float) y + 1.1F);
		double d2 = (double) ((float) z + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
		double d3 = -0.1F;
		double d4 = 0.2F;
		double d5 = 1.0F;
		par1World.spawnParticle("reddust", d0, d1, d2, d3, d4, d5);
	}
	
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return ModItems.tenebraeChunk;
	}
	
	public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(4);
	}
	
}