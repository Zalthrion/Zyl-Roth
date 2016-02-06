package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import com.zalthrion.zylroth.handler.MountData;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class DismissMessage implements IMessage {
	public DismissMessage() {}
	
	@Override public void fromBytes(ByteBuf buffer) {}
	@Override public void toBytes(ByteBuf buffer) {}
	
	public static class Handler implements IMessageHandler<DismissMessage, IMessage> {
		@SuppressWarnings("unchecked")
		@Override public IMessage onMessage(DismissMessage message, MessageContext context) {
			EntityPlayer player = context.getServerHandler().playerEntity;
			if (player != null) {
				MountData data = MountData.get(player);
				if (data.ownsMount()) {
					Iterator<Entity> iterator = player.worldObj.loadedEntityList.iterator();
					while (iterator.hasNext()) {
						Entity anEntity = iterator.next();
						if (anEntity.getUniqueID().toString().equalsIgnoreCase(data.ownedMount())) anEntity.setDead();
					}
					data.disownMount();
				}
			}
			return new SummonedMountMessage();
		}
	}
}