package com.zalthrion.zylroth.item.mount;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.item.ItemBase;

public class EmptySummoningCrystal extends ItemBase {
	
	private String name = "emptySummoningCrystal";
	
	public EmptySummoningCrystal() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}
