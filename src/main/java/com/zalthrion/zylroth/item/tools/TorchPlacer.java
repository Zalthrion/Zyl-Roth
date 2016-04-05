package com.zalthrion.zylroth.item.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TorchPlacer {
	private static ItemStack getTorchStack(EntityPlayer player) {
		if (player.inventory.offHandInventory[0] != null) {
			if (player.inventory.offHandInventory[0].getItem() == Item.getItemFromBlock(Blocks.torch)) {
				return player.inventory.offHandInventory[0];
			}
		}
		for (int i = 0; i < player.inventory.mainInventory.length; i ++) {
			if (player.inventory.getStackInSlot(i) != null) {
				if (player.inventory.getStackInSlot(i).getItem() == Item.getItemFromBlock(Blocks.torch)) {
					return player.inventory.getStackInSlot(i);
				}
			}
		}
		return null;
	}
	
	private static void clearEmptyStacks(EntityPlayer player) {
		if (player.inventory.offHandInventory[0] != null) {
			if (player.inventory.offHandInventory[0].getItem() == Item.getItemFromBlock(Blocks.torch)) {
				if (player.inventory.offHandInventory[0].stackSize <= 0) player.inventory.offHandInventory[0] = null;
			}
		}
		for (int i = 0; i < player.inventory.mainInventory.length; i ++) {
			if (player.inventory.getStackInSlot(i) != null) {
				if (player.inventory.getStackInSlot(i).getItem() == Item.getItemFromBlock(Blocks.torch)) {
					if (player.inventory.getStackInSlot(i).stackSize <= 0) player.inventory.removeStackFromSlot(i);
				}
			}
		}
	}
	
	public static void tryPlaceTorch(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing) {
		if (player.canPlayerEdit(pos, facing, stack)) {
			ItemStack torch = getTorchStack(player);
			if (torch == null && !player.capabilities.isCreativeMode) return;
			if (torch == null) torch = new ItemStack(Blocks.torch);
			if (!world.isRemote && Blocks.torch.canPlaceBlockAt(world, pos)) {
				world.setBlockState(pos, Blocks.torch.getDefaultState());
				torch.stackSize --;
				if (torch.stackSize <= 0) clearEmptyStacks(player);
			}
		}
	}
}