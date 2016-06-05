package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.ItemTalismanBase;
import com.zalthrion.zylroth.handler.ConfigurationHandler;

public class IceTalisman extends ItemTalismanBase {
	public IceTalisman() {
		super();
		this.setCreativeTab();
		this.setNames("iceTalisman");
		this.setMaxStackSize(1);
		this.setDimensionName("Glaciem");
	}
	
	@Override public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		this.handleDimensionTeleport(ConfigurationHandler.getGlaciemEnabled(), ConfigurationHandler.getGlaciemId(), itemStackIn, worldIn, playerIn);
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}