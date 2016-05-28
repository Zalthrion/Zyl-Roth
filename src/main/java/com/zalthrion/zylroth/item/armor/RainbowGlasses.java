package com.zalthrion.zylroth.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.ItemArmorBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

//TODO Check all mappings, reorganize methods, etc.
public class RainbowGlasses extends ItemArmorBase {
	public RainbowGlasses() {
		super(ItemInit.glasses, "", EntityEquipmentSlot.HEAD);
		this.setNames("rainbowGlasses");
	}
	
	@Override public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return "zylroth:textures/armor/rainbowGlasses.png";
	}

	@Override public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return armorType == EntityEquipmentSlot.HEAD;
	}
}