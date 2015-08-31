package com.zalthrion.zylroth.handler;

import java.io.File;

import com.zalthrion.zylroth.reference.Reference;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	
	private static boolean enableHardcoreMode = false;
	private static boolean enableKyrul = true;
	private static boolean enableIridis = true;
	private static boolean enableGlaciem = true;
	
	public static void init(File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}
	
	private static void loadConfiguration() {
		
		enableHardcoreMode = configuration.getBoolean("Hardcore Mode", Configuration.CATEGORY_GENERAL, false, "Enable/Disable the Hardcore Mode");
		
		enableKyrul = configuration.getBoolean("Enable Ky'rul", "Dimensions", true, "Enable/Disable the Ky'rul Dimension");
		
		enableIridis = configuration.getBoolean("Enable Iri'dis", "Dimensions", true, "Enable/Disable the Iri'dis Dimension");
		
		enableGlaciem = configuration.getBoolean("Enable Glaciem", "Dimensions", true, "Enable/Disable the Glaciem Dimension");
		
		if (configuration.hasChanged()) {
			configuration.save();
		}
	}
	
	public static boolean getHardcoreModeEnabled() {
		return enableHardcoreMode;
	}
	
	public static boolean getKyrulEnabled() {
		return enableKyrul;
	}
	
	public static boolean getIridisEnabled() {
		return enableIridis;
	}
	
	public static boolean getGlaciemEnabled() {
		return enableGlaciem;
	}
	
}