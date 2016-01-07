package com.zalthrion.zylroth.world.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.BlockFluidBase;

import com.zalthrion.zylroth.utility.BlockPos;
import com.zalthrion.zylroth.utility.LogHelper;

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
			for (int i = 256; i > entity.worldObj.provider.getAverageGroundLevel(); i --) {
				Block block = entity.worldObj.getBlock(xPos, i, zPos);
				if (block != Blocks.air) {
					y = i + 1;
					if (block instanceof BlockFluidBase || block instanceof BlockLiquid) generatePlatform = true;
					break;
				} else {
					if (i == entity.worldObj.provider.getAverageGroundLevel()) {
						y = i;
						generatePlatform = true;
					}
				}
			}
		} else {
			Block block = entity.worldObj.getBlock(xPos, yPos - 1, zPos);
			if (block instanceof BlockFluidBase || block instanceof BlockLiquid || block == Blocks.air) generatePlatform = true;
			y = yPos;
		}
		if (entity instanceof EntityPlayer) {
			LogHelper.warn(generatePlatform);
			if (generatePlatform) {
				BlockPos center = new BlockPos(xPos, yPos, zPos);
				this.setBlock(entity.worldObj, center.north(2).west(), Blocks.stone);
				this.setBlock(entity.worldObj, center.north(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.north(2).east(), Blocks.stone);
				this.setBlock(entity.worldObj, center.north().west(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.north().west(), Blocks.stone);
				this.setBlock(entity.worldObj, center.north(), Blocks.stone);
				this.setBlock(entity.worldObj, center.north().east(), Blocks.stone);
				this.setBlock(entity.worldObj, center.north().east(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.west(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.west(), Blocks.stone);
				this.setBlock(entity.worldObj, center, Blocks.stone);
				this.setBlock(entity.worldObj, center.east(), Blocks.stone);
				this.setBlock(entity.worldObj, center.east(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.south().west(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.south().west(), Blocks.stone);
				this.setBlock(entity.worldObj, center.south(), Blocks.stone);
				this.setBlock(entity.worldObj, center.south().east(), Blocks.stone);
				this.setBlock(entity.worldObj, center.south().east(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.south(2).west(), Blocks.stone);
				this.setBlock(entity.worldObj, center.south(2), Blocks.stone);
				this.setBlock(entity.worldObj, center.south(2).east(), Blocks.stone);
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
	
	void setBlock(World world, BlockPos pos, Block block) {
		world.setBlock(pos.getX(), pos.getY(), pos.getZ(), block);
	}
}