package com.zalthrion.zylroth.container;

import com.zalthrion.zylroth.gui.slot.*;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerInfuser extends ContainerBase
{
	TileEntityInfuser infuser;
	
	private int lastCookTime;

	private int lastBurnTime;

	private int lastItemBurnTime;
	
	public static final int INPUT = 0, OUTPUT = 1, FUEL = 2, RESIDUE = 3;
	

	public ContainerInfuser(InventoryPlayer inventoryPlayer, TileEntityInfuser tile)
	{
		this.infuser = tile;

		this.addSlotToContainer(new Slot(tile, INPUT, 34, 27)); //Input
		this.addSlotToContainer(new SlotInfuser(inventoryPlayer.player, tile, OUTPUT, 126, 27)); //Output
		this.addSlotToContainer(new Slot(tile, FUEL, 80, 1)); //Essence
		this.addSlotToContainer(new Slot(tile, RESIDUE, 80, 55)); //Residue
		
		
		bindPlayerInventory(inventoryPlayer);
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 9; j++) {
		addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 85 + i * 18));
		}
		}

		for (int i = 0; i < 9; i++) {
		addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 143));
		}
		}
	
	@Override
	public void addCraftingToCrafters(ICrafting icrafting) {
		
		icrafting.sendProgressBarUpdate(this, 0, this.infuser.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.infuser.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.infuser.currentItemBurnTime);
		
		super.addCraftingToCrafters(icrafting);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastCookTime != this.infuser.cookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.infuser.cookTime);
			}

			if (this.lastBurnTime != this.infuser.burnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.infuser.burnTime);
			}

			if (this.lastItemBurnTime != this.infuser.currentItemBurnTime)
			{
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
		switch(bar) {
		case 0: this.infuser.cookTime = value; break;
		case 1: this.infuser.burnTime = value; break;
		case 2: this.infuser.currentItemBurnTime = value; break;
		default: throw new IllegalArgumentException("Invalid progress bar for Infuser");
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		ItemStack stack = null;
		Slot slot = (Slot)this.inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()){
			ItemStack slotstack = slot.getStack();
			stack = slotstack.copy();
			
			if(index == 2){
				if(!this.mergeItemStack(slotstack, 8, this.inventorySlots.size(), false))
					return null;
				
			} else if(!this.getSlot(0).isItemValid(stack)||!this.mergeItemStack(stack,0,4,false));
			
			if(slotstack.stackSize==0){
				slot.putStack((ItemStack) null);
				
			} else {
				slot.onSlotChanged();
				
			}
			
			if(slotstack.stackSize==stack.stackSize) 
				return null;
			
			slot.onPickupFromSlot(player,slotstack);
		}
		return stack;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.infuser.isUseableByPlayer(player);
	}
}