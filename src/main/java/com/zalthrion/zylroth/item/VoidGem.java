package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class VoidGem extends ItemBase {
	
	private String name = "voidGem";
	
	public VoidGem() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}