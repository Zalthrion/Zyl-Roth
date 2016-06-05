package com.zalthrion.zylroth.item.armor;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.ItemArmorBase;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.StringHelper;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class EmeraldArmor extends ItemArmorBase {
	private String textureName;
	
	public EmeraldArmor(ArmorMaterial armorMaterial, String textureName, EntityEquipmentSlot type) {
		super(armorMaterial, textureName, type);
		this.textureName = textureName;
		this.setMaxStackSize(1);
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setNames("emeraldArmor" + StringHelper.capitalizeFirstLetter(type.getName()));
	}
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == Items.EMERALD;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		list.addAll(TooltipHelper.addAll("tenebrae_armor"));
		list.addAll(TooltipHelper.addAll("tenebrae_generic"));
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.addAll(TooltipHelper.addAll("tenebrae_armor_stats"));
		} else {
			list.addAll(TooltipHelper.addAll("shift"));
		}
	}
	
	@Override public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return Reference.RESOURCE_PREFIX + "textures/armor/" + this.textureName + "_layer_" + (this.armorType == EntityEquipmentSlot.LEGS ? "2" : "1") + ".png";
	}
}