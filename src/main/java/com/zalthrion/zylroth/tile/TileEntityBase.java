package com.zalthrion.zylroth.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBase extends TileEntity implements IInventory {
	@Override
	public int getSizeInventory() {
		return 0;
	}
	
	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return null;
	}
	
	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		return null;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack itemStack) {
		
	}
	
	@Override
	public String getInventoryName() {
		return null;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return false;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return false;
	}
	
	@Override
	public boolean isCustomInventoryName() {
		return false;
	}
	
	@Override
	public void openChest() {
		
	}
	
	@Override
	public void closeChest() {
		
	}
}