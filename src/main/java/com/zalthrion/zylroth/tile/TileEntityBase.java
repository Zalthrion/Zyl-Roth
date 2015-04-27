package com.zalthrion.zylroth.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

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

	@Override public String getCommandSenderName() {
		return "TEBase";
	}

	@Override public boolean hasCustomName() {
		return false;
	}

	@Override public IChatComponent getDisplayName() {
		return new ChatComponentText(getCommandSenderName());
	}

	@Override public void openInventory(EntityPlayer player) {
		
	}

	@Override public void closeInventory(EntityPlayer player) {
		
	}

	@Override public int getField(int id) {
		return 0;
	}

	@Override public void setField(int id, int value) {
		
	}

	@Override public int getFieldCount() {
		return 0;
	}

	@Override public void clear() {
		
	}
}