package com.zalthrion.zylroth.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.event.MountEntityEventListener;
import com.zalthrion.zylroth.handler.FuelHandler;
import com.zalthrion.zylroth.handler.GuiHandler;
import com.zalthrion.zylroth.lib.ModInit;
import com.zalthrion.zylroth.world.generator.WorldOreGenerator;

public class CommonProxy {
	public void preInit() {
		ModInit.preInit();
		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Zylroth.instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new MountEntityEventListener());
		ModInit.init();
	}
	
	public void postInit() {}
}