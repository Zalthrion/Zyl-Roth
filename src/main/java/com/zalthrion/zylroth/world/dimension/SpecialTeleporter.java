package com.zalthrion.zylroth.world.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.BlockFluidBase;

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
		boolean generatePlatform = false;
		if (yPos == -1) {
			for (int i = 256; i > entity.worldObj.getSeaLevel() - 1; i --) {
				Block block = entity.worldObj.getBlockState(new BlockPos(xPos, i, zPos)).getBlock();
				if (block != Blocks.air) {
					y = i + 1;
					if (block instanceof BlockFluidBase || block instanceof BlockLiquid) generatePlatform = true;
					break;
				} else {
					if (i == entity.worldObj.getSeaLevel()) {
						y = i;
						generatePlatform = true;
					}
				}
			}
		} else {
			Block block = entity.worldObj.getBlockState(new BlockPos(xPos, yPos - 1, zPos)).getBlock();
			if (block instanceof BlockFluidBase || block instanceof BlockLiquid || block == Blocks.air) generatePlatform = true;
			y = yPos;
		}
		if (entity instanceof EntityPlayer) {
			if (generatePlatform) {
				BlockPos center = new BlockPos(xPos, yPos, zPos);
				entity.worldObj.setBlockState(center.north(2).west(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north(2).east(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north().west(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north().west(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north().east(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.north().east(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.west(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.west(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center, Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.east(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.east(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south().west(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south().west(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south().east(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south().east(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south(2).west(), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south(2), Blocks.stone.getDefaultState());
				entity.worldObj.setBlockState(center.south(2).east(), Blocks.stone.getDefaultState());
			}
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