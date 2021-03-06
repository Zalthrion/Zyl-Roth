package com.zalthrion.zylroth.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModItems;

import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		
		@SuppressWarnings("unused")
		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();
		
		if (itemFuel == ModItems.soulEssence) {
			
			return 6400;
		}
		
		else if (itemFuel == ModItems.cursedSoulEssence) {
			
			return 6400;
		}
		
		else {
			
			return 0;
		}
	}
}
