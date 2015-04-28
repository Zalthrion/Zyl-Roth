package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class DarkShard extends ItemBase {
	
	private String name = "darkShard";
	
	public DarkShard() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}