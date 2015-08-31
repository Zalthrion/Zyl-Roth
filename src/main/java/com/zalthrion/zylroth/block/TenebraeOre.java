package com.zalthrion.zylroth.block;

import java.util.Random;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class TenebraeOre extends BlockBase {
	
	private String name = "tenebraeOre";
	
	public TenebraeOre() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	public void randomDisplayTick(World par1World, int x, int y, int z, Random par5Random) {
		super.randomDisplayTick(par1World, x, y, z, par5Random);
		
		double d0 = (double) ((float) x + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
		double d1 = (double) ((float) y + 0.4F);
		double d2 = (double) ((float) z + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
	}
	
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return ModItems.raw_Tenebrae;
	}
	
	public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(4);
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0) {
			int j = random.nextInt(fortune + 2) - 1;
			
			if (j < 0) {
				j = 0;
			}
			
			return quantityDropped(random) * (j + 1);
		}
		
		else {
			return quantityDropped(random);
		}
	}
	
}