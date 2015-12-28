package com.zalthrion.zylroth.world.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class SpecialTeleporter extends Teleporter {
	protected final WorldServer worldServer;
	public int xPos;
	public int yPos;
	public int zPos;
	
	public SpecialTeleporter(WorldServer worldServer) {
		super(worldServer);
		this.worldServer = worldServer;
	}
	
	public SpecialTeleporter(WorldServer server, int posX, int posY, int posZ) {
		this(server);
		this.xPos = posX;
		this.yPos = posY;
		this.zPos = posZ;
	}
	
	public void adjustPos(Entity entity) {
		int y = 0;
		if (yPos == -1) {
			for (int i = 256; i > 0; i --) {
				if (entity.worldObj.getBlockState(new BlockPos(xPos, i, zPos)).getBlock() != Blocks.air) {
					y = i + 1;
					break;
				}
			}
		} else {
			y = yPos;
		}
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).setPositionAndUpdate((double) xPos + 0.5D, y + 1, (double) zPos + 0.5D);
		} else {
			entity.setPosition((double) xPos + 0.5D, y + 1, (double) zPos + 0.5D);
		}
	}
	
	@Override
	public boolean makePortal(Entity entity) {
		return true;
	}
	
	@Override public void removeStalePortalLocations(long par1) {}
}