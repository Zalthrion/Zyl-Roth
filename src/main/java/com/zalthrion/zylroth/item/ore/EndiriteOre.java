package com.zalthrion.zylroth.item.ore;

import com.zalthrion.zylroth.item.ItemBase;
import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.util.IIcon;

public class EndiriteOre extends ItemBase {
	
	private String name = "endiriteIOre";
	
	public EndiriteOre() {
		this.setNames(name);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		return ModItems.endiriteIngot.getIconFromDamage(meta);
	}
}