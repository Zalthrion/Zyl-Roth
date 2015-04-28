package com.zalthrion.zylroth.lib;

import net.minecraftforge.oredict.OreDictionary;

public final class ModOreDictionary {
	
	public static void init() {
		registerDictionary();
	}
	
	public static void registerDictionary() {
		
		/* Tenebrae */
		
		OreDictionary.registerOre("oreTenebrae", ModBlocks.tenebrae_Ore);
		OreDictionary.registerOre("ingotTenebrae", ModItems.tenebrae_Ingot);
		OreDictionary.registerOre("blockTenebrae", ModBlocks.tenebrae_Block);
		
		
		/* Voidium */
		
		OreDictionary.registerOre("oreVoidium", ModBlocks.voidium_Ore);
		
	}
}
