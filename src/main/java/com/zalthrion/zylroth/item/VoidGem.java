package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class VoidGem extends ItemBase {
	
	private String name = "voidGem";
	
	public VoidGem() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}