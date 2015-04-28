package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class UnstableTenebraeCore extends ItemBase {
	
	private String name = "tenebraeCore";
	
	public UnstableTenebraeCore() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}