package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.reference.MountIDs;

public class SummonMessage implements IMessage {
	private int summon;
	
	public SummonMessage() {}
	public SummonMessage(int summon) {
		this.summon = summon;
	}
	
	@Override public void fromBytes(ByteBuf buffer) {
		this.summon = buffer.readInt();
	}
	
	@Override public void toBytes(ByteBuf buffer) {
		buffer.writeInt(this.summon);
	}
	
	public static class Handler implements IMessageHandler<SummonMessage, IMessage> {
		@Override public IMessage onMessage(SummonMessage message, MessageContext context) {
			EntityPlayer player = context.getServerHandler().playerEntity;
			if (player != null) {
				NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
				if (message.summon == MountIDs.savageBadger) {
					MountSavageBadger badger = new MountSavageBadger(player.worldObj);
					badger.copyLocationAndAnglesFrom(player);
					badger.onInitialSpawn(player.worldObj.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
					if (!persistentData.hasKey("ownsMount")) {
						badger.setOwnerId(player.getUniqueID().toString());
						badger.isSummoned(true);
						badger.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(badger);
						persistentData.setString("ownsMount", badger.getUniqueID().toString());
						persistentData.setInteger("ownedMountId", 0);
						persistentData.setString("ownsMountSavageBadger", badger.getUniqueID().toString()); // For
																											// compatibility
						player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
						player.mountEntity(badger);
					}
				} else if (message.summon == MountIDs.plaguedHorse) {
					MountPlaguedHorse plaguedHorse = new MountPlaguedHorse(player.worldObj);
					plaguedHorse.copyLocationAndAnglesFrom(player);
					plaguedHorse.onInitialSpawn(player.worldObj.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
					if (!persistentData.hasKey("ownsMount")) {
						plaguedHorse.setOwnerId(player.getUniqueID().toString());
						plaguedHorse.isSummoned(true);
						plaguedHorse.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(plaguedHorse);
						persistentData.setString("ownsMount", plaguedHorse.getUniqueID().toString());
						persistentData.setInteger("ownedMountId", 1);
						persistentData.setString("ownsMountPlaguedHorse", plaguedHorse.getUniqueID().toString()); // For
																													// compatibility
						player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
						player.mountEntity(plaguedHorse);
					}
				} else if (message.summon == MountIDs.deathcharger) {
					MountDeathcharger deathcharger = new MountDeathcharger(player.worldObj);
					deathcharger.copyLocationAndAnglesFrom(player);
					deathcharger.onInitialSpawn(player.worldObj.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
					if (!persistentData.hasKey("ownsMount")) {
						deathcharger.setOwnerId(player.getUniqueID().toString());
						deathcharger.isSummoned(true);
						deathcharger.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(deathcharger);
						persistentData.setString("ownsMount", deathcharger.getUniqueID().toString());
						persistentData.setInteger("ownedMountId", 2);
						persistentData.setString("ownsMountDeathcharger", deathcharger.getUniqueID().toString()); // For
																													// compatibility
						player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
						player.mountEntity(deathcharger);
					}
				} else if (message.summon == MountIDs.swiftUnicorn) {
					MountSwiftUnicorn swiftUnicorn = new MountSwiftUnicorn(player.worldObj);
					swiftUnicorn.copyLocationAndAnglesFrom(player);
					swiftUnicorn.onInitialSpawn(player.worldObj.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
					if (!persistentData.hasKey("ownsMount")) {
						swiftUnicorn.setOwnerId(player.getUniqueID().toString());
						swiftUnicorn.isSummoned(true);
						swiftUnicorn.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(swiftUnicorn);
						persistentData.setString("ownsMount", swiftUnicorn.getUniqueID().toString());
						persistentData.setInteger("ownedMountId", 3);
						persistentData.setString("ownsMountUnicorn", swiftUnicorn.getUniqueID().toString()); // For
																												// compatibility
						player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
						player.mountEntity(swiftUnicorn);
					}
				} else if (message.summon == MountIDs.warTortoise) {
					MountWarTortoise warTortoise = new MountWarTortoise(player.worldObj);
					warTortoise.copyLocationAndAnglesFrom(player);
					warTortoise.onInitialSpawn(player.worldObj.getDifficultyForLocation(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)), (IEntityLivingData) null);
					if (!persistentData.hasKey("ownsMount")) {
						warTortoise.setOwnerId(player.getUniqueID().toString());
						warTortoise.isSummoned(true);
						warTortoise.setTamedBy(player);
						player.worldObj.spawnEntityInWorld(warTortoise);
						persistentData.setString("ownsMount", warTortoise.getUniqueID().toString());
						persistentData.setInteger("ownedMountId", 4);
						persistentData.setString("ownsMountWarTortoise", warTortoise.getUniqueID().toString()); // For
																												// compatibility
						player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
						player.mountEntity(warTortoise);
					}
				}
			}
			return new SummonedMountMessage(message.summon);
		}
	}
}