package com.zalthrion.zylroth.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import com.zalthrion.zylroth.lib.ModItems;

public class FuelHandler implements IFuelHandler {
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		
		@SuppressWarnings("unused")
		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();
		
		if (itemFuel == ModItems.Unstable_Tenebrae_Essence) {
			
			return 6400;
			
		} else {
			
			return 0;
			
		}
	}
}
