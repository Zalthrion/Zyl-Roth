package com.zalthrion.zylroth.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.handler.recipe.InfusionFuels;

public class SlotInfuserFuel extends Slot {
	public SlotInfuserFuel(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override public boolean isItemValid(ItemStack stack) {
		return InfusionFuels.isFuel(stack);
	}
}