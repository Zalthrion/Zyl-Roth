package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DismissMessage implements IMessage {
	public DismissMessage() {}
	
	@Override public void fromBytes(ByteBuf buffer) {}
	@Override public void toBytes(ByteBuf buffer) {}
	
	public static class Handler implements IMessageHandler<DismissMessage, IMessage> {
		@Override public IMessage onMessage(DismissMessage message, MessageContext context) {
			EntityPlayer player = context.getServerHandler().playerEntity;
			if (player != null) {
				NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
				if (persistentData.hasKey("ownsMount")) {
					Iterator<Entity> iterator = player.worldObj.loadedEntityList.iterator();
					while (iterator.hasNext()) {
						Entity anEntity = iterator.next();
						if (anEntity.getUniqueID().toString().equalsIgnoreCase(persistentData.getString("ownsMount"))) {
							anEntity.setDead();
							persistentData.removeTag("ownsMount");
							persistentData.removeTag("ownedMountId");
							persistentData.removeTag("ownsMountSavageBadger");
							persistentData.removeTag("ownsMountPlaguedHorse");
							persistentData.removeTag("ownsMountDeathcharger");
							persistentData.removeTag("ownsMountSwiftUnicorn");
							persistentData.removeTag("ownsMountWarTortoise");
							player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
						}
					}
				}
			}
			return new SummonedMountMessage(-1);
		}
	}
}