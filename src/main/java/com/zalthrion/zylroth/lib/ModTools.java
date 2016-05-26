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
import com.zalthrion.zylroth.item.tools.VoidiriteSword;
import com.zalthrion.zylroth.item.tools.VoidiumSword;
import com.zalthrion.zylroth.item.tools.others.RepulsorCannon;
import com.zalthrion.zylroth.item.tools.others.TenebraeLeafCutter;
import com.zalthrion.zylroth.item.tools.others.WoodenCrossbow;
import com.zalthrion.zylroth.item.tools.shields.VoidiriteShield;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public final class ModTools {
	
	/* Tenebrae */
	public static Item tenebraeSword;
	public static Item tenebraePickaxe;
	public static Item tenebraeAxe;
	public static Item tenebraeShovel;
	public static Item tenebraeHoe;
	
	/* Voidium */
	public static Item voidiumSword;
	
	/* Voidirite */
	public static Item voidiriteSword;
	
	/* Creative */
	public static Item creativeSword;
	public static Item creativePickaxe;
	public static Item creativeAxe;
	public static Item creativeShovel;
	public static Item creativeHoe;
	
	/* Others */
	public static Item tenebraeLeafCutter = new TenebraeLeafCutter();
	public static Item woodenCrossbow = new WoodenCrossbow(2500);
	public static Item repulsorCannon = new RepulsorCannon(5500);
	public static Item voidiriteShield = new VoidiriteShield();
	
	public static void init() {
		TenebraeTools();
		VoidiumTools();
		VoidiriteTools();
		CreativeTools();
	}
	
	public static void TenebraeTools() {
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
		ModRegistry.addRegister(71, repulsorCannon, "repulsorCannon");
	}
	
	public static void VoidiumTools() {
		ToolMaterial VoidiumDamageTools = EnumHelper.addToolMaterial("VoidiumDamageTools", 3, 4250, 10, 8.5F, 16);
//		ToolMaterial VoidiumTools = EnumHelper.addToolMaterial("VoidiumTools", 3, 4250, 10, 6.5F, 16);
		
		ModRegistry.addRegister(68, voidiumSword = new VoidiumSword(VoidiumDamageTools), "voidiumSword");
	}
	
	public static void VoidiriteTools() {
		ToolMaterial VoidiriteDamageTools = EnumHelper.addToolMaterial("VoidiriteDamageTools", 3, 5250, 10, 11.0F, 17);
//		ToolMaterial VoidiriteTools = EnumHelper.addToolMaterial("VoidiriteTools", 3, 5250, 10, 8.0F, 17);
		
		ModRegistry.addRegister(69, voidiriteSword = new VoidiriteSword(VoidiriteDamageTools), "voidiriteSword");
		
		ModRegistry.addRegister(78, voidiriteShield, "voidiriteShield");
	}
	
	public static void CreativeTools() {
		ToolMaterial CreativeSword = EnumHelper.addToolMaterial("CreativeDamageTools", 3, 12250, 10, 996.0F, 50);
		ToolMaterial CreativeDamageTools = EnumHelper.addToolMaterial("CreativeDamageTools", 3, 12250, 10, 500.0F, 50);
		ToolMaterial CreativeTools = EnumHelper.addToolMaterial("CreativeTools", 3, 12250, 10, 250.0F, 50);
		
		ModRegistry.addRegister(9, creativeSword = new CreativeSword(CreativeSword), "creativeSword");
		ModRegistry.addRegister(10, creativePickaxe = new CreativePickaxe(CreativeDamageTools), "creativePickaxe");
		ModRegistry.addRegister(11, creativeAxe = new CreativeAxe(CreativeDamageTools), "creativeAxe");
		ModRegistry.addRegister(12, creativeShovel = new CreativeShovel(CreativeTools), "creativeShovel");
		ModRegistry.addRegister(13, creativeHoe = new CreativeHoe(CreativeTools), "creativeHoe");
	}
}
