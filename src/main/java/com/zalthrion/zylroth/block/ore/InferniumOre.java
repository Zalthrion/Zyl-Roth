package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.zalthrion.zylroth.block.BlockBase;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;

public class InferniumOre extends BlockBase {
	
	private String name = "inferniumOre";
	
	public InferniumOre() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return ModItems.rawInfernium;
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