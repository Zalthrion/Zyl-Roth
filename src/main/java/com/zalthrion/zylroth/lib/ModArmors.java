package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.armor.TenebraeArmor;

public final class ModArmors {
	
	//Tenebrae
	
	public static ArmorMaterial tenebrae = EnumHelper.addArmorMaterial("Tenebrae", "Tenebrae", 42, new int[]{3, 8, 6, 3}, 16);
	public static Item tenebraeHelmet = new TenebraeArmor(tenebrae, "tenebrae", 0).setUnlocalizedName("tenebraeHelmet");
	public static Item tenebraeChestplate = new TenebraeArmor(tenebrae, "tenebrae", 1).setUnlocalizedName("tenebraeChestplate");
	public static Item tenebraeLeggings = new TenebraeArmor(tenebrae, "tenebrae", 2).setUnlocalizedName("tenebraeLeggings");
	public static Item tenebraeBoots = new TenebraeArmor(tenebrae, "tenebrae", 3).setUnlocalizedName("tenebraeBoots");
	
	public static void init() {
		tenebraeArmor();
	}
	
	public static void tenebraeArmor() {
		// GameRegistry.registerItem(tenebraeHelmet, "tenebraeHelmet");
		// GameRegistry.registerItem(tenebraeChestplate, "tenebraeChestplate");
		// GameRegistry.registerItem(tenebraeLeggings, "tenebraeLeggings");
		// GameRegistry.registerItem(tenebraeBoots, "tenebraeBoots");
		
		ModRegistry.addRegister(0, tenebraeHelmet, "tenebraeHelmet");
		ModRegistry.addRegister(1, tenebraeChestplate, "tenebraeChestplate");
		ModRegistry.addRegister(2, tenebraeLeggings, "tenebraeLeggings");
		ModRegistry.addRegister(3, tenebraeBoots, "tenebraeBoots");
	}
}
