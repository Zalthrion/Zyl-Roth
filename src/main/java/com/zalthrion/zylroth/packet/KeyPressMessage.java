package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.handler.MountCapability.MountData;

public class KeyPressMessage implements IMessage {
	public KeyPressMessage() {}
	
	@Override public void fromBytes(ByteBuf buf) {}
	@Override public void toBytes(ByteBuf buf) {}
	
	public static class Handler implements IMessageHandler<KeyPressMessage, IMessage> {
		@Override public IMessage onMessage(KeyPressMessage message, final MessageContext ctx) {
			IThreadListener handler = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
			handler.addScheduledTask(new Runnable() {
				@Override public void run() {
					EntityPlayer player = ctx.getServerHandler().playerEntity;
					if (player != null) {
						MountData data = player.getCapability(Zylroth.MOUNT_CAP, null);
						if (data.ownsMount()) {
							SummonedMountMessage message1 = new SummonedMountMessage(data.getOwnedMountId());
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