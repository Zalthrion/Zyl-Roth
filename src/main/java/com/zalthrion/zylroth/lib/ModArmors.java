package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.armor.TenebraeArmor;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModArmors {
	
	//Tenebrae
	
	public static Item Tenebrae_Helmet;
	public static Item Tenebrae_Chestplate;
	public static Item Tenebrae_Leggings;
	public static Item Tenebrae_Boots;
	
	public static void init() {
		TenebraeArmor();
	}
	
	public static void TenebraeArmor() {
		
		ArmorMaterial Tenebrae = EnumHelper.addArmorMaterial("Tenebrae", 38, new int[]{3, 8, 6, 3}, 16);
		
		GameRegistry.registerItem(Tenebrae_Helmet = new TenebraeArmor(Tenebrae, "tenebrae", 0).setUnlocalizedName("tenebraeHelmet"), "tenebrae_helmet");
		GameRegistry.registerItem(Tenebrae_Chestplate = new TenebraeArmor(Tenebrae, "tenebrae", 1).setUnlocalizedName("tenebraeChestplate"), "tenebrae_chestplate");
		GameRegistry.registerItem(Tenebrae_Leggings = new TenebraeArmor(Tenebrae, "tenebrae", 2).setUnlocalizedName("tenebraeLeggings"), "tenebrae_leggings");
		GameRegistry.registerItem(Tenebrae_Boots = new TenebraeArmor(Tenebrae, "tenebrae", 3).setUnlocalizedName("tenebraeBoots"), "tenebrae_boots");

		
	}
	
}
