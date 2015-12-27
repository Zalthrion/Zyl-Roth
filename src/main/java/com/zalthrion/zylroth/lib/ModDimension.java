package com.zalthrion.zylroth.lib;

import net.minecraftforge.common.DimensionManager;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.WorldProviderGlaciem;
import com.zalthrion.zylroth.world.dimension.WorldProviderIridis;
import com.zalthrion.zylroth.world.dimension.WorldProviderKyrul;

public class ModDimension {
	public static void init() {
		registerDimension();
	}
	
	public static void registerDimension() {
		if (ConfigurationHandler.getKyrulEnabled()) {
			int dimensionId_Kyrul = ConfigurationHandler.getKyrulId();
			DimensionManager.registerProviderType(dimensionId_Kyrul, WorldProviderKyrul.class, false);
			DimensionManager.registerDimension(dimensionId_Kyrul, dimensionId_Kyrul);
		}
		
		if (ConfigurationHandler.getIridisEnabled()) {
			int dimensionId_Iridis = ConfigurationHandler.getIridisId();
			DimensionManager.registerProviderType(dimensionId_Iridis, WorldProviderIridis.class, false);
			DimensionManager.registerDimension(dimensionId_Iridis, dimensionId_Iridis);
		}
		
		if (ConfigurationHandler.getGlaciemEnabled()) {
			int dimensionId_Glaciem = ConfigurationHandler.getGlaciemId();
			DimensionManager.registerProviderType(dimensionId_Glaciem, WorldProviderGlaciem.class, false);
			DimensionManager.registerDimension(dimensionId_Glaciem, dimensionId_Glaciem);
		}
	}
}