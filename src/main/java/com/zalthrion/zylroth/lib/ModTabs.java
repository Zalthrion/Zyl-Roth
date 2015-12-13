package com.zalthrion.zylroth.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTabs {
	public static CreativeTabs zylRoth = new CreativeTabs("Zyl'Roth") {
		@Override
		public Item getTabIconItem() {
			return ModItems.unstable_Tenebrae_Core;
		}
	};
}