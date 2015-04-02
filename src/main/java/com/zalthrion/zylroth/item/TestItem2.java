package com.zalthrion.zylroth.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.gui.inventory.GuiInfuser;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

import cpw.mods.fml.common.registry.GameRegistry;

public class TestItem2 extends ItemBase {
	
	private String name = "testItem2";
	
	public TestItem2() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!world.isRemote) {
			
			if (player instanceof EntityPlayerMP) {
				
				EntityPlayerMP playerMP = (EntityPlayerMP) player;
				
				WorldServer ws = playerMP.mcServer.worldServerForDimension(48);
				
				WorldServer ows = playerMP.mcServer.worldServerForDimension(0);
				
				Teleporter teleporter = new SpecialTeleporter(ws);
				
				if (!(player.dimension == 48)) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 48, teleporter);
					SpecialTeleporter.adjustPosY(player);
				}
				
				else if (player.dimension == 48) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
					SpecialTeleporter.adjustPosY(player);
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}