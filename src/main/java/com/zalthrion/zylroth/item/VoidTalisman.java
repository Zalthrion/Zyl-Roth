package com.zalthrion.zylroth.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

public class VoidTalisman extends ItemBase {
	private String name = "voidTalisman";
	
	public VoidTalisman() {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (ConfigurationHandler.getKyrulEnabled()) {
			if (!world.isRemote) {
				int kyrulId = ConfigurationHandler.getKyrulId();
				if (player instanceof EntityPlayerMP) {
					EntityPlayerMP playerMP = (EntityPlayerMP) player;
					WorldServer ws = playerMP.mcServer.worldServerForDimension(kyrulId);
					Teleporter teleporter = new SpecialTeleporter(ws);
					
					if (!(player.dimension == kyrulId) && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, kyrulId, teleporter);
						SpecialTeleporter.adjustPosY(player);
					} else if (player.dimension == kyrulId && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
						SpecialTeleporter.adjustPosY(player);
					}
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}