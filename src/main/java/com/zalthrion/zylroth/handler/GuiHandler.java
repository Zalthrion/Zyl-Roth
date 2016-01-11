package com.zalthrion.zylroth.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zalthrion.zylroth.container.ContainerInfuser;
import com.zalthrion.zylroth.container.ContainerOreInfuser;
import com.zalthrion.zylroth.gui.GuiSummon;
import com.zalthrion.zylroth.gui.inventory.GuiInfuser;
import com.zalthrion.zylroth.gui.inventory.GuiOreInfuser;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

import cpw.mods.fml.common.network.IGuiHandler;

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
			case 2:
				return new GuiSummon();
		}
		return null;
	}
	
}
