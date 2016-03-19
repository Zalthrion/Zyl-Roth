package com.zalthrion.zylroth;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
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
import com.zalthrion.zylroth.lib.ModArmors;
import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModEntity;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModOreDictionary;
import com.zalthrion.zylroth.lib.ModRecipes;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.packet.PacketHandler;
import com.zalthrion.zylroth.proxy.ServerProxy;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.world.WorldOreGenerator;
import com.zalthrion.zylroth.world.WorldStructureGenerator;
import com.zalthrion.zylroth.world.dimension.WorldProviderGlaciem;
import com.zalthrion.zylroth.world.dimension.WorldProviderIridis;
import com.zalthrion.zylroth.world.dimension.WorldProviderKyrul;

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
	
	public static final DimensionType GLACIEM = EnumHelper.addEnum(DimensionType.class, "GLACIEM", ConfigurationHandler.getGlaciemId(), "Glaciem", "_glaciem", WorldProviderGlaciem.class);
	public static final DimensionType IRIDIS = EnumHelper.addEnum(DimensionType.class, "IRIDIS", ConfigurationHandler.getIridisId(), "Iridis", "_iridis", WorldProviderIridis.class);
	public static final DimensionType KYRUL = EnumHelper.addEnum(DimensionType.class, "KYRUL", ConfigurationHandler.getKyrulId(), "Kyrul", "_kyrul", WorldProviderKyrul.class);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
		PacketHandler.init();
		KeyHandler.init();
		
		ModArmors.init();
		ModBlocks.init();
		ModBiomes.init();
		// ModDimension.init();
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