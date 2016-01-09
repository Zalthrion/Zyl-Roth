package com.zalthrion.zylroth.item.armor;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.proxy.ClientProxy;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.TooltipHelper;

public class VoidLordArmor extends ItemBaseArmor {
	
	private String name = "voidLordArmor";
	
	private String textureName;
	
	public VoidLordArmor(ArmorMaterial armorMaterial, String textureName, int type) {
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
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.addAll(TooltipHelper.addAll("tenebrae_armor"));
		} else {
			list.addAll(TooltipHelper.addAll("shift"));
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Reference.RESOURCE_PREFIX + "textures/armor/" + this.textureName + "_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped armorModel = ClientProxy.armorModels.get(this);
		
		if (armorModel != null) {
			armorModel.bipedHead.showModel = armorSlot == 0;
			armorModel.bipedHeadwear.showModel = false;
			armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
			armorModel.bipedRightArm.showModel = armorSlot == 1;
			armorModel.bipedLeftArm.showModel = armorSlot == 1;
			armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			armorModel.heldItemRight = 0;
			armorModel.aimedBow = false;
			
			if (entityLiving instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entityLiving;
				ItemStack held_item = player.getEquipmentInSlot(0);
				if (held_item != null) {
					armorModel.heldItemRight = 1;
					if (player.getItemInUseCount() > 0) {
						EnumAction enumaction = held_item.getItemUseAction();
						if (enumaction == EnumAction.bow) {
							armorModel.aimedBow = true;
						}
						else if (enumaction == EnumAction.block) {
							armorModel.heldItemRight = 3;
						}
					}
				}
			}
		}
		
		return armorModel;
	}
}