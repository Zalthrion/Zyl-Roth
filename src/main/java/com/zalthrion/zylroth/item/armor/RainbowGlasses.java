package com.zalthrion.zylroth.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.reference.Reference;

public class RainbowGlasses extends ItemBaseArmor {
	public RainbowGlasses() {
		super(ModArmors.glasses, "", 0);
		this.setUnlocalizedName(Reference.RESOURCE_PREFIX + "rainbowGlasses");
	}
	
	@Override public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return armorType == 0;
	}
	
	@Override public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "zylroth:textures/models/rainbowGlasses.png";
	}
}