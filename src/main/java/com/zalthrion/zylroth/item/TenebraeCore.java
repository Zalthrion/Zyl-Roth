package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class TenebraeCore extends ItemBase {
	
	private String name = "tenebraeCore";
	
	public TenebraeCore() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}
