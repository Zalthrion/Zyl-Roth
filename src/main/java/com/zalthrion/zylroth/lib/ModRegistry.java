package com.zalthrion.zylroth.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;

import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.utility.LogHelper;

public class ModRegistry {
	static HashMap<String, RegisterInfo> registerMap = new HashMap<String, RegisterInfo>();
	static ArrayList<RegisterInfo> sortedRegisterMap = new ArrayList<RegisterInfo>();
	
	protected static class RegisterInfo {
		private IForgeRegistryEntry<?> object;
		private String key;
		
		public RegisterInfo(IForgeRegistryEntry<?> object, String key) {
			this.object = object;
			this.key = key;
		}
		
		public IForgeRegistryEntry<?> getObject() { return this.object; }
		public String getKey() { return this.key; }
	}
	
	public static void addRegister(IForgeRegistryEntry<?> object, String registryName) {
		if (registerMap.containsKey(registryName)) LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
		registerMap.put(registryName, new RegisterInfo(object, registryName.replace("BlockIB", "Block")));
	}
	
	public static void sortThenRegister(String[] sortOrder) {
		for (int i = 0; i < sortOrder.length; i ++) {
			if (registerMap.containsKey(sortOrder[i])) {
				sortedRegisterMap.add(registerMap.get(sortOrder[i]));
			}
		}
		register();
	}
	
	private static void register() {
		Iterator<RegisterInfo> iterator = sortedRegisterMap.iterator();
		while (iterator.hasNext()) {
			RegisterInfo info = iterator.next();
			if (info == null) continue;
			if (info.getObject().getRegistryName() == null) info.getObject().setRegistryName(new ResourceLocation(Reference.MOD_ID.toLowerCase(), info.getKey()));
			GameRegistry.register(info.getObject());
		}
	}
}