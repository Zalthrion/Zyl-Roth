package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.zalthrion.zylroth.block.BlockBase;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;

public class EndiriteOre extends BlockBase {
	
	private String name = "endiriteOre";
	
	public EndiriteOre() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return ModItems.endiriteChunk;
	}
	
	public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(4);
	}	
}