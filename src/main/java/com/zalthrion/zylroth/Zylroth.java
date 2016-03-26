package com.zalthrion.zylroth;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import com.zalthrion.zylroth.proxy.CommonProxy;
import com.zalthrion.zylroth.reference.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
/*---------------------------------------------------------------------------*/
public class Zylroth {
	
	@Mod.Instance(Reference.MOD_ID) public static Zylroth instance;
	@SidedProxy(
			clientSide = Reference.CLIENT_PROXY,
			serverSide = Reference.COMMON_PROXY) public static CommonProxy proxy;
	
	@Mod.EventHandler public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
	}
	
	@Mod.EventHandler public void init(FMLInitializationEvent event) {
		proxy.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	@Mod.EventHandler public void serverStarting(FMLServerStartingEvent event) {
		proxy.init();
	}
}