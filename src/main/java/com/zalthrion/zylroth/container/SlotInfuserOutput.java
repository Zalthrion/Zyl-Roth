package com.zalthrion.zylroth.container;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class SlotInfuserOutput extends Slot {
	private EntityPlayer thePlayer;
	private int field_75228_b;
	
	public SlotInfuserOutput(EntityPlayer player, IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		this.thePlayer = player;
	}
	
	@Override public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	@Override public ItemStack decrStackSize(int amount) {
		if (this.getHasStack()) {
			this.field_75228_b += Math.min(amount, this.getStack().stackSize);
		}
		
		return super.decrStackSize(amount);
	}
	
	@Override public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack) {
		this.onCrafting(stack);
		super.onPickupFromSlot(playerIn, stack);
	}
	
	@Override protected void onCrafting(ItemStack stack, int amount) {
		this.field_75228_b += amount;
		this.onCrafting(stack);
	}
	
	@Override protected void onCrafting(ItemStack stack) {
		stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);;
		
		if (!this.thePlayer.worldObj.isRemote) {
			int i = this.field_75228_b;
			float f = ((TileEntityInfuser) this.inventory).getExperienceStored();
			if (f == 0.0F) {
				i = 0;
			} else if (f < 1.0F) {
				int j = MathHelper.floor_float((float) i * f);
				if (j < MathHelper.ceiling_float_int((float) i * f) && Math.random() < (double) ((float) i * f - (float) j)) {
					j ++;
				}
				i = j;
			}
			while (i > 0) {
				int k = EntityXPOrb.getXPSplit(i);
				i -= k;
				this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, k));
			}
		}
		
		this.field_75228_b = 0;
		((TileEntityInfuser) this.inventory).setExperienceStored(0);
	}
}