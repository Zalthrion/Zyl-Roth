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
		ModBiomes.init();
		ModArmors.init();
		ModTools.init();
		ModDimension.init();
		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 12);
		GameRegistry.registerWorldGenerator(new WorldStructureGenerator(), 12);
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	/*---------------------------------------------------------------------------*/
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModBlocks.init();
		ModItems.init();
		ModRegistry.register();
		ModEntity.init();
		ModOreDictionary.init();
		ModRecipes.init();
		proxy.bindTileEntitySpecialRenderers();
		proxy.registerRenderInformation();
		proxy.registerItemRenderers();
		proxy.registerRenderers();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
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