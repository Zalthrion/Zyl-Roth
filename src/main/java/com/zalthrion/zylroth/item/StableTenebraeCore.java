package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class StableTenebraeCore extends ItemBase {
	
	private String name = "purifiedTenebraeEssence";
	
	public StableTenebraeCore() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}