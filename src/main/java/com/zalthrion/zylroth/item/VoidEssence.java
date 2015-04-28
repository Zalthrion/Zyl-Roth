package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class VoidEssence extends ItemBase {
	
	private String name = "unstableTenebraeEssence";
	
	public VoidEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}