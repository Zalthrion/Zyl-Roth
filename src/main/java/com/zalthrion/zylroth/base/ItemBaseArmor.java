package com.zalthrion.zylroth.base;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class ItemBaseArmor extends ItemArmor {
	public ItemBaseArmor(ArmorMaterial armorMaterial, String textureName, EntityEquipmentSlot type) {
		super(armorMaterial, 0, type);
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setMaxStackSize(1);
	}
	
	/* Custom Methods */
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public void setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
	/* Overridden */
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}