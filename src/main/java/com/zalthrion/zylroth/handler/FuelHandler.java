package com.zalthrion.zylroth.handler;

import java.util.List;

import com.google.common.collect.Lists;
import com.zalthrion.zylroth.lib.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();

		if (itemFuel == ModItems.Unstable_Tenebrae_Essence) {

			return 6400;

		} else {

			return 0;

		}
	}
}
