package com.zalthrion.zylroth.handler;

import com.zalthrion.zylroth.container.*;
import com.zalthrion.zylroth.gui.inventory.*;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.tile.*;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		final TileEntity tile = world.getTileEntity(x, y, z);
		
		switch (ID) {
			case GuiIDs.INFUSER:
				return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile);
			case GuiIDs.ORE_INFUSER:
				return new ContainerOreInfuser(player.inventory, (TileEntityOreInfuser) tile);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		final TileEntity tile = world.getTileEntity(x, y, z);
		
		switch (ID) {
			case GuiIDs.INFUSER:
				return new GuiInfuser(player.inventory, (TileEntityInfuser) tile);
			case GuiIDs.ORE_INFUSER:
				return new GuiOreInfuser(player.inventory, (TileEntityOreInfuser) tile);
		}
		return null;
	}
	
}
