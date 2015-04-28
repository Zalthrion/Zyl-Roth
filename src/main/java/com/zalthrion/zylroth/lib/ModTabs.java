package com.zalthrion.zylroth.lib;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ModTabs {
	
	public static CreativeTabs ZylRoth = new CreativeTabs("Zyl'Roth") {
		private ItemSorter itemSorter = new ItemSorter();
		
		@Override
		public Item getTabIconItem() {
			return ModItems.stable_Tenebrae_Core;
		}
		
		@SuppressWarnings("unchecked") @Override public void displayAllReleventItems(@SuppressWarnings("rawtypes") List items) {
			super.displayAllReleventItems(items);
			Collections.sort(items, itemSorter);
		}
	};
	
	private static class ItemSorter implements Comparator<ItemStack> {
		
		@Override public int compare(ItemStack o1, ItemStack o2) {
			Item item1 = o1.getItem();
			Item item2 = o2.getItem();
			
			// If item1 is a block and item2 isn't, sort item1 before item2
			if (((item1 instanceof ItemBlock)) && (!(item2 instanceof ItemBlock))) { return -1; }
			
			// If item2 is a block and item1 isn't, sort item1 after item2
			if (((item2 instanceof ItemBlock)) && (!(item1 instanceof ItemBlock))) { return 1; }
			
			String displayName1 = o1.getDisplayName();
			String displayName2 = o2.getDisplayName();
			
			int result = displayName1.compareToIgnoreCase(displayName2);
			return result;
		}
	}
}