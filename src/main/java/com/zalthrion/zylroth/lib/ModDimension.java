package com.zalthrion.zylroth.lib;

import net.minecraftforge.common.DimensionManager;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.WorldProviderGlaciem;
import com.zalthrion.zylroth.world.dimension.WorldProviderIridis;
import com.zalthrion.zylroth.world.dimension.WorldProviderKyrul;

public class ModDimension {
	
	public static final int dimensionId_Kyrul = 47;
	public static final int dimensionId_Iridis = 48;
	public static final int dimensionId_Glaciem = 49;
	
	public static void init() {
		registerDimension();
	}
	
	public static void registerDimension() {
		DimensionManager.registerProviderType(dimensionId_Kyrul, WorldProviderKyrul.class, false);
		if (ConfigurationHandler.getKyrulEnabled()) DimensionManager.registerDimension(dimensionId_Kyrul, dimensionId_Kyrul);
		
		DimensionManager.registerProviderType(dimensionId_Iridis, WorldProviderIridis.class, false);
		if (ConfigurationHandler.getIridisEnabled()) DimensionManager.registerDimension(dimensionId_Iridis, dimensionId_Iridis);
		
		DimensionManager.registerProviderType(dimensionId_Glaciem, WorldProviderGlaciem.class, false);
		if (ConfigurationHandler.getGlaciemEnabled()) DimensionManager.registerDimension(dimensionId_Glaciem, dimensionId_Glaciem);
	}
}