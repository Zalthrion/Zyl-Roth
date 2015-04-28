package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class UnstableTenebraeCore extends ItemBase {
	
	private String name = "tenebraeCore";
	
	public UnstableTenebraeCore() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}
