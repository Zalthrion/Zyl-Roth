package com.zalthrion.zylroth.item.talisman;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.item.ItemBase;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

public class ItemBaseTalisman extends ItemBase {
	
	public ItemBaseTalisman() {
		super();
	}
	
	public void handleDimensionTeleport(boolean condition, int dimensionID, ItemStack stack, World world, EntityPlayer player) {
		if (condition) {
			if (!world.isRemote) {
				if (player instanceof EntityPlayerMP) {
					EntityPlayerMP playerMP = (EntityPlayerMP) player;
					WorldServer ws = playerMP.mcServer.worldServerForDimension(dimensionID);
					Teleporter teleporter = new SpecialTeleporter(ws);
					
					if (!(player.dimension == dimensionID) && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, dimensionID, teleporter);
						SpecialTeleporter.adjustPosY(player);
					} else if (player.dimension == dimensionID && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
						SpecialTeleporter.adjustPosY(player);
					}
				}
			}
		}
	}
}