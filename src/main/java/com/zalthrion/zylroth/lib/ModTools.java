package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.tools.*;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModTools {
	
	// Tenebrae
	
	public static Item tenebraeSword;
	public static Item tenebraePickaxe;
	public static Item tenebraeAxe;
	public static Item tenebraeShovel;
	public static Item tenebraeHoe;
	
	public static void init() {
		TenebraeTools();
	}
	
	public static void TenebraeTools() {
		
		ToolMaterial TenebraeSword = EnumHelper.addToolMaterial("TenebraeSword", 3, 2250, 10, 6.5F, 15);
		ToolMaterial TenebraeTools = EnumHelper.addToolMaterial("TenebraeTools", 3, 2250, 10, 4.5F, 15);
		ToolMaterial TenebraeExtras = EnumHelper.addToolMaterial("TenebraeExtras", 3, 2250, 10, 6.5F, 15);
		
		GameRegistry.registerItem(tenebraeSword = new TenebraeSword(TenebraeSword), "tenebrae_sword");
		GameRegistry.registerItem(tenebraePickaxe = new TenebraePickaxe(TenebraeExtras), "tenebrae_pickaxe");
		GameRegistry.registerItem(tenebraeAxe = new TenebraeAxe(TenebraeExtras), "tenebrae_axe");
		GameRegistry.registerItem(tenebraeShovel = new TenebraeShovel(TenebraeTools), "tenebrae_shovel");
		GameRegistry.registerItem(tenebraeHoe = new TenebraeHoe(TenebraeTools), "tenebrae_hoe");
		
	}
	
}
