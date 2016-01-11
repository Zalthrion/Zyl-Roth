package com.zalthrion.zylroth.packet;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class SummonedMountMessage implements IMessage {
	public static int summonedMountStatic = -1;
	private int summonedMount;
	
	public SummonedMountMessage() {
		this.summonedMount = -1;
	}
	
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