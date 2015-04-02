package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.ModTabs;

import cpw.mods.fml.common.registry.GameRegistry;

public class DarkShard extends ItemBase {
	
	private String name = "darkShard";
	
	public DarkShard() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}