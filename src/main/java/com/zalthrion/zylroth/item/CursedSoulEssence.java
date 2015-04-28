package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CursedSoulEssence extends ItemBase {
	
	private String name = "cursedSoulEssence";
	
	public CursedSoulEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}