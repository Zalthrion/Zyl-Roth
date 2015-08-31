package com.zalthrion.zylroth.world.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class SpecialTeleporter extends Teleporter {
	protected final WorldServer worldServer;
	
	public SpecialTeleporter(WorldServer worldServer) {
		super(worldServer);
		this.worldServer = worldServer;
	}
	
	public static void adjustPosY(Entity entity) {
		int x = MathHelper.floor_double(entity.posX);
		int z = MathHelper.floor_double(entity.posZ);
		int y = entity.worldObj.getHeightValue(x, z);
		switch (entity.worldObj.provider.dimensionId) {
			case -1:
				y -= 10;
				boolean flag = true;
				while (y > 30 && flag) {
					if (entity.worldObj.getBlock(x, y, z).getMaterial().blocksMovement() && entity.worldObj.isAirBlock(x, y + 1, z) && entity.worldObj.isAirBlock(x, y + 2, z)) {
						flag = false;
					}
					else {
						-- y;
					}
				}
				break;
			default:
		}
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).setPositionAndUpdate((double) x + 0.5D, y + 1, (double) z + 0.5D);
		}
		else {
			entity.setPosition((double) x + 0.5D, y + 1, (double) z + 0.5D);
		}
	}
	
	@Override
	public void placeInPortal(Entity entity, double dx, double dy, double dz, float yaw) {
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).setPositionAndUpdate(dx, dy, dz);
		}
		else {
			entity.setPosition(dx, dy, dz);
		}
	}
	
	@Override
	public boolean makePortal(Entity entity) {
		return true;
	}
}