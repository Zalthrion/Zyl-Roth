package com.zalthrion.zylroth.item.ore;

import com.zalthrion.zylroth.item.ItemBase;
import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.util.IIcon;

public class RawInfernium extends ItemBase {
	
	private String name = "rawInfernium";
	
	public RawInfernium() {
		this.setNames(name);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		return ModItems.inferniumIngot.getIconFromDamage(meta);
	}
}