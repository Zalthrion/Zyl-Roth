package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.world.dimension.*;

import net.minecraftforge.common.DimensionManager;

public class ModDimension {
	
	public static final int dimensionId_Kyrul = 47;
	
	public static final int dimensionId_Iridis = 48;
	
	public static void init(){
		registerDimension();
	}
	
	public static void registerDimension(){
		
		DimensionManager.registerProviderType(dimensionId_Kyrul, WorldProviderKyrul.class, false);
		DimensionManager.registerDimension(dimensionId_Kyrul, dimensionId_Kyrul);
		
		DimensionManager.registerProviderType(dimensionId_Iridis, WorldProviderIridis.class, false);
		DimensionManager.registerDimension(dimensionId_Iridis, dimensionId_Iridis);
	}
	
}
