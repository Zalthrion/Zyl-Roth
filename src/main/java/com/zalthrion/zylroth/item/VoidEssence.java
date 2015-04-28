package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class VoidEssence extends ItemBase {
	
	private String name = "unstableTenebraeEssence";
	
	public VoidEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}