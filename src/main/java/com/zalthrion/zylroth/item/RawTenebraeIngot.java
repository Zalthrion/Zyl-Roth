package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.util.IIcon;

public class RawTenebraeIngot extends ItemBase {
	
	private String name = "rawTenebraeIngot";
	
	public RawTenebraeIngot() {
		this.setNames(name);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		return ModItems.tenebrae_Ingot.getIconFromDamage(meta);
	}
}