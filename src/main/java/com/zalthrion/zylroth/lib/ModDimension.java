package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.*;

import net.minecraftforge.common.DimensionManager;

public class ModDimension {
	
	public static final int dimensionId_Kyrul = 47;
	
	public static final int dimensionId_Iridis = 48;
	
	public static final int dimensionId_Glaciem = 49;
	
	public static void init() {
		registerDimension();
	}
	
	public static void registerDimension() {
		
		// Kyrul
		
		DimensionManager.registerProviderType(dimensionId_Kyrul, WorldProviderKyrul.class, false);
		
		if (ConfigurationHandler.getKyrulEnabled() == true)
			DimensionManager.registerDimension(dimensionId_Kyrul, dimensionId_Kyrul);
		
		// Iridis
		
		DimensionManager.registerProviderType(dimensionId_Iridis, WorldProviderIridis.class, false);
		
		if (ConfigurationHandler.getIridisEnabled() == true)
			DimensionManager.registerDimension(dimensionId_Iridis, dimensionId_Iridis);
		
		// Glaciem
		
		DimensionManager.registerProviderType(dimensionId_Glaciem, WorldProviderGlaciem.class, false);
		
		if (ConfigurationHandler.getGlaciemEnabled() == true)
			DimensionManager.registerDimension(dimensionId_Glaciem, dimensionId_Glaciem);
		
	}
	
}
