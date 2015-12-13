package com.zalthrion.zylroth.item.ore;

import com.zalthrion.zylroth.item.ItemBase;
import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.util.IIcon;

public class VoidiumOre extends ItemBase {
	
	private String name = "voidiumIOre";
	
	public VoidiumOre() {
		this.setNames(name);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		return ModItems.voidiumIngot.getIconFromDamage(meta);
	}
}