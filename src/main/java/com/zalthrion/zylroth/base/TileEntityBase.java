package com.zalthrion.zylroth.base;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TileEntityBase extends TileEntity implements IInventory {
	@Override public void clear() {}
	
	@Override public void closeInventory(EntityPlayer player) {}
	
	@Override @Nullable public ItemStack decrStackSize(int index, int count) {
		return null;
	}
	
	@Override public ITextComponent getDisplayName() {
		return new TextComponentString(getName());
	}
	
	@Override public int getField(int id) {
		return 0;
	}
	
	@Override public int getFieldCount() {
		return 0;
	}
	
	@Override public int getInventoryStackLimit() {
		return 0;
	}
	
	@Override public String getName() {
		return "TEBase";
	}
	
	@Override public int getSizeInventory() {
		return 0;
	}
	
	@Override @Nullable public ItemStack getStackInSlot(int index) {
		return null;
	}
	
	@Override public boolean hasCustomName() {
		return false;
	}
	
	@Override public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}
	
	@Override public boolean isUseableByPlayer(EntityPlayer player) {
		return false;
	}
	
	@Override public void openInventory(EntityPlayer player) {}
	
	@Override @Nullable public ItemStack removeStackFromSlot(int index) {
		return null;
	}
	
	@Override public void setField(int id, int value) {}
	
	@Override public void setInventorySlotContents(int index, @Nullable ItemStack stack) {}
}