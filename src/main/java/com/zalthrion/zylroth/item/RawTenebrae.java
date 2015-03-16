package com.zalthrion.zylroth.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class RawTenebrae extends ItemBase {
	
	private String name = "rawTenebrae";
	
	public RawTenebrae() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}