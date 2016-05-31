package com.zalthrion.zylroth.item.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.utility.LogHelper;

public class RainbowLeafItemBlock extends ItemBlock {
	private final static String[] subNames = {"rainbowRedLeaves", "rainbowOrangeLeaves", "rainbowYellowLeaves", "rainbowGreenLeaves", "rainbowBlueLeaves", "rainbowPurpleLeaves"};
	
	public RainbowLeafItemBlock(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}
	
	/* Custom Methods */
	
	public static String[] getVariants(int blockType) {
		ArrayList<String> variants = new ArrayList<String>();
		for (int i = (blockType == 0 ? 0 : 4); i < (blockType == 0 ? Math.min(subNames.length, 4) : Math.min(subNames.length, 8)); i ++) {
			String variant = subNames[i];
			variants.add(variant.replace("rainbow", "").replace("Leaves", "").toLowerCase() + "_leaves");
		}
		for (String s : variants) LogHelper.warn("Variant: " + s);
		return variants.toArray(new String[] {});
	}
	
	/* Overridden */
	
	@Override public int getMetadata(int damage) {
		return damage;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		return stack.getItemDamage() < subNames.length ? "tile.zylroth:" + subNames[stack.getItemDamage()] : "general.zylroth:unavailable";
	}
}