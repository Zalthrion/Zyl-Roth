package com.zalthrion.zylroth.proxy;

import net.minecraftforge.fml.common.FMLCommonHandler;

import com.zalthrion.zylroth.event.PlayerEventHandler;

public class CommonProxy implements IProxy {
	
	@Override public void registerRenderInformation() {} // Client side texture registering
	@Override public void registerRenderers() {} // For registering renderers
	
	@Override
	public void init() { // For registering stuff on the init
		FMLCommonHandler.instance().bus().register(new PlayerEventHandler());
	}

	@Override public void registerItemRenderers() {}
	@Override public void bindTileEntitySpecialRenderers() {}
}
