package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.ModTabs;

import cpw.mods.fml.common.registry.GameRegistry;

public class UnstableTenebraeEssence extends ItemBase {
	
	private String name = "unstableTenebraeEssence";
	
	public UnstableTenebraeEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}