package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.ItemTalismanBase;
import com.zalthrion.zylroth.handler.ConfigurationHandler;

public class VoidTalisman extends ItemTalismanBase {
	public VoidTalisman() {
		super();
		this.setCreativeTab();
		this.setNames("voidTalisman");
		this.setMaxStackSize(1);
		this.setDimensionName("Kyrul");
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		this.handleDimensionTeleport(ConfigurationHandler.getKyrulEnabled(), ConfigurationHandler.getKyrulId(), itemStackIn, worldIn, playerIn);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}