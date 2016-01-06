package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.item.ItemBase;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

public class IceTalisman extends ItemBase {
	
	private String name = "iceTalisman";
	
	public IceTalisman() {
		this.setNames(name);
		this.setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (ConfigurationHandler.getKyrulEnabled()) {
			if (!world.isRemote) {
				
				if (player instanceof EntityPlayerMP) {
					
					EntityPlayerMP playerMP = (EntityPlayerMP) player;
					
					WorldServer ws = playerMP.mcServer.worldServerForDimension(49);
					
					Teleporter teleporter = new SpecialTeleporter(ws);
					
					if (!(player.dimension == 49) && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 49, teleporter);
						SpecialTeleporter.adjustPosY(player);
					}
					
					else if (player.dimension == 49 && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
						SpecialTeleporter.adjustPosY(player);
					}
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}