package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.zalthrion.zylroth.handler.ConfigurationHandler;

public class RainbowTalisman extends ItemBaseTalisman {
	
	private String name = "rainbowTalisman";
	
	public RainbowTalisman() {
		this.setNames(name);
		this.setMaxStackSize(1);
		this.setDimensionName("Iridis");
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		this.handleDimensionTeleport(ConfigurationHandler.getIridisEnabled(), ConfigurationHandler.getIridisId(), stack, world, player);
		return super.onItemRightClick(stack, world, player);
	}
}