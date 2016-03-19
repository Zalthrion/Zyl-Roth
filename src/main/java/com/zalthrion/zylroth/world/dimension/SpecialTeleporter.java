package com.zalthrion.zylroth.world.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

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
	
	public static class DimensionChanger {
		public static Entity changeDimension(Entity entityIn, int dimensionIn, Teleporter teleporter) {
			if (!entityIn.worldObj.isRemote && !entityIn.isDead) {
				if (!net.minecraftforge.common.ForgeHooks.onTravelToDimension(entityIn, dimensionIn)) return null;
				entityIn.worldObj.theProfiler.startSection("changeDimension");
				MinecraftServer minecraftserver = entityIn.getServer();
				int i = entityIn.dimension;
				WorldServer worldserver = minecraftserver.worldServerForDimension(i);
				WorldServer worldserver1 = minecraftserver.worldServerForDimension(dimensionIn);
				entityIn.dimension = dimensionIn;
				
				if (i == 1 && dimensionIn == 1) {
					worldserver1 = minecraftserver.worldServerForDimension(0);
					entityIn.dimension = 0;
				}
				
				entityIn.worldObj.removeEntity(entityIn);
				entityIn.isDead = false;
				entityIn.worldObj.theProfiler.startSection("reposition");
				BlockPos blockpos;
				
				if (dimensionIn == 1) {
					blockpos = worldserver1.getSpawnCoordinate();
				} else {
					double d0 = entityIn.posX;
					double d1 = entityIn.posZ;
					double d2 = 8.0D;
					
					if (dimensionIn == -1) {
						d0 = MathHelper.clamp_double(d0 / d2, worldserver1.getWorldBorder().minX() + 16.0D, worldserver1.getWorldBorder().maxX() - 16.0D);
						d1 = MathHelper.clamp_double(d1 / d2, worldserver1.getWorldBorder().minZ() + 16.0D, worldserver1.getWorldBorder().maxZ() - 16.0D);
					} else if (dimensionIn == 0) {
						d0 = MathHelper.clamp_double(d0 * d2, worldserver1.getWorldBorder().minX() + 16.0D, worldserver1.getWorldBorder().maxX() - 16.0D);
						d1 = MathHelper.clamp_double(d1 * d2, worldserver1.getWorldBorder().minZ() + 16.0D, worldserver1.getWorldBorder().maxZ() - 16.0D);
					}
					
					d0 = (double) MathHelper.clamp_int((int) d0, -29999872, 29999872);
					d1 = (double) MathHelper.clamp_int((int) d1, -29999872, 29999872);
					float f = entityIn.rotationYaw;
					entityIn.setLocationAndAngles(d0, entityIn.posY, d1, 90.0F, 0.0F);
					teleporter.placeInExistingPortal(entityIn, f);
					blockpos = new BlockPos(entityIn);
				}
				
				worldserver.updateEntityWithOptionalForce(entityIn, false);
				entityIn.worldObj.theProfiler.endStartSection("reloading");
				Entity entity = EntityList.createEntityByName(EntityList.getEntityString(entityIn), worldserver1);
				
				if (entity != null) {
					copyDataFromOld(entity, entityIn);
					
					if (i == 1 && dimensionIn == 1) {
						BlockPos blockpos1 = worldserver1.getTopSolidOrLiquidBlock(worldserver1.getSpawnPoint());
						entity.moveToBlockPosAndAngles(blockpos1, entity.rotationYaw, entity.rotationPitch);
					} else {
						entity.moveToBlockPosAndAngles(blockpos, entity.rotationYaw, entity.rotationPitch);
					}
					
					boolean flag = entity.forceSpawn;
					entity.forceSpawn = true;
					worldserver1.spawnEntityInWorld(entity);
					entity.forceSpawn = flag;
					worldserver1.updateEntityWithOptionalForce(entity, false);
				}
				
				entityIn.isDead = true;
				entityIn.worldObj.theProfiler.endSection();
				worldserver.resetUpdateEntityTick();
				worldserver1.resetUpdateEntityTick();
				entityIn.worldObj.theProfiler.endSection();
				return entity;
			} else {
				return null;
			}
		}
		
		public static void copyDataFromOld(Entity oldEntity, Entity entityIn) {
			NBTTagCompound nbttagcompound = new NBTTagCompound();
			entityIn.writeToNBT(nbttagcompound);
			nbttagcompound.removeTag("Dimension");
			oldEntity.readFromNBT(nbttagcompound);
			oldEntity.timeUntilPortal = entityIn.timeUntilPortal;
			BlockPos entityInLastPortalPos = ReflectionHelper.getPrivateValue(Entity.class, entityIn, "lastPortalPos");
			Vec3d entityInLastPortalVec = ReflectionHelper.getPrivateValue(Entity.class, entityIn, "lastPortalVec");
			EnumFacing entityInTeleportDirection = ReflectionHelper.getPrivateValue(Entity.class, entityIn, "teleportDirection");
			
			ReflectionHelper.setPrivateValue(Entity.class, oldEntity, entityInLastPortalPos, "lastPortalPos");
			ReflectionHelper.setPrivateValue(Entity.class, oldEntity, entityInLastPortalVec, "lastPortalVec");
			ReflectionHelper.setPrivateValue(Entity.class, oldEntity, entityInTeleportDirection, "teleportDirection");
		}
	}
}