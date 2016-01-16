package com.zalthrion.zylroth.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.handler.recipe.InfusionFuels;

public class SlotInfuserFuel extends Slot {
	public SlotInfuserFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
		super(inventoryIn, slotIndex, xPosition, yPosition);
	}
	
	@Override public boolean isItemValid(ItemStack stack) {
		return InfusionFuels.isFuel(stack);
	}
}