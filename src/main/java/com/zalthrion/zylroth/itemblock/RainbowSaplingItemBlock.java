package com.zalthrion.zylroth.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RainbowSaplingItemBlock extends ItemBlock {
	
	private final static String[] subNames = {"rainbowBlueSapling", "rainbowRedSapling", "rainbowPurpleSapling", "rainbowYellowSapling", "rainbowGreenSapling"};
	
	public RainbowSaplingItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "tile.zylroth:" + subNames[stack.getItemDamage()];
	}
	
}