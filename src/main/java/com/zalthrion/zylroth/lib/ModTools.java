package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.item.tools.CreativeAxe;
import com.zalthrion.zylroth.item.tools.CreativeHoe;
import com.zalthrion.zylroth.item.tools.CreativePickaxe;
import com.zalthrion.zylroth.item.tools.CreativeShovel;
import com.zalthrion.zylroth.item.tools.CreativeSword;
import com.zalthrion.zylroth.item.tools.TenebraeAxe;
import com.zalthrion.zylroth.item.tools.TenebraeHoe;
import com.zalthrion.zylroth.item.tools.TenebraePickaxe;
import com.zalthrion.zylroth.item.tools.TenebraeShovel;
import com.zalthrion.zylroth.item.tools.TenebraeSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
	
	public static void init() {
		TenebraeTools();
	}
	
	public static void TenebraeTools() {
		GameRegistry.registerItem(tenebraeSword, "tenebrae_sword");
		GameRegistry.registerItem(tenebraePickaxe, "tenebrae_pickaxe");
		GameRegistry.registerItem(tenebraeAxe, "tenebrae_axe");
		GameRegistry.registerItem(tenebraeShovel, "tenebrae_shovel");
		GameRegistry.registerItem(tenebraeHoe, "tenebrae_hoe");
		
		GameRegistry.registerItem(creativeSword, "creative_sword");
		GameRegistry.registerItem(creativePickaxe, "creative_pickaxe");
		GameRegistry.registerItem(creativeAxe, "creative_axe");
		GameRegistry.registerItem(creativeShovel, "creative_shovel");
		GameRegistry.registerItem(creativeHoe, "creative_hoe");
	}
}