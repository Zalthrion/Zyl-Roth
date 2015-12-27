package com.zalthrion.zylroth.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.gui.slot.SlotInfuser;
import com.zalthrion.zylroth.gui.slot.SlotInfuser.InfuserType;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

public class ContainerOreInfuser extends ContainerBase {
	TileEntityOreInfuser oreInfuser;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public static final int INPUT = 0, OUTPUT = 1, FIRST_FUEL = 2, SECOND_FUEL = 3;
	
	public ContainerOreInfuser(InventoryPlayer inventoryPlayer, TileEntityOreInfuser tile) {
		this.oreInfuser = tile;
		
		this.addSlotToContainer(new Slot(tile, INPUT, 34, 33));
		this.addSlotToContainer(new SlotInfuser(inventoryPlayer.player, tile, OUTPUT, 119, 33, InfuserType.ORE));
		this.addSlotToContainer(new Slot(tile, FIRST_FUEL, 57, 11));
		this.addSlotToContainer(new Slot(tile, SECOND_FUEL, 57, 55));
		
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
		
		icrafting.sendProgressBarUpdate(this, 0, this.oreInfuser.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.oreInfuser.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.oreInfuser.currentItemBurnTime);
		
		super.onCraftGuiOpened(icrafting);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++ i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastCookTime != this.oreInfuser.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.oreInfuser.cookTime);
			}
			
			if (this.lastBurnTime != this.oreInfuser.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.oreInfuser.burnTime);
			}
			
			if (this.lastItemBurnTime != this.oreInfuser.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.oreInfuser.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.oreInfuser.cookTime;
		this.lastBurnTime = this.oreInfuser.burnTime;
		this.lastItemBurnTime = this.oreInfuser.currentItemBurnTime;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int bar, int value) {
		switch (bar) {
			case 0:
				this.oreInfuser.cookTime = value;
				break;
			case 1:
				this.oreInfuser.burnTime = value;
				break;
			case 2:
				this.oreInfuser.currentItemBurnTime = value;
				break;
			default:
				throw new IllegalArgumentException("Invalid progress bar for Ore Infuser");
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
			}
			else if (!slot.isItemValid(stack)) {
				return null;
			}
			else if (!mergeItemStack(stack, 0, 1, false)) { return null; }
			if (stack.stackSize == 0) {
				slot.putStack(null);
			}
			else {
				slot.onSlotChanged();
			}
		}
		oreInfuser.markDirty();
		return itemstack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.oreInfuser.isUseableByPlayer(player);
	}
}