package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class DarkShard extends ItemBase {
	
	private String name = "darkShard";
	
	public DarkShard() {
		
		this.setNames(name);
		// setUnlocalizedName(Reference.MOD_ID + "_" + name);
		GameRegistry.registerItem(this, name);
		// setCreativeTab(ModTabs.Project_Exanimus);
		// setTextureName(Reference.MOD_ID + ":" + name);
	}
	
}
