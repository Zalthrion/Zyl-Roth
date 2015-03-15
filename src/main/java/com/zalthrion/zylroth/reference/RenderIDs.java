package com.zalthrion.zylroth.reference;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderIDs {
	public static int blockInfuserRI;
	
	public static void setIDs() {
		blockInfuserRI = RenderingRegistry.getNextAvailableRenderId();
	}
}