package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.zalthrion.zylroth.handler.ConfigurationHandler;

public class IceTalisman extends ItemBaseTalisman {
	private String name = "iceTalisman";
	
	public IceTalisman() {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		this.handleDimensionTeleport(ConfigurationHandler.getGlaciemEnabled(), ConfigurationHandler.getGlaciemId(), stack, world, player);
		return super.onItemRightClick(stack, world, player);
	}
}