package com.zalthrion.zylroth.item.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class IridisSaplingItemBlock extends ItemBlock {
	private final static String[] subNames = {"autumnTreeSapling"};
	
	public IridisSaplingItemBlock(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}
	
	/* Custom Methods */
	
	public static String[] getVariants() {
		ArrayList<String> variants = new ArrayList<String>();
		for (String variant : subNames) {
			variants.add(variant.replace("Sapling", "").toLowerCase() + "_sapling");
		}
		return variants.toArray(new String[] {});
	}
	
	/* Overridden */
	
	@Override public int getMetadata(int damage) {
		return damage;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		return stack.getItemDamage() <= subNames.length ? "tile.zylroth:" + subNames[stack.getItemDamage()] : "general.zylroth:unavailable";
	}
}