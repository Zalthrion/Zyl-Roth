package com.zalthrion.zylroth.itemblock.tree;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class IridisSaplingItemBlock extends ItemBlockWithMetadata {
	
	private final static String[] subNames = {"autumnTreeSapling", "sakuraTreeSapling"};
	
	public IridisSaplingItemBlock(Block id) {
		super(id, id);
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
