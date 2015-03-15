package com.zalthrion.zylroth;

import com.zalthrion.zylroth.handler.FuelHandler;
import com.zalthrion.zylroth.handler.GuiHandler;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.proxy.*;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.world.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/*---------------------------------------------------------------------------*/

@Mod(modid=Reference.MOD_ID,name=Reference.MOD_NAME, version = Reference.VERSION)

/*---------------------------------------------------------------------------*/

public class Zylroth {
	
	@Mod.Instance(Reference.MOD_ID)

	public static Zylroth instance ;
	
/*---------------------------------------------------------------------------*/

	@SidedProxy
	(clientSide = Reference.CLIENT_PROXY, 
	serverSide = Reference.SERVER_PROXY)
	
	public static IProxy proxy;
	
/*---------------------------------------------------------------------------*/
	
@Mod.EventHandler
 public void preInit(FMLPreInitializationEvent event) {
	
	ModBlocks.init();
	
	ModItems.init();
	
	GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
	
	GameRegistry.registerFuelHandler(new FuelHandler());
	 
  }

/*---------------------------------------------------------------------------*/
	 
@Mod.EventHandler
 public void init(FMLInitializationEvent event) {
	
	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	
	ModEntity.init();
	
	ModRecipes.init();
	
	ModRecipesInfuser.init();
	
	proxy.registerBlocks();
	
	proxy.registerItems();
	
	proxy.registerRenderers();

  }

/*---------------------------------------------------------------------------*/
	 
@Mod.EventHandler
 public void postInit(FMLPostInitializationEvent event) {
	 
  }

/*---------------------------------------------------------------------------*/

@Mod.EventHandler 
 public void serverStarting(FMLServerStartingEvent event) {
	
	proxy.init();
	
  }

/*---------------------------------------------------------------------------*/
	
}