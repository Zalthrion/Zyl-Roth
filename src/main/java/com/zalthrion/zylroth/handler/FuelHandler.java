package com.zalthrion.zylroth.handler;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import com.zalthrion.zylroth.lib.ModInit.ItemInit;

public class FuelHandler implements IFuelHandler {
	private HashMap<Item, Integer> fuelMap = new HashMap<Item, Integer>() {
		private static final long serialVersionUID = 1L;
		{
			put(ItemInit.SOUL_ESSENCE, 6400);
			put(ItemInit.CURSED_SOUL_ESSENCE, 6400);
		}
	};
	
	@Override public int getBurnTime(ItemStack fuel) {
		@SuppressWarnings("unused")
		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();
		
		return fuelMap.containsKey(itemFuel) ? fuelMap.get(itemFuel) : 0;
	}
}
