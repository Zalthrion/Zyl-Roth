package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import com.zalthrion.zylroth.utility.LogHelper;

public class KeyPressMessage implements IMessage {
	public KeyPressMessage() {}
	
	@Override public void fromBytes(ByteBuf buffer) {}
	@Override public void toBytes(ByteBuf buffer) {}
	
	public static class Handler implements IMessageHandler<KeyPressMessage, IMessage> {
		@Override public IMessage onMessage(KeyPressMessage message, MessageContext context) {
			EntityPlayer player = context.getServerHandler().playerEntity;
			if (player != null) {
				NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
				LogHelper.warn(persistentData.hasKey("ownsMount"));
				if (persistentData.hasKey("ownsMount")) {
					int ownedMountId = persistentData.getInteger("ownedMountId");
					SummonedMountMessage message1 = new SummonedMountMessage(ownedMountId);
					PacketHandler.network.sendTo(message1, (EntityPlayerMP) player);
				} else {
					SummonedMountMessage message1 = new SummonedMountMessage(-1);
					PacketHandler.network.sendTo(message1, (EntityPlayerMP) player);
				}
			}
			return null;
		}
	}
}