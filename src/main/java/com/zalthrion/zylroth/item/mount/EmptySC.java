package com.zalthrion.zylroth.item.mount;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.item.ItemBase;

public class EmptySC extends ItemBase {
	
	private String name = "emptySummoningCrystal";
	
	public EmptySC() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
}
