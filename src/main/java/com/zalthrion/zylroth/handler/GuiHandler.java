package com.zalthrion.zylroth.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.zalthrion.zylroth.container.ContainerInfuser;
import com.zalthrion.zylroth.gui.GuiSummon;
import com.zalthrion.zylroth.gui.inventory.GuiInfuser;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		final TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		switch (ID) {
			case GuiIDs.INFUSER:
				return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		final TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
		
		switch (ID) {
			case GuiIDs.INFUSER:
				return new GuiInfuser(player.inventory, (TileEntityInfuser) tile);
			case GuiIDs.SUMMON:
				return new GuiSummon();
		}
		return null;
	}
	
}
