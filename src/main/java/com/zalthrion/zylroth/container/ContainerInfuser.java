package com.zalthrion.zylroth.container;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.base.ContainerBase;

public class ContainerInfuser extends ContainerBase {
	private final IInventory tileInfuser;
	private int lastBurnTime;
	private int lastInfusionTime;
	private int lastTotalInfusionTime;
	
	public static final int INPUT = 0;
	public static final int INFUSION_MATERIAL_ONE = 1;
	public static final int INFUSION_MATERIAL_TWO = 2;
	public static final int FUEL = 3;
	public static final int OUTPUT = 4;
	
	public ContainerInfuser(InventoryPlayer playerInventory, IInventory infuserInventory) {
		this.tileInfuser = infuserInventory;
		
		this.addSlotToContainer(new Slot(infuserInventory, INPUT, 46, 33));
		this.addSlotToContainer(new Slot(infuserInventory, INFUSION_MATERIAL_ONE, 46, 7));
		this.addSlotToContainer(new Slot(infuserInventory, INFUSION_MATERIAL_TWO, 46, 61));
		this.addSlotToContainer(new SlotInfuserFuel(infuserInventory, FUEL, 16, 61));
		this.addSlotToContainer(new SlotInfuserOutput(playerInventory.player, infuserInventory, OUTPUT, 126, 33));
		
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 9; j ++) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 91 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i ++) {
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 149));
		}
	}
	
	@Override public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileInfuser);
	}
	
	@Override public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.listeners.size(); i ++) {
			IContainerListener listener = (IContainerListener) this.listeners.get(i);
			
			if (this.lastBurnTime != this.tileInfuser.getField(0)) {
				listener.sendProgressBarUpdate(this, 0, this.tileInfuser.getField(0));
			}
			
			if (this.lastInfusionTime != this.tileInfuser.getField(2)) {
				listener.sendProgressBarUpdate(this, 2, this.tileInfuser.getField(2));
			}
			
			if (this.lastTotalInfusionTime != this.tileInfuser.getField(3)) {
				listener.sendProgressBarUpdate(this, 3, this.tileInfuser.getField(3));
			}
		}
		
		this.lastBurnTime = this.tileInfuser.getField(0);
		this.lastInfusionTime = this.tileInfuser.getField(2);
		this.lastTotalInfusionTime = this.tileInfuser.getField(3);
	}
	
	@Override @SideOnly(Side.CLIENT) public void updateProgressBar(int id, int data) {
		this.tileInfuser.setField(id, data);
	}
	
	@Override public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileInfuser.isUseableByPlayer(playerIn);
	}
	
	@Override @Nullable public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
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
}