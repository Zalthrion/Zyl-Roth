package com.zalthrion.zylroth.lib;

import net.minecraftforge.oredict.OreDictionary;

public final class ModOreDictionary {
	
	public static void init() {
		registerDictionary();
	}
	
	public static void registerDictionary() {
		
		OreDictionary.registerOre("oreTenebrae", ModBlocks.Tenebrae_Ore);
		
		OreDictionary.registerOre("ingotTenebrae", ModItems.Tenebrae_Ingot);
		
		OreDictionary.registerOre("blockTenebrae", ModBlocks.Tenebrae_Block);
		
	}
}
