package com.zalthrion.zylroth.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

public class IceTalisman extends ItemBase {
	private String name = "iceTalisman";
	
	public IceTalisman() {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (ConfigurationHandler.getGlaciemEnabled()) {
			if (!world.isRemote) {
				int glaciemId = ConfigurationHandler.getGlaciemId();
				if (player instanceof EntityPlayerMP) {
					EntityPlayerMP playerMP = (EntityPlayerMP) player;
					WorldServer ws = playerMP.mcServer.worldServerForDimension(glaciemId);
					Teleporter teleporter = new SpecialTeleporter(ws);
					
					if (!(player.dimension == glaciemId) && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, glaciemId, teleporter);
						SpecialTeleporter.adjustPosY(player);
					} else if (player.dimension == glaciemId && player.ridingEntity == null) {
						playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
						SpecialTeleporter.adjustPosY(player);
					}
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}