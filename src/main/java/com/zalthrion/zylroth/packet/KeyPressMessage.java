package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.zalthrion.zylroth.handler.MountData;

public class KeyPressMessage implements IMessage {
	public KeyPressMessage() {}
	
	@Override public void fromBytes(ByteBuf buffer) {}
	@Override public void toBytes(ByteBuf buffer) {}
	
	public static class Handler implements IMessageHandler<KeyPressMessage, IMessage> {
		@Override public IMessage onMessage(KeyPressMessage message, final MessageContext context) {
			IThreadListener handler = (WorldServer) context.getServerHandler().playerEntity.worldObj;
			handler.addScheduledTask(new Runnable() {
				@Override public void run() {
					EntityPlayer player = context.getServerHandler().playerEntity;
					if (player != null) {
						MountData data = MountData.get(player);
						if (data.ownsMount()) {
							SummonedMountMessage message1 = new SummonedMountMessage(data.ownedMountID());
							PacketHandler.network.sendTo(message1, (EntityPlayerMP) player);
						} else {
							SummonedMountMessage message1 = new SummonedMountMessage();
							PacketHandler.network.sendTo(message1, (EntityPlayerMP) player);
						}
					}
				}
			});
			return null;
		}
	}
}