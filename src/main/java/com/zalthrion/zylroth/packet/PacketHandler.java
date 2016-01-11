package com.zalthrion.zylroth.packet;

import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	public static final int summonPacketID = 0;
	public static final int dismissPacketID = 1;
	public static final int ownedMountsPacketID = 2;
	public static final int keyPressPacketID = 3;
	
	public static void init() {
		network.registerMessage(SummonMessage.Handler.class, SummonMessage.class, summonPacketID, Side.SERVER);
		network.registerMessage(DismissMessage.Handler.class, DismissMessage.class, dismissPacketID, Side.SERVER);
		network.registerMessage(SummonedMountMessage.Handler.class, SummonedMountMessage.class, ownedMountsPacketID, Side.CLIENT);
		network.registerMessage(KeyPressMessage.Handler.class, KeyPressMessage.class, keyPressPacketID, Side.SERVER);
	}
}