package com.zalthrion.zylroth.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.zalthrion.zylroth.gui.inventory.GuiInfuser;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.common.registry.GameRegistry;

public class TestItem extends ItemBase {
	
	private String name = "testItem";
	private InventoryPlayer inventory;
	private TileEntityInfuser tile = new TileEntityInfuser();
	
	public TestItem() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player) {
		if (!world.isRemote) Minecraft.getMinecraft().displayGuiScreen(new GuiInfuser(inventory, tile));
		return super.onItemRightClick(item, world, player);
	}
}