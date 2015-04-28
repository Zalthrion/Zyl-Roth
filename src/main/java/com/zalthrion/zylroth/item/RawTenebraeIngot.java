package com.zalthrion.zylroth.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class RawTenebraeIngot extends ItemBase {
	
	private String name = "rawTenebraeIngot";
	
	public RawTenebraeIngot() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}