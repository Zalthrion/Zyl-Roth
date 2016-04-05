package com.zalthrion.zylroth.item.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class IridisLeafItemBlock extends ItemBlock {
	private final static String[] subNames = {"autumnTreeLeaves"};
	
	public IridisLeafItemBlock(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}
	
	/* Custom Methods */
	
	public static String[] getVariants(int blockType) {
		ArrayList<String> variants = new ArrayList<String>();
		for (int i = (blockType == 0 ? 0 : 4); i < (blockType == 0 ? 4 : 6); i ++) {
			String variant = subNames[i];
			variants.add(variant.replace("Leaves", "").toLowerCase() + "_leaves");
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