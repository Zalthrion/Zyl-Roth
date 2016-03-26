package com.zalthrion.zylroth.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class ItemBase extends Item {
	
	/* Constructors */
	
	public ItemBase() {
		super();
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setMaxStackSize(64);
		this.setNoRepair();
	}
	
	/* Custom Methods */
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	/* Overridden */
	
	@Override public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
}