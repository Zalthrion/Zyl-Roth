package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.tools.*;

public class ModTools {
	private static final ToolMaterial creativeSwordMaterial = EnumHelper.addToolMaterial("CreativeSword", 3, 12250, 10, 996, 50);
	private static final ToolMaterial creativeDamageTools = EnumHelper.addToolMaterial("creativeDamageTools", 3, 12250, 10, 500.0F, 50);
	private static final ToolMaterial creativeTools = EnumHelper.addToolMaterial("creativeTools", 3, 12250, 10, 250.0F, 50);
	
	private static final ToolMaterial tenebraeDamageTools = EnumHelper.addToolMaterial("tenebraeDamageTools", 3, 2250, 10, 6.5F, 15);
	private static final ToolMaterial tenebraeTools = EnumHelper.addToolMaterial("tenebraeTools", 3, 2250, 10, 4.5F, 15);
	
	public static final Item tenebraeSword = new TenebraeSword(tenebraeDamageTools);
	public static final Item tenebraePickaxe = new TenebraePickaxe(tenebraeDamageTools);
	public static final Item tenebraeAxe = new TenebraeAxe(tenebraeDamageTools);
	public static final Item tenebraeShovel = new TenebraeShovel(tenebraeTools);
	public static final Item tenebraeHoe = new TenebraeHoe(tenebraeTools);
	
	public static Item creativeSword = new CreativeSword(creativeSwordMaterial);
	public static Item creativePickaxe = new CreativePickaxe(creativeDamageTools);
	public static Item creativeAxe = new CreativeAxe(creativeDamageTools);
	public static Item creativeShovel = new CreativeShovel(creativeTools);
	public static Item creativeHoe = new CreativeHoe(creativeTools);
	
	public static Item tenebraeLeafCutter = new TenebraeLeafCutter();
	public static Item woodenCrossbow = new WoodenCrossbow(2500);
	
	public static void init() {
		tenebraeTools();
	}
	
	public static void tenebraeTools() {
		ModRegistry.addRegister(9, tenebraePickaxe, "tenebraePickaxe");
		ModRegistry.addRegister(10, tenebraeShovel, "tenebraeShovel");
		ModRegistry.addRegister(11, tenebraeSword, "tenebraeSword");
		ModRegistry.addRegister(12, tenebraeAxe, "tenebraeAxe");
		ModRegistry.addRegister(13, tenebraeHoe, "tenebraeHoe");
		ModRegistry.addRegister(14, tenebraeLeafCutter, "tenebraeLeafCutter");
		
		ModRegistry.addRegister(15, creativePickaxe, "creativePickaxe");
		ModRegistry.addRegister(16, creativeShovel, "creativeShovel");
		ModRegistry.addRegister(17, creativeSword, "creativeSword");
		ModRegistry.addRegister(18, creativeAxe, "creativeAxe");
		ModRegistry.addRegister(19, creativeHoe, "creativeHoe");
		
		ModRegistry.addRegister(20, woodenCrossbow, "woodenCrossbow");
	}
}