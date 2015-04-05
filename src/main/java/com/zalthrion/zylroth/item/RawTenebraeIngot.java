package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;

public class RawTenebraeIngot extends ItemBase {
	
	private String name = "rawTenebraeIngot";
	
	public RawTenebraeIngot() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		return ModItems.Tenebrae_Ingot.getIconFromDamage(meta);
	}
}