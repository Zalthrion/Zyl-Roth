package com.zalthrion.zylroth.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RainbowLeaf2ItemBlock extends ItemBlock {
	
	private final static String[] subNames = {"rainbowGreenLeaves"};
	
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
		return "tile.zylroth:" + subNames[stack.getCurrentDurability()];
	}
}
