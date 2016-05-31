package com.zalthrion.zylroth.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
		private ItemBlock itemBlock;
		private String key;
		
		public RegisterInfo(IForgeRegistryEntry<?> object, String key) {
			this(object, null, key);
		}
		
		public RegisterInfo(IForgeRegistryEntry<?> object, ItemBlock itemBlock, String key) {
			this.object = object;
			this.itemBlock = itemBlock;
			this.key = key;
		}
		
		public IForgeRegistryEntry<?> getObject() { return this.object; }
		public ItemBlock getItemBlock() { return this.itemBlock; }
		public String getKey() { return this.key; }
		public boolean hasItemBlock() { return this.itemBlock != null; }
	}
	
	public static void addRegister(Item item, String registryName) {
		if (registerMap.containsKey(registryName)) {
			LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
			return;
		}
		registerMap.put(registryName, new RegisterInfo(item, registryName));
	}
	
	public static void addRegister(Block block, String registryName) {
		if (registerMap.containsKey(registryName)) {
			LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
			return;
		}
		registerMap.put(registryName, new RegisterInfo(block, new ItemBlock(block), registryName));
	}
	
	public static void addRegister(Block block, ItemBlock itemBlock, String registryName) {
		if (registerMap.containsKey(registryName)) {
			LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
			return;
		}
		registerMap.put(registryName, new RegisterInfo(block, itemBlock, registryName));
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
			if (info.hasItemBlock()) {
				if (info.getItemBlock().getRegistryName() == null) info.getItemBlock().setRegistryName(new ResourceLocation(Reference.MOD_ID.toLowerCase(), info.getKey()));
				GameRegistry.register(info.getItemBlock());
			}
		}
	}
	
	public static ResourceLocation createRegistryNameFor(String name) {
		return new ResourceLocation(Reference.MOD_ID.toLowerCase(), name);
	}
}