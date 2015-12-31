package com.zalthrion.zylroth.itemblock;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RainbowSaplingItemBlock extends ItemBlock {
	private final static String[] subNames = {"rainbowRedSapling", "rainbowOrangeSapling", "rainbowYellowSapling", "rainbowGreenSapling", "rainbowBlueSapling", "rainbowPurpleSapling"};
	
	public RainbowSaplingItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		try {
			return "tile.zylroth:" + subNames[stack.getItemDamage()];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "tile.zylroth:null.name";
		}
	}
	
	public static String[] getVariants() {
		ArrayList<String> variants = new ArrayList<String>();
		for (String variant : subNames) {
			variants.add(variant.replace("rainbow", "").replace("Sapling", "").toLowerCase() + "_sapling");
		}
		return variants.toArray(new String[] {});
	}
}