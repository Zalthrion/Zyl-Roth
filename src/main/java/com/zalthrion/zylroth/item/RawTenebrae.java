package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class RawTenebrae extends ItemBase {
	
	private String name = "rawTenebrae";
	
	public RawTenebrae() {
		this.setNames(name);
		// setUnlocalizedName(Reference.MOD_ID + "_" + name);
		GameRegistry.registerItem(this, name);
		// setCreativeTab(ModTabs.Project_Exanimus);
		// setTextureName(Reference.MOD_ID + ":" + name);
	}
	
}
