package com.zalthrion.zylroth.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class BlockBase extends Block {
	
	/* Constructors */
	
	public BlockBase(Material material) {
		super(material);
	}
	
	/* Custom Methods */
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public BlockBase setCreativeTab() {
		this.setCreativeTab(ZylrothTab.zylRoth);
		return this;
	}
	
	public void setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
	/* Overridden */
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}