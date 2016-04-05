package com.zalthrion.zylroth.item.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RainbowSaplingItemBlock extends ItemBlock {
	private final static String[] subNames = {"rainbowRedSapling", "rainbowOrangeSapling", "rainbowYellowSapling", "rainbowGreenSapling", "rainbowBlueSapling", "rainbowPurpleSapling"};
	
	public RainbowSaplingItemBlock(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}
	
	/* Custom Methods */
	
	public static String[] getVariants() {
		ArrayList<String> variants = new ArrayList<String>();
		for (String variant : subNames) {
			variants.add(variant.replace("rainbow", "").replace("Sapling", "").toLowerCase() + "_sapling");
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