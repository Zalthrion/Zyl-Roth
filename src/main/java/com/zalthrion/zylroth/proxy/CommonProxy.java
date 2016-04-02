package com.zalthrion.zylroth.proxy;

import net.minecraftforge.common.capabilities.CapabilityManager;

import com.zalthrion.zylroth.handler.MountCapabilityHolder;
import com.zalthrion.zylroth.handler.MountCapabilityHolder.MountData;
import com.zalthrion.zylroth.lib.ModInit;

public class CommonProxy {
	public void preInit() {
		ModInit.preInit();
	}
	
	public void init() {
		CapabilityManager.INSTANCE.register(MountData.class, new MountCapabilityHolder.MountCapabilityStorage(), new MountCapabilityHolder.Factory());
	}
	
	public void postInit() {}
}