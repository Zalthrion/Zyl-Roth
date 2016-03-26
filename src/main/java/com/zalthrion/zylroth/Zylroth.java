package com.zalthrion.zylroth;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.FuelHandler;
import com.zalthrion.zylroth.handler.GuiHandler;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.packet.PacketHandler;
import com.zalthrion.zylroth.proxy.ServerProxy;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.world.WorldOreGenerator;
import com.zalthrion.zylroth.world.WorldStructureGenerator;

/*---------------------------------------------------------------------------*/

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
/*---------------------------------------------------------------------------*/
public class Zylroth {
	
	@Mod.Instance(Reference.MOD_ID)
	public static Zylroth instance;
	
	/*---------------------------------------------------------------------------*/
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static ServerProxy proxy;
	
	/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
		PacketHandler.init();
		KeyHandler.init();
		
		ModArmors.init();
		ModBlocks.init();
		ModBiomes.init();
		ModDimension.init();
		ModItems.init();
		ModTools.init();
		ModRegistry.register();
		
		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
		GameRegistry.registerWorldGenerator(new WorldStructureGenerator(), 12);
		GameRegistry.registerFuelHandler(new FuelHandler());
		proxy.preInit();
	}
	
	/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		ModEntity.init();
		ModOreDictionary.init();
		ModRecipes.init();
		proxy.init();
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