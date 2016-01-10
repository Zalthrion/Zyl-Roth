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
import com.zalthrion.zylroth.proxy.IProxy;
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
	public static IProxy proxy;
	
	/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
		PacketHandler.init();
		KeyHandler.init();
		ModTools.init();
		ModArmors.init();
		ModBiomes.init();
		ModDimension.init();
		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
		GameRegistry.registerWorldGenerator(new WorldStructureGenerator(), 12);
		GameRegistry.registerFuelHandler(new FuelHandler());
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
		proxy.bindTileEntitySpecialRenderers();
		proxy.registerRenderInformation();
		proxy.registerItemRenderers();
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