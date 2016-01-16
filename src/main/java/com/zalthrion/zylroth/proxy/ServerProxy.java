package com.zalthrion.zylroth.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.zalthrion.zylroth.event.MountEntityEvent;
import com.zalthrion.zylroth.event.PlayerEventHandler;

public class ServerProxy {
	public void preInit() {}
	public void init() {
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		MinecraftForge.EVENT_BUS.register(new MountEntityEvent());
	}
	public void postInit() {}
}