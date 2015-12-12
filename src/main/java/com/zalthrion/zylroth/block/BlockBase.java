package com.zalthrion.zylroth.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

public class BlockBase extends Block {
	
	public BlockBase(Material material) {
		super(material);
	}
	
	public BlockBase(Material material, boolean setCreativeTab) {
		super(material);
		if (setCreativeTab) this.setCreativeTab(ModTabs.zylRoth);
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}