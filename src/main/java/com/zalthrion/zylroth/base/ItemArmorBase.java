package com.zalthrion.zylroth.base;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.reference.Reference;

public class ItemArmorBase extends ItemArmor {
	public ItemArmorBase(ArmorMaterial armorMaterial, String textureName, EntityEquipmentSlot type) {
		super(armorMaterial, 0, type);
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setMaxStackSize(1);
	}
	
	/* Custom Methods */
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public ItemArmorBase setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(ModRegistry.createRegistryNameFor(name));
		return this;
	}
	
	/* Overridden */
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}