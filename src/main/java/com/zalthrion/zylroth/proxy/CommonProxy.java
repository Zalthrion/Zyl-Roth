package com.zalthrion.zylroth.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.zalthrion.zylroth.event.MountEntityEvent;
import com.zalthrion.zylroth.event.PlayerEventHandler;

public class CommonProxy implements IProxy {
	
	@Override public void registerRenderInformation() {} // Client side texture registering
	@Override public void registerRenderers() {} // For registering renderers
	
	@Override
	public void init() { // For registering stuff on the init
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		MinecraftForge.EVENT_BUS.register(new MountEntityEvent());
	}

	@Override public void registerItemRenderers() {}
	@Override public void bindTileEntitySpecialRenderers() {}
}
