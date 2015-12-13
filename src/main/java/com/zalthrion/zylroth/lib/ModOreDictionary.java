package com.zalthrion.zylroth.lib;

import net.minecraftforge.oredict.OreDictionary;

public final class ModOreDictionary {
	
	public static void init() {
		registerDictionary();
	}
	
	public static void registerDictionary() {
		
		/* Tenebrae */
		
		OreDictionary.registerOre("oreTenebrae", ModBlocks.tenebraeOre);
		OreDictionary.registerOre("ingotTenebrae", ModItems.tenebraeIngot);
		OreDictionary.registerOre("blockTenebrae", ModBlocks.tenebraeBlock);
		
		/* Voidium */
		
		OreDictionary.registerOre("oreVoidium", ModBlocks.voidiumOre);
		
	}
}
