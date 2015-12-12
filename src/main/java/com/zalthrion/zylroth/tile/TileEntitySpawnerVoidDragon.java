package com.zalthrion.zylroth.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;

import com.zalthrion.zylroth.entity.EntityVoidDragon;

public class TileEntitySpawnerVoidDragon extends TileEntity implements ITickable {
	
	private int activationRange = 16;
	
	@Override
	public Packet<INetHandlerPlayClient> getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.pos, 1, nbtTag);
	}
	
	public boolean isActivated() {
		return worldObj.getClosestPlayer(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D, activationRange) != null;
	}
	
	@Override
	public void update() {
		if (!worldObj.isRemote && isActivated()) {
			EntityVoidDragon mob = new EntityVoidDragon(worldObj);
			mob.setLocationAndAngles(this.pos.getX(), this.pos.getY(), this.pos.getZ(), MathHelper.wrapAngleTo180_float(worldObj.rand.nextFloat() * 360.0F), 10.0F);
			worldObj.spawnEntityInWorld(mob);
			worldObj.setBlockToAir(this.pos);
		}
	}
	
}
