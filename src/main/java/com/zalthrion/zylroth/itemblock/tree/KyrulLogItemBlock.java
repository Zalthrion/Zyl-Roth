package com.zalthrion.zylroth.itemblock.tree;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class KyrulLogItemBlock extends ItemBlock {
	private final static String[] subNames = {"voidWood"};
	
	public KyrulLogItemBlock(Block id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return stack.getItemDamage() <= subNames.length ? "tile.zylroth:" + subNames[stack.getItemDamage()] : "general.zylroth:unavailable";
	}
}