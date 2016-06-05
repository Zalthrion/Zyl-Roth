package com.zalthrion.zylroth.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.utility.StringHelper;

public class RainbowLeafItemBlock extends ItemBlock {
	private RainbowLeafBlock leaves;
	private RainbowLeafBlock2 leaves2;
	
	public RainbowLeafItemBlock(Block block) {
		super(block);
		if (block instanceof RainbowLeafBlock) this.leaves = (RainbowLeafBlock) block;
		if (block instanceof RainbowLeafBlock2) this.leaves2 = (RainbowLeafBlock2) block;
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}
	
	/* Overridden */
	
	@Override public int getMetadata(int damage) {
		return damage | 4;
	}
	
	@Override public String getUnlocalizedName(ItemStack stack) {
		if (this.leaves == null && this.leaves2 == null) return "general.zylroth:unavailable";
		
		String ret = "";
		if (this.leaves != null) ret = "tile.zylroth:rainbow" + StringHelper.capitalizeFirstLetter(this.leaves.getTreeColor(stack.getItemDamage()).getName()) + "Leaves";
		else ret = "tile.zylroth:rainbow" + StringHelper.capitalizeFirstLetter(this.leaves2.getTreeColor(stack.getItemDamage()).getName()) + "Leaves";
		
		return ret;
	}
}