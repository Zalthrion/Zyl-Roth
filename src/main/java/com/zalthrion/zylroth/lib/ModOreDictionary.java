package com.zalthrion.zylroth.lib;

import net.minecraftforge.oredict.OreDictionary;

public final class ModOreDictionary {
	
	public static void init() {
		registerDictionary();
	}
	
	public static void registerDictionary() {
		
		/* Tenebrae */
		OreDictionary.registerOre("oreTenebrae", ModBlocks.tenebraeOre);
		OreDictionary.registerOre("iOreTenebrae", ModItems.tenebraeOre);
		OreDictionary.registerOre("ingotTenebrae", ModItems.tenebraeIngot);
		OreDictionary.registerOre("blockTenebrae", ModBlocks.tenebraeBlock);
		
		/*Infernium */
		OreDictionary.registerOre("oreInfernium", ModBlocks.inferniumOre);
		OreDictionary.registerOre("iOreInfernium", ModItems.rawInfernium);
		OreDictionary.registerOre("ingotInfernium", ModItems.inferniumIngot);
		
		/* Tenebrium */
		OreDictionary.registerOre("ingotTenebrium", ModItems.tenebriumIngot);
		
		/* Endirite */
		OreDictionary.registerOre("oreEndirite", ModBlocks.endiriteOre);
		OreDictionary.registerOre("iOreEndirite", ModItems.endiriteOre);
		OreDictionary.registerOre("ingotEndirite", ModItems.endiriteIngot);
		
		/* Voidium */
		OreDictionary.registerOre("oreVoidium", ModBlocks.voidiumOre);
		OreDictionary.registerOre("iOreVoidium", ModItems.voidiumOre);
		OreDictionary.registerOre("ingotVoidium", ModItems.voidiumIngot);
		
		/* Voidirite */
		OreDictionary.registerOre("ingotVoidirite", ModItems.voidiriteIngot);
		
		/* Others */
		OreDictionary.registerOre("stone", ModBlocks.voidStone);
		OreDictionary.registerOre("logWood", ModBlocks.kyrulLogBlock);
		OreDictionary.registerOre("plankWood", ModBlocks.voidPlanks);
	}
}
