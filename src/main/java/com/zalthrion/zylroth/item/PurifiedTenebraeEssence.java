package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class PurifiedTenebraeEssence extends ItemBase {
	
	private String name = "purifiedTenebraeEssence";
	
	public PurifiedTenebraeEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}