package com.zalthrion.zylroth.handler.recipe;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class InfusionFuels {
	private static HashMap<Item, Integer> fuels = new HashMap<Item, Integer>();
	
	public static boolean isFuel(ItemStack stack) {
		return fuels.containsKey(stack.getItem());
	}
	
	public static int getItemBurnTime(ItemStack stack) {
		if (stack == null) return 0;
		Item item = stack.getItem();
		if (fuels.containsKey(item)) {
			return fuels.get(item);
		}
		return 0;
	}
	
	public static void registerFuel(ItemStack stack, int burnTime) {
		Item item = stack.getItem();
		fuels.put(item, burnTime);
	}
}