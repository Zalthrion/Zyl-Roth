package com.zalthrion.zylroth.item.armor;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class TenebraeArmor extends ItemBaseArmor {
	
	private String name = "tenebraeArmor";
	
	private String textureName;
	
	public TenebraeArmor(ArmorMaterial armorMaterial, String textureName, int type) {
		super(armorMaterial, textureName, type);
		this.textureName = textureName;
		this.setMaxStackSize(1);
		this.setCreativeTab(ModTabs.ZylRoth);
		this.setNames(Reference.MOD_ID.toLowerCase() + ":" + name);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		
		return stack.getItem() == ModItems.tenebraeIngot;
	}
	
	@Override @SuppressWarnings({"unchecked", "rawtypes"})
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {
		list.addAll(TooltipHelper.addAll("tenebrae_armor"));
		list.addAll(TooltipHelper.addAll("tenebrae_generic"));
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.addAll(TooltipHelper.addAll("tenebrae_armor_stats"));
		} else {
			list.addAll(TooltipHelper.addAll("shift"));
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Reference.MOD_ID.toLowerCase() + ":" + "textures/armor/" + this.textureName + "_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
}