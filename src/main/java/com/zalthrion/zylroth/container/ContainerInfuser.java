package com.zalthrion.zylroth.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.gui.slot.SlotInfuser;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class ContainerInfuser extends ContainerBase {
	TileEntityInfuser infuser;
	
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public static final int INPUT = 0, OUTPUT = 1, FIRST_FUEL = 2, SECOND_FUEL = 3;
	
	public ContainerInfuser(InventoryPlayer inventoryPlayer, TileEntityInfuser tile) {
		this.infuser = tile;
		
		this.addSlotToContainer(new Slot(tile, INPUT, 34, 33));
		this.addSlotToContainer(new SlotInfuser(inventoryPlayer.player, tile, OUTPUT, 126, 33));
		this.addSlotToContainer(new Slot(tile, FIRST_FUEL, 80, 7));
		this.addSlotToContainer(new Slot(tile, SECOND_FUEL, 80, 61));
		
		bindPlayerInventory(inventoryPlayer);
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 9; j ++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 91 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i ++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 149));
		}
	}
	
	@Override
	public void onCraftGuiOpened(ICrafting icrafting) {
		
		icrafting.sendProgressBarUpdate(this, 0, this.infuser.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.infuser.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
		
		super.onCraftGuiOpened(icrafting);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++ i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastCookTime != this.infuser.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.infuser.cookTime);
			}
			
			if (this.lastBurnTime != this.infuser.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.infuser.burnTime);
			}
			
			if (this.lastItemBurnTime != this.infuser.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.infuser.cookTime;
		this.lastBurnTime = this.infuser.burnTime;
		this.lastItemBurnTime = this.infuser.currentItemBurnTime;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int bar, int value) {
		switch (bar) {
			case 0:
				this.infuser.cookTime = value;
				break;
			case 1:
				this.infuser.burnTime = value;
				break;
			case 2:
				this.infuser.currentItemBurnTime = value;
				break;
			default:
				throw new IllegalArgumentException("Invalid progress bar for Infuser");
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			itemstack = stack.copy();
			if (index < 4) {
				if (!mergeItemStack(stack, index, inventorySlots.size(), true)) { return null; }
			} else if (!slot.isItemValid(stack)) {
				return null;
			} else if (!mergeItemStack(stack, 0, 1, false)) { return null; }
			if (stack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
		}
		infuser.markDirty();
		return itemstack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.infuser.isUseableByPlayer(player);
	}
}