package com.zalthrion.zylroth.itemblock.tree;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class IridisSaplingItemBlock extends ItemBlock {
	private final static String[] subNames = {"autumnTreeSapling"};
	
	public IridisSaplingItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		return stack.getItemDamage() <= subNames.length ? "tile.zylroth:" + subNames[stack.getItemDamage()] : "general.zylroth:unavailable";
	}
	
	public static String[] getVariants() {
		ArrayList<String> variants = new ArrayList<String>();
		for (String variant : subNames) {
			variants.add(variant.replace("Sapling", "").toLowerCase() + "_sapling");
		}
		return variants.toArray(new String[] {});
	}
}