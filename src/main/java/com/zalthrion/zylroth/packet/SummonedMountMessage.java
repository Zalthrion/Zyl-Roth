package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SummonedMountMessage implements IMessage {
	public static int summonedMountStatic = -1;
	private int summonedMount;
	
	public SummonedMountMessage() {}
	public SummonedMountMessage(int summonedMount) {
		this.summonedMount = summonedMount;
	}
	
	@Override public void fromBytes(ByteBuf buffer) {
		this.summonedMount = buffer.readInt();
	}
	
	@Override public void toBytes(ByteBuf buffer) {
		buffer.writeInt(this.summonedMount);
	}
	
	public static class Handler implements IMessageHandler<SummonedMountMessage, IMessage> {
		@Override public IMessage onMessage(SummonedMountMessage message, MessageContext content) {
			SummonedMountMessage.summonedMountStatic = message.summonedMount;
			return null;
		}
	}
}