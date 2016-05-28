package com.zalthrion.zylroth.item.armor;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.ItemArmorBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

//TODO Check all mappings, reorganize methods, etc.
public class TenebraeArmor extends ItemArmorBase {
	private String textureName;
	
	public TenebraeArmor(ArmorMaterial armorMaterial, String textureName, EntityEquipmentSlot type) {
		super(armorMaterial, textureName, type);
		this.textureName = textureName;
		this.setMaxStackSize(1);
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setNames("tenebraeArmor" + type.getName());
	}
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ItemInit.tenebraeIngot;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
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