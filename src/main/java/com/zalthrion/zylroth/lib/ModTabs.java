package com.zalthrion.zylroth.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModTabs {
	
	public static CreativeTabs ZylRoth = new CreativeTabs("Project_Exanimus") {
		
		@Override
		public Item getTabIconItem() {
			return ModItems.Purified_Tenebrae_Essence;
		}
	};
	
}