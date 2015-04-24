package com.zalthrion.zylroth.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

import cpw.mods.fml.common.registry.GameRegistry;

public class VoidTalisman extends ItemBase {
	
	private String name = "voidTalisman";
	@SuppressWarnings("unused")
	private InventoryPlayer inventory;
	@SuppressWarnings("unused")
	private TileEntityInfuser tile = new TileEntityInfuser();
	
	public VoidTalisman() {
		this.setNames(name);
		GameRegistry.registerItem(this, name);
	}
	
	/* @Override public ItemStack onItemRightClick(ItemStack item, World world,
	 * EntityPlayer player) { if (!world.isRemote)
	 * Minecraft.getMinecraft().displayGuiScreen(new GuiInfuser(inventory,
	 * tile)); return super.onItemRightClick(item, world, player); } */
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!world.isRemote) {
			
			if (player instanceof EntityPlayerMP) {
				
				EntityPlayerMP playerMP = (EntityPlayerMP) player;
				
				WorldServer ws = playerMP.mcServer.worldServerForDimension(47);
				
				Teleporter teleporter = new SpecialTeleporter(ws);
				
				if (!(player.dimension == 47) && player.ridingEntity == null) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 47, teleporter);
					SpecialTeleporter.adjustPosY(player);
				}
				
				else if (player.dimension == 47 && player.ridingEntity == null) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
					SpecialTeleporter.adjustPosY(player);
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}