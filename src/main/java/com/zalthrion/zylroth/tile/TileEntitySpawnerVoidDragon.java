package com.zalthrion.zylroth.tile;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;

public class TileEntitySpawnerVoidDragon extends TileEntity implements ITickable {
	private int activationRange = 12;
	
	/* Custom Methods */
	
	public boolean isActivated() {
		return this.worldObj.isAnyPlayerWithinRangeAt(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D, this.activationRange);
	}
	
	/* Overridden */
	
	@Override public Packet<INetHandlerPlayClient> getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(this.pos, 1, nbtTag);
	}
	
	@Override public void update() {
		if (!this.worldObj.isRemote && this.isActivated()) {
			if (this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL) {
				EntityZombie mob = new EntityZombie(this.worldObj); // TODO EntityVoidDragon
				mob.setLocationAndAngles(this.pos.getX(), this.pos.getY(), this.pos.getZ(), MathHelper.wrapAngleTo180_float(this.worldObj.rand.nextFloat() * 360.0F), 10.0F);
				this.worldObj.spawnEntityInWorld(mob);
				this.worldObj.setBlockToAir(this.pos);
			}
		}
	}
}