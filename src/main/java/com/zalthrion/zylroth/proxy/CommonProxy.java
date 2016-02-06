package com.zalthrion.zylroth.proxy;

import com.zalthrion.zylroth.event.PlayerEventHandler;

import cpw.mods.fml.common.FMLCommonHandler;

public class CommonProxy implements IProxy {
	
	@Override
	public void registerRenderInformation() { // Client side texture registering
	}
	
	@Override
	public void registerTiles() { // For registering TileEntities
	}
	
	@Override
	public void registerBlocks() { // For registering Blocks
	}
	
	@Override
	public void registerItems() { // For registering Items
	}
	
	@Override
	public void registerRenderers() { // For registering renderers
	}
	
	@Override
	public void preInit() {}
	
	@Override
	public void init() { // For registering stuff on the init
		FMLCommonHandler.instance().bus().register(new PlayerEventHandler());
	}
}
