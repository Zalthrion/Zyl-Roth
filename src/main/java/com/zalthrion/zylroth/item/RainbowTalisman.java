package com.zalthrion.zylroth.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

public class RainbowTalisman extends ItemBase {
	private String name = "rainbowTalisman";
	
	public RainbowTalisman() {
		super();
		this.setUnlocalizedName(name);
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (ConfigurationHandler.getIridisEnabled()) {
			if (!world.isRemote) {
				int iridisId = ConfigurationHandler.getIridisId();
				if (player instanceof EntityPlayerMP) {
					EntityPlayerMP playerMP = (EntityPlayerMP) player;
					WorldServer ws = playerMP.mcServer.worldServerForDimension(iridisId);
					Teleporter teleporter = new SpecialTeleporter(ws);
					
					if (!(player.dimension == iridisId) && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, iridisId, teleporter);
						SpecialTeleporter.adjustPosY(player);
					} else if (player.dimension == iridisId && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
						SpecialTeleporter.adjustPosY(player);
					}
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}