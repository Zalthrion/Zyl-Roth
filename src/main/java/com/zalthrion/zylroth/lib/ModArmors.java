package com.zalthrion.zylroth.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.armor.*;

public final class ModArmors {
	
	/* Tenebrae Armor Set */
	public static Item Tenebrae_Helmet;
	public static Item Tenebrae_Chestplate;
	public static Item Tenebrae_Leggings;
	public static Item Tenebrae_Boots;
	
	/* Void Lord Armor Set */
	public static Item VoidLord_Helmet;
	public static Item VoidLord_Chestplate;
	public static Item VoidLord_Leggings;
	public static Item VoidLord_Boots;
	
	public static void init() {
		TenebraeArmor();
		VoidLordArmor();
	}
	
	public static void TenebraeArmor() {
		ArmorMaterial Tenebrae = EnumHelper.addArmorMaterial("Tenebrae", 42, new int[] {3, 8, 6, 3}, 16);
		ModRegistry.addRegister(1, Tenebrae_Helmet = new TenebraeArmor(Tenebrae, "tenebrae", 0).setUnlocalizedName("tenebraeHelmet"), "tenebrae_helmet");
		ModRegistry.addRegister(2, Tenebrae_Chestplate = new TenebraeArmor(Tenebrae, "tenebrae", 1).setUnlocalizedName("tenebraeChestplate"), "tenebrae_chestplate");
		ModRegistry.addRegister(3, Tenebrae_Leggings = new TenebraeArmor(Tenebrae, "tenebrae", 2).setUnlocalizedName("tenebraeLeggings"), "tenebrae_leggings");
		ModRegistry.addRegister(4, Tenebrae_Boots = new TenebraeArmor(Tenebrae, "tenebrae", 3).setUnlocalizedName("tenebraeBoots"), "tenebrae_boots");	
	}
	
	public static void VoidLordArmor() {
		ArmorMaterial VoidLord = EnumHelper.addArmorMaterial("VoidLord", 42, new int[] {3, 8, 6, 3}, 16);
		ModRegistry.addRegister(5, VoidLord_Helmet = new VoidLordArmor(VoidLord, "voidlord", 0).setUnlocalizedName("voidlordHelmet"), "voidlord_helmet");
		ModRegistry.addRegister(6, VoidLord_Chestplate = new VoidLordArmor(VoidLord, "voidlord", 1).setUnlocalizedName("voidlordChestplate"), "voidlord_chestplate");
		ModRegistry.addRegister(7, VoidLord_Leggings = new VoidLordArmor(VoidLord, "voidlord", 2).setUnlocalizedName("voidlordLeggings"), "voidlord_leggings");
		ModRegistry.addRegister(8, VoidLord_Boots = new VoidLordArmor(VoidLord, "voidlord", 3).setUnlocalizedName("voidlordBoots"), "voidlord_boots");
	}
}
