package com.zalthrion.zylroth.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.reference.Reference;

public class RainbowGlasses extends ItemBaseArmor {
	public RainbowGlasses() {
		super(ModArmors.glasses, "", EntityEquipmentSlot.HEAD);
		this.setUnlocalizedName(Reference.RESOURCE_PREFIX + "rainbowGlasses");
	}
	
	@Override public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return armorType == EntityEquipmentSlot.HEAD;
	}
	
	@Override public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return "zylroth:textures/models/rainbowGlasses.png";
	}
}