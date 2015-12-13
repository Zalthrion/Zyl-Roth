package com.zalthrion.zylroth.item.ore;

import com.zalthrion.zylroth.item.ItemBase;
import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.util.IIcon;

public class TenebraeOre extends ItemBase {
	
	private String name = "tenebraeIOre";
	
	public TenebraeOre() {
		this.setNames(name);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		return ModItems.tenebraeIngot.getIconFromDamage(meta);
	}
}