package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoulEssence extends ItemBase {
	
	private String name = "soulEssence";
	
	public SoulEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}