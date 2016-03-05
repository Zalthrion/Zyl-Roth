package com.zalthrion.zylroth.itemblock.tree;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RainbowLeaf2ItemBlock extends ItemBlock {
	
	private final static String[] subNames = {"rainbowBlueLeaves", "rainbowPurpleLeaves"};
	
	public RainbowLeaf2ItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return stack.getCurrentDurability() <= subNames.length ? "tile.zylroth:" + subNames[stack.getCurrentDurability()] : "general.zylroth:unavailable";
	}
}
