package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.item.armor.TenebraeArmor;

public final class ModArmors {
	
	//Tenebrae
	
	public static Item tenebrae_Helmet;
	public static Item tenebrae_Chestplate;
	public static Item tenebrae_Leggings;
	public static Item tenebrae_Boots;
	
	public static void init() {
		tenebraeArmor();
	}
	
	public static void tenebraeArmor() {
		ArmorMaterial tenebrae = EnumHelper.addArmorMaterial("Tenebrae", "Tenebrae", 42, new int[]{3, 8, 6, 3}, 16);
		
		GameRegistry.registerItem(tenebrae_Helmet = new TenebraeArmor(tenebrae, "tenebrae", 0).setUnlocalizedName("tenebraeHelmet"), "tenebrae_helmet");
		GameRegistry.registerItem(tenebrae_Chestplate = new TenebraeArmor(tenebrae, "tenebrae", 1).setUnlocalizedName("tenebraeChestplate"), "tenebrae_chestplate");
		GameRegistry.registerItem(tenebrae_Leggings = new TenebraeArmor(tenebrae, "tenebrae", 2).setUnlocalizedName("tenebraeLeggings"), "tenebrae_leggings");
		GameRegistry.registerItem(tenebrae_Boots = new TenebraeArmor(tenebrae, "tenebrae", 3).setUnlocalizedName("tenebraeBoots"), "tenebrae_boots");
	}
}
