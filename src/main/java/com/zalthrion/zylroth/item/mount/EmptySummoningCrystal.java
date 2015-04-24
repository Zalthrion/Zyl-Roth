package com.zalthrion.zylroth.item.mount;

import com.zalthrion.zylroth.item.ItemBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class EmptySummoningCrystal extends ItemBase {
	
	private String name = "emptySummoningCrystal";
	
	public EmptySummoningCrystal() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}
