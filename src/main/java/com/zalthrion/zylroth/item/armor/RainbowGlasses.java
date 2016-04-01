package com.zalthrion.zylroth.item.armor;

import com.zalthrion.zylroth.lib.ModArmors;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class RainbowGlasses extends ItemBaseArmor {
	
	public RainbowGlasses() {
		super(ModArmors.glasses, "", 0);
		this.setNames("rainbowGlasses");
	}
	
	@Override public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return armorType == 0;
	}
	
	@Override public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "zylroth:textures/armor/rainbowGlasses.png";
	}
}