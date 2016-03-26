package com.zalthrion.zylroth.lib;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.world.dimension.WorldProviderKyrul;

public class ModDimension {
	public static DimensionType KYRUL;
	public static DimensionType IRIDIS;
	public static DimensionType GLACIEM;
	
	public static void init() {
		registerDimension();
	}
	
	public static void registerDimension() {
		KYRUL = DimensionType.register("Kyrul", "_kyrul", ConfigurationHandler.getKyrulId(), WorldProviderKyrul.class, false);
		IRIDIS = DimensionType.register("Iridis", "_iridis", ConfigurationHandler.getKyrulId(), WorldProviderKyrul.class, false);
		GLACIEM = DimensionType.register("Glaciem", "_glaciem", ConfigurationHandler.getKyrulId(), WorldProviderKyrul.class, false);
		if (ConfigurationHandler.getKyrulEnabled()) {
			int dimensionId_Kyrul = ConfigurationHandler.getKyrulId();
			DimensionManager.registerDimension(dimensionId_Kyrul, KYRUL);
		}
		
		if (ConfigurationHandler.getIridisEnabled()) {
			int dimensionId_Iridis = ConfigurationHandler.getIridisId();
			DimensionManager.registerDimension(dimensionId_Iridis, IRIDIS);
		}
		
		if (ConfigurationHandler.getGlaciemEnabled()) {
			int dimensionId_Glaciem = ConfigurationHandler.getGlaciemId();
			DimensionManager.registerDimension(dimensionId_Glaciem, GLACIEM);
		}
	}
}