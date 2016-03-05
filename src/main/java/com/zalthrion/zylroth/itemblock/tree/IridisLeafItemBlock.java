package com.zalthrion.zylroth.itemblock.tree;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.reference.Reference;

public class IridisLeafItemBlock extends ItemBlock {
	private final static String[] subNames = {"autumnTreeLeaves"};
	
	public IridisLeafItemBlock(Block id) {
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
	
	public static String[] getVariants() {
		ArrayList<String> variants = new ArrayList<String>();
		for (String variant : subNames) {
			variants.add(Reference.RESOURCE_PREFIX + variant.replace("Leaves", "").toLowerCase() + "_leaves");
		}
		return variants.toArray(new String[] {});
	}
	
	public static String[] getVariants(int blockType) {
		ArrayList<String> variants = new ArrayList<String>();
		for (int i = (blockType == 0 ? 0 : 4); i < (blockType == 0 ? 4 : 6); i ++) {
			String variant = subNames[i];
			variants.add(variant.replace("Leaves", "").toLowerCase() + "_leaves");
		}
		return variants.toArray(new String[] {});
	}
}