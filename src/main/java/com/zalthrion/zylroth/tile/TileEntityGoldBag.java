package com.zalthrion.zylroth.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityGoldBag extends TileEntity {
	/** The direction this tile entity is facing */
	private EnumFacing facing;
	
	public void setFacing(EnumFacing facing) {
		this.facing = facing;
	}
	
	public EnumFacing getFacing() {
		return this.facing;
	}
	
	/* TileEntity */
	
	@Override public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.facing = EnumFacing.byName(compound.getString("Facing"));
	}
	
	@Override public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setString("Facing", this.facing.getName2());
	}
}