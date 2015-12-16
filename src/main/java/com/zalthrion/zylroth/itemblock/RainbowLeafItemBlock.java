package com.zalthrion.zylroth.itemblock;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.reference.Reference;

public class RainbowLeafItemBlock extends ItemBlock {
	private final static String[] subNames = {"rainbowRedLeaves", "rainbowOrangeLeaves", "rainbowYellowLeaves", "rainbowGreenLeaves", "rainbowBlueLeaves", "rainbowPurpleLeaves"};
	
	public RainbowLeafItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		try {
			return "tile.zylroth:" + subNames[/*this.block == ModBlocks.rainbowLeafBlockZL ? stack.getItemDamage() : stack.getItemDamage() + 4*/ stack.getItemDamage()];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "tile.zylroth:null.name";
		}
	}
	
	public static String[] getVariants() {
		ArrayList<String> variants = new ArrayList<String>();
		for (String variant : subNames) {
			variants.add(Reference.RESOURCE_PREFIX + variant.replace("rainbow", "").replace("Leaves", "").toLowerCase() + "_leaves");
		}
		return variants.toArray(new String[] {});
	}
	
	public static String[] getVariants(int blockType) {
		ArrayList<String> variants = new ArrayList<String>();
		for (int i = (blockType == 0 ? 0 : 4); i < (blockType == 0 ? 4 : 6); i ++) {
			String variant = subNames[i];
			variants.add(Reference.RESOURCE_PREFIX + variant.replace("rainbow", "").replace("Leaves", "").toLowerCase() + "_leaves");
		}
		return variants.toArray(new String[] {});
	}
}