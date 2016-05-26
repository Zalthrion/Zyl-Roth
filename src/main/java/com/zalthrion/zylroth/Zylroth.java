package com.zalthrion.zylroth;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.FuelHandler;
import com.zalthrion.zylroth.handler.GuiHandler;
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModDimension;
import com.zalthrion.zylroth.lib.ModEntity;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModOreDictionary;
import com.zalthrion.zylroth.lib.ModRecipes;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.packet.PacketHandler;
import com.zalthrion.zylroth.proxy.IProxy;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.world.WorldOreGenerator;
import com.zalthrion.zylroth.world.WorldStructureGenerator;

import cpw.mods.fml.common.FMLCommonHandler;
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
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		PacketHandler.init();
		
		ModTools.init();

		ModArmors.init();
				
		ModBiomes.init();
		
		ModDimension.init();
		
		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
		
		GameRegistry.registerWorldGenerator(new WorldStructureGenerator(), 12);
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		
		proxy.preInit();
	}
	
	/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
		ModItems.init();
		
		ModBlocks.init();
				
		ModEntity.init();
				
		ModRegistry.register();
		
		ModOreDictionary.init();
		
		ModRecipes.init();
		
		proxy.init();
		
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