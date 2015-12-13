package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.tools.*;

public final class ModTools {
	
	/* Tenebrae */
	public static Item tenebraeSword;
	public static Item tenebraePickaxe;
	public static Item tenebraeAxe;
	public static Item tenebraeShovel;
	public static Item tenebraeHoe;
	
	/* Creative */
	public static Item creativeSword;
	public static Item creativePickaxe;
	public static Item creativeAxe;
	public static Item creativeShovel;
	public static Item creativeHoe;
	
	/* Others */
	public static Item tenebraeLeafCutter = new TenebraeLeafCutter();
	public static Item woodenCrossbow = new WoodenCrossbow(2500);
	
	public static void init() {
		TenebraeTools();
	}
	
	public static void TenebraeTools() {
		
		/* Creative */
		ToolMaterial CreativeSword = EnumHelper.addToolMaterial("CreativeDamageTools", 3, 12250, 10, 996.0F, 50);
		ToolMaterial CreativeDamageTools = EnumHelper.addToolMaterial("CreativeDamageTools", 3, 12250, 10, 500.0F, 50);
		ToolMaterial CreativeTools = EnumHelper.addToolMaterial("CreativeTools", 3, 12250, 10, 250.0F, 50);
		
		ModRegistry.addRegister(9, creativeSword = new CreativeSword(CreativeSword), "creativeSword");
		ModRegistry.addRegister(10, creativePickaxe = new CreativePickaxe(CreativeDamageTools), "creativePickaxe");
		ModRegistry.addRegister(11, creativeAxe = new CreativeAxe(CreativeDamageTools), "creativeAxe");
		ModRegistry.addRegister(12, creativeShovel = new CreativeShovel(CreativeTools), "creativeShovel");
		ModRegistry.addRegister(13, creativeHoe = new CreativeHoe(CreativeTools), "creativeHoe");
		
		/* Tenebrae */
		ToolMaterial TenebraeDamageTools = EnumHelper.addToolMaterial("TenebraeDamageTools", 3, 2250, 10, 6.5F, 15);
		ToolMaterial TenebraeTools = EnumHelper.addToolMaterial("TenebraeTools", 3, 2250, 10, 4.5F, 15);
		
		ModRegistry.addRegister(14, tenebraeSword = new TenebraeSword(TenebraeDamageTools), "tenebraeSword");
		ModRegistry.addRegister(15, tenebraePickaxe = new TenebraePickaxe(TenebraeDamageTools), "tenebraePickaxe");
		ModRegistry.addRegister(16, tenebraeAxe = new TenebraeAxe(TenebraeDamageTools), "tenebraeAxe");
		ModRegistry.addRegister(17, tenebraeShovel = new TenebraeShovel(TenebraeTools), "tenebraeShovel");
		ModRegistry.addRegister(18, tenebraeHoe = new TenebraeHoe(TenebraeTools), "tenebraeHoe");
		ModRegistry.addRegister(19, tenebraeLeafCutter, "tenebraeLeafCutter");
		
		/* Others */
		ModRegistry.addRegister(20, woodenCrossbow, "woodenCrossbow");
	}
}
