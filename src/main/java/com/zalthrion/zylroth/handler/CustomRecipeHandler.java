package com.zalthrion.zylroth.handler;

import net.minecraft.item.ItemStack;

public class CustomRecipeHandler {
	private ItemStack[] ingrediants;
	private ItemStack output;
	private int[] amounts;
	
	public CustomRecipeHandler(ItemStack[] ing, ItemStack out, int[] amount) {
		this.ingrediants = ing;
		this.output = out;
		this.amounts = amount;
	}
	
	public ItemStack[] getIngrediants() { return this.ingrediants; }
	public ItemStack getOutput() { return this.output; }
	public int[] getAmounts() { return this.amounts; }
	
	public int getAmountForIngrediant(int slot) {
		try {
			if (ingrediants[slot] != null && amounts[slot] != 0) {
				return amounts[slot];
			}
		} catch (ArrayIndexOutOfBoundsException e) { return 0; }
		return 0;
	}
}
