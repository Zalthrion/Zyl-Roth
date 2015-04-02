package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.ModTabs;

import cpw.mods.fml.common.registry.GameRegistry;

public class SoulEssence extends ItemBase {
	
	private String name = "soulEssence";
	
	public SoulEssence() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
}