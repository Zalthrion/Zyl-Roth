package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.ItemTalismanBase;
import com.zalthrion.zylroth.handler.ConfigurationHandler;

public class AutumnTalisman extends ItemTalismanBase {
	public AutumnTalisman() {
		super();
		this.setNames("autumnTalisman");
		this.setDimensionName("Iridis");
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		this.handleDimensionTeleport(ConfigurationHandler.getIridisEnabled(), ConfigurationHandler.getIridisId(), itemStackIn, worldIn, playerIn);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}