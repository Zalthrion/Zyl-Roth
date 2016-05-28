package com.zalthrion.zylroth.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class KyrulSaplingItemBlock extends ItemBlock {
	private final static String[] subNames = {"voidTreeSapling"};
	
	public KyrulSaplingItemBlock(Block id) {
		super(id);
		this.setHasSubtypes(true);
	}
	
	@Override public int getMetadata(int damageValue) {
		return damageValue;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		return stack.getItemDamage() <= subNames.length ? "tile.zylroth:" + subNames[stack.getItemDamage()] : "general.zylroth:unavailable";
	}
}