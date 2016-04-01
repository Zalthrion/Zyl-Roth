package com.zalthrion.zylroth.reference;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderIDs {
	public static int blockInfuserRI;
	public static int goldBag;
	
	public static void setIDs() {
		blockInfuserRI = RenderingRegistry.getNextAvailableRenderId();
		goldBag = RenderingRegistry.getNextAvailableRenderId();
	}
}