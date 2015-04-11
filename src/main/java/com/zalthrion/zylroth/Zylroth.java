package com.zalthrion.zylroth;

//import net.minecraft.world.WorldType;

import com.zalthrion.zylroth.handler.FuelHandler;
import com.zalthrion.zylroth.handler.GuiHandler;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.proxy.IProxy;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.world.WorldStructureGenerator;
import com.zalthrion.zylroth.world.WorldOreGenerator;
//import com.zalthrion.zylroth.world.WorldTypeZylroth;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/*---------------------------------------------------------------------------*/

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

/*---------------------------------------------------------------------------*/

public class Zylroth {
	
	@Mod.Instance(Reference.MOD_ID)
	public static Zylroth instance;
	
/*---------------------------------------------------------------------------*/
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static IProxy proxy;
	
/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ModBiomes.init();
		
		ModBlocks.init();
		
		ModDimension.init();
		
		ModItems.init();
		
		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
		
		GameRegistry.registerWorldGenerator(new WorldStructureGenerator(), 12);
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		
	}
	
/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
		ModEntity.init();
		
		ModRecipes.init();
		
		proxy.registerBlocks();
		
		proxy.registerItems();
		
		proxy.registerRenderers();
		
	}
	
/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
//		WorldType ZylRoth = new WorldTypeZylroth(3, "zylroth");
		
	}
	
/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		
		proxy.init();
		
	}
	
/*---------------------------------------------------------------------------*/
	
}