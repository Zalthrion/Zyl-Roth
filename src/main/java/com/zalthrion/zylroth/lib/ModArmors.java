package com.zalthrion.zylroth.lib;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.zalthrion.zylroth.item.armor.RainbowGlasses;
import com.zalthrion.zylroth.item.armor.TenebraeArmor;
import com.zalthrion.zylroth.item.armor.VoidLordArmor;

public final class ModArmors {
	
	//Tenebrae
	
	public static ArmorMaterial tenebrae = EnumHelper.addArmorMaterial("Tenebrae", "Tenebrae", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.item_armor_equip_generic);
	public static ArmorMaterial voidLord = EnumHelper.addArmorMaterial("VoidLord", "VoidLord", 42, new int[] {3, 8, 6, 3}, 16, SoundEvents.item_armor_equip_generic);
	public static ArmorMaterial glasses = EnumHelper.addArmorMaterial("Glasses", "Glasses", 0, new int[] {0, 0, 0, 0}, 0, SoundEvents.item_armor_equip_generic);
	
	public static Item tenebraeHelmet = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.HEAD).setUnlocalizedName("tenebraeHelmet");
	public static Item tenebraeChestplate = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.CHEST).setUnlocalizedName("tenebraeChestplate");
	public static Item tenebraeLeggings = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.LEGS).setUnlocalizedName("tenebraeLeggings");
	public static Item tenebraeBoots = new TenebraeArmor(tenebrae, "tenebrae", EntityEquipmentSlot.FEET).setUnlocalizedName("tenebraeBoots");
	
	public static Item voidLordHelmet = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.HEAD).setUnlocalizedName("voidLordHelmet");
	public static Item voidLordChestplate = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.CHEST).setUnlocalizedName("voidLordChestplate");
	public static Item voidLordLeggings = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.LEGS).setUnlocalizedName("voidLordLeggings");
	public static Item voidLordBoots = new VoidLordArmor(voidLord, "voidlord", EntityEquipmentSlot.FEET).setUnlocalizedName("voidLordBoots");
	
	public static Item rainbowGlasses = new RainbowGlasses();
	
	public static void init() {
		tenebraeArmor();
		voidLordArmor();
		ModRegistry.addRegister(8, rainbowGlasses, "rainbowGlasses");
	}
	
	public static void tenebraeArmor() {
		ModRegistry.addRegister(0, tenebraeHelmet, "tenebraeHelmet");
		ModRegistry.addRegister(1, tenebraeChestplate, "tenebraeChestplate");
		ModRegistry.addRegister(2, tenebraeLeggings, "tenebraeLeggings");
		ModRegistry.addRegister(3, tenebraeBoots, "tenebraeBoots");
	}
	
	public static void voidLordArmor() {
		ModRegistry.addRegister(4, voidLordHelmet, "voidLordHelmet");
		ModRegistry.addRegister(5, voidLordChestplate, "voidLordChestplate");
		ModRegistry.addRegister(6, voidLordLeggings, "voidLordLeggings");
		ModRegistry.addRegister(7, voidLordBoots, "voidLordBoots");
	}
}
