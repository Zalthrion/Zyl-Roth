package com.zalthrion.zylroth.tile;

import com.zalthrion.zylroth.entity.EntityVoidDragon;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class TileEntitySpawnerVoidDragon extends TileEntity {
	
	private int activationRange = 12;
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbtTag);
	}
	
	public boolean isActivated() {
		return worldObj.getClosestPlayer(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, activationRange) != null;
	}
	
	@Override
	public void updateEntity() {
		if (!worldObj.isRemote && isActivated()) {
			EntityVoidDragon mob = new EntityVoidDragon(worldObj);
			mob.setLocationAndAngles(xCoord, yCoord, zCoord, MathHelper.wrapAngleTo180_float(worldObj.rand.nextFloat() * 360.0F), 10.0F);
			worldObj.spawnEntityInWorld(mob);
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
		}
	}
	
}
