package com.zalthrion.zylroth.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.gui.slot.SlotInfuserFuel;
import com.zalthrion.zylroth.gui.slot.SlotInfuserOutput;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerInfuser extends ContainerBase {
	private final TileEntityInfuser tileInfuser;
	private int lastBurnTime;
	private int lastInfusionTime;
	private int lastTotalInfusionTime;
	private int lastItemBurnTime;
	
	public static final int INPUT = 0;
	public static final int INFUSION_MATERIAL_ONE = 1;
	public static final int INFUSION_MATERIAL_TWO = 2;
	public static final int FUEL = 3;
	public static final int OUTPUT = 4;
	
	public ContainerInfuser(InventoryPlayer playerInventory, TileEntityInfuser infuserInventory) {
		this.tileInfuser = infuserInventory;
		
		this.addSlotToContainer(new Slot(infuserInventory, INPUT, 46, 33));
		this.addSlotToContainer(new Slot(infuserInventory, INFUSION_MATERIAL_ONE, 46, 7));
		this.addSlotToContainer(new Slot(infuserInventory, INFUSION_MATERIAL_TWO, 46, 61));
		this.addSlotToContainer(new SlotInfuserFuel(infuserInventory, FUEL, 16, 61));
		this.addSlotToContainer(new SlotInfuserOutput(playerInventory.player, infuserInventory, OUTPUT, 126, 33));
		
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 9; j ++) {
				addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 91 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i ++) {
			addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 149));
		}
	}
	
	@Override
	public void onCraftGuiOpened(ICrafting icrafting) {
		super.onCraftGuiOpened(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.tileInfuser.infusionTime);
		icrafting.sendProgressBarUpdate(this, 1, this.tileInfuser.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.tileInfuser.itemBurnTime);;
		icrafting.sendProgressBarUpdate(this, 3, this.tileInfuser.totalInfusionTime);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); i ++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastInfusionTime != this.tileInfuser.infusionTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileInfuser.infusionTime);
			}
			
			if (this.lastBurnTime != this.tileInfuser.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileInfuser.burnTime);
			}
			
			if (this.lastItemBurnTime != this.tileInfuser.itemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileInfuser.itemBurnTime);;
			}
			
			if (this.lastTotalInfusionTime != this.tileInfuser.totalInfusionTime) {
				icrafting.sendProgressBarUpdate(this, 3, this.tileInfuser.totalInfusionTime);
			}
		}
		
		this.lastInfusionTime = this.tileInfuser.infusionTime;
		this.lastBurnTime = this.tileInfuser.burnTime;
		this.lastItemBurnTime = this.tileInfuser.itemBurnTime;
		this.lastTotalInfusionTime = this.tileInfuser.totalInfusionTime;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int bar, int value) {
		if (bar == 0) {
			this.tileInfuser.infusionTime = value;
		}
		
		if (bar == 1) {
			this.tileInfuser.burnTime = value;
		}
		
		if (bar == 2) {
			this.tileInfuser.itemBurnTime = value;
		}
		
		if (bar == 3) {
			this.tileInfuser.totalInfusionTime = value;
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = null;
		Slot slot = (Slot) inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack stack = slot.getStack();
			itemstack = stack.copy();
			
			if (index == 4) {
				if (!this.mergeItemStack(stack, 5, 41, true)) {
					return null;
				}
				slot.onSlotChange(stack, itemstack);
			} else if (index != 3 && index != 2 && index != 1 && index != 0) {
				if (!this.mergeItemStack(stack, 0, 4, false)) {
					return null;
				} else if (index >= 5 && index < 32) {
					if (this.mergeItemStack(stack, 32, 41, false)) {
						return null;
					}
				} else if (index >= 32 && index < 41 && this.mergeItemStack(stack, 5, 32, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(stack, 5, 41, false)) {
				return null;
			}
			
			if (stack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			
			if (stack.stackSize == itemstack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(playerIn, stack);
		}
		return itemstack;
	}
	
	@Override public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileInfuser.isUseableByPlayer(playerIn);
	}
}