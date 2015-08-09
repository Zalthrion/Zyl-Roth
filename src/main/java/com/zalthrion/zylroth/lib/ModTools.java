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
	
	public static Item creativeSword;
	public static Item creativePickaxe;
	public static Item creativeAxe;
	public static Item creativeShovel;
	public static Item creativeHoe;
	
	public static void init() {
		TenebraeTools();
	}
	
	public static void TenebraeTools() {
		
		ToolMaterial CreativeDamageTools = EnumHelper.addToolMaterial("CreativeDamageTools", 3, 12250, 10, 500.0F, 50);
		ToolMaterial CreativeTools = EnumHelper.addToolMaterial("CreativeTools", 3, 12250, 10, 250.0F, 50);
		
		GameRegistry.registerItem(creativeSword = new CreativeSword(CreativeDamageTools), "creative_sword");
		GameRegistry.registerItem(creativePickaxe = new CreativePickaxe(CreativeDamageTools), "creative_pickaxe");
		GameRegistry.registerItem(creativeAxe = new CreativeAxe(CreativeDamageTools), "creative_axe");
		GameRegistry.registerItem(creativeShovel = new CreativeShovel(CreativeTools), "creative_shovel");
		GameRegistry.registerItem(creativeHoe = new CreativeHoe(CreativeTools), "creative_hoe");
		
		
		ToolMaterial TenebraeDamageTools = EnumHelper.addToolMaterial("TenebraeDamageTools", 3, 2250, 10, 6.5F, 15);
		ToolMaterial TenebraeTools = EnumHelper.addToolMaterial("TenebraeTools", 3, 2250, 10, 4.5F, 15);
		
		GameRegistry.registerItem(tenebraeSword = new TenebraeSword(TenebraeDamageTools), "tenebrae_sword");
		GameRegistry.registerItem(tenebraePickaxe = new TenebraePickaxe(TenebraeDamageTools), "tenebrae_pickaxe");
		GameRegistry.registerItem(tenebraeAxe = new TenebraeAxe(TenebraeDamageTools), "tenebrae_axe");
		GameRegistry.registerItem(tenebraeShovel = new TenebraeShovel(TenebraeTools), "tenebrae_shovel");
		GameRegistry.registerItem(tenebraeHoe = new TenebraeHoe(TenebraeTools), "tenebrae_hoe");
		
	}
	
}
