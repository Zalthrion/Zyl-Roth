package com.zalthrion.zylroth.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class RainbowSapling2ItemBlock extends ItemBlockWithMetadata {
	
	private final static String[] subNames = {"rainbowGreenSapling"};
	
	public RainbowSapling2ItemBlock(Block id) {
		super(id, id);
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
