package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class UnstableTenebraeEssence extends ItemBase {
	
	private String name = "unstableTenebraeEssence";
	
	public UnstableTenebraeEssence() {
		this.setNames(name);
		// setUnlocalizedName(Reference.MOD_ID + "_" + name);
		GameRegistry.registerItem(this, name);
		// setCreativeTab(ModTabs.Project_Exanimus);
		// setTextureName(Reference.MOD_ID + ":" + name);
	}
	
}
