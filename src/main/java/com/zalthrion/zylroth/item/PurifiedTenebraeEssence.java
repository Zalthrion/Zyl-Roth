package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.ModTabs;

import cpw.mods.fml.common.registry.GameRegistry;

public class PurifiedTenebraeEssence extends ItemBase {
	
	private String name = "purifiedTenebraeEssence";
	
	public PurifiedTenebraeEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}