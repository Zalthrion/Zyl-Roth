package com.zalthrion.zylroth.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.reference.Reference;

public class ItemBase extends Item {
	
	/* Constructors */
	
	public ItemBase() {
		super();
		this.setMaxStackSize(64);
		this.setNoRepair();
	}
	
	/* Custom Methods */
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public ItemBase setCreativeTab() {
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		return this;
	}
	
	public ItemBase setNames(String name) {
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