package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.gui.inventory.GuiInfuser;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TestItem extends Item {

	private String name = "Test_Item";
	
	private InventoryPlayer inventory;

	private TileEntityInfuser tile;

	public TestItem() {

		setUnlocalizedName(Reference.MOD_ID + "_" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(ModTabs.Project_Exanimus);
		setTextureName(Reference.MOD_ID + ":" + name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world,EntityPlayer player) {
		if (!world.isRemote) 
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiInfuser(inventory, tile));
		}
		
		return super.onItemRightClick(item, world, player);
	}

}