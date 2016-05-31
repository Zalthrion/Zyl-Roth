package com.zalthrion.zylroth.item.armor;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.ItemArmorBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;
import com.zalthrion.zylroth.proxy.ClientProxy;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

// TODO Check all mappings, reorganize methods, etc.
public class VoidLordArmor extends ItemArmorBase {
	private String textureName;
	
	public VoidLordArmor(ArmorMaterial armorMaterial, String textureName, EntityEquipmentSlot type) {
		super(armorMaterial, textureName, type);
		this.textureName = textureName;
		this.setNames("voidLordArmor" + type.getName());
	}
	
	@Override public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ItemInit.TENEBRAE_INGOT;
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.addAll(TooltipHelper.addAll("tenebrae_armor"));
		} else {
			list.addAll(TooltipHelper.addAll("shift"));
		}
	}
	
	@Override public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return Reference.MOD_ID.toLowerCase() + ":" + "textures/armor/" + this.textureName + "_layer_" + (this.armorType == EntityEquipmentSlot.LEGS ? "2" : "1") + ".png";
	}
	
	@Override public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		ModelBiped armorModel = ClientProxy.armorModels.get(this);
		
		if (armorModel != null) {
			armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
			armorModel.bipedHeadwear.showModel = false;
			armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS;
			armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
			armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
			armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
			armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			// armorModel.heldItemRight = 0;
			// armorModel.aimedBow = false;
			
			if (entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entityLiving;
				// TODO FIGURE OUT
				// ItemStack held_item = player.getEquipmentInSlot(0);
				// if (held_item != null) {
				// armorModel.heldItemRight = 1;
				// if (player.getItemInUseCount() > 0) {
				// EnumAction enumaction = held_item.getItemUseAction();
				// if (enumaction == EnumAction.BOW) {
				// armorModel.aimedBow = true;
				// } else if (enumaction == EnumAction.BLOCK) {
				// armorModel.heldItemRight = 3;
				// }
				// }
				// }
			}
		}
		
		return armorModel;
	}
}