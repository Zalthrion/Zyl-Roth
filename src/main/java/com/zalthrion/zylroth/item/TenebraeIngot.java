package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TenebraeIngot extends ItemBase {
	
	private String name = "tenebraeIngot";
	
	public TenebraeIngot() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}