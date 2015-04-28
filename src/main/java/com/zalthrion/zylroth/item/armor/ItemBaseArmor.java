package com.zalthrion.zylroth.item.armor;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

public class ItemBaseArmor extends ItemArmor {
	public ItemBaseArmor(ArmorMaterial armorMaterial, String textureName, int type) {
		super(armorMaterial, 0, type);
		setCreativeTab(ModTabs.ZylRoth);
		setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	protected void setNames(String name) {
		this.setUnlocalizedName(name);
	}
}