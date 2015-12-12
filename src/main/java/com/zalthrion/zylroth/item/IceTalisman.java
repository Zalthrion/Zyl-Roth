package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.world.dimension.SpecialTeleporter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class IceTalisman extends ItemBase {
	private String name = "iceTalisman";
	
	public IceTalisman() {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			if (player instanceof EntityPlayerMP) {
				EntityPlayerMP playerMP = (EntityPlayerMP) player;
				WorldServer ws = playerMP.mcServer.worldServerForDimension(49);
				Teleporter teleporter = new SpecialTeleporter(ws);
				
				if (!(player.dimension == 49) && player.ridingEntity == null) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 49, teleporter);
					SpecialTeleporter.adjustPosY(player);
				} else if (player.dimension == 49 && player.ridingEntity == null) {
					playerMP.mcServer.getConfigurationManager().transferPlayerToDimension(playerMP, 0, teleporter);
					SpecialTeleporter.adjustPosY(player);
				}
			}
		}
		
		return super.onItemRightClick(stack, world, player);
	}
}