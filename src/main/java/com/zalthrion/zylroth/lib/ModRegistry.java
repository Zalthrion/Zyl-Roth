package com.zalthrion.zylroth.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.utility.LogHelper;

public class ModRegistry {
	static HashMap<String, RegisterInfo> registerMap = new HashMap<String, RegisterInfo>();
	static ArrayList<RegisterInfo> sortedRegisterMap = new ArrayList<RegisterInfo>();
	
	protected static class RegisterInfo {
		private Block block;
		private Class<? extends ItemBlock> itemBlock;
		private Item item;
		private String key;
		private boolean isBlock = false;
		private boolean isItem = false;
		private boolean hasItemBlock = false;
		
		public RegisterInfo(Block block, String key) {
			this.block = block;
			this.key = key;
			this.isBlock = true;
		}
		
		public RegisterInfo(Block block, Class<? extends ItemBlock> itemBlock, String key) {
			this.block = block;
			this.itemBlock = itemBlock;
			this.key = key;
			this.isBlock = true;
			this.hasItemBlock = true;
		}
		
		public RegisterInfo(Item item, String key) {
			this.item = item;
			this.key = key;
			this.isItem = true;
		}
		
		public Block getBlock() { return this.block; }
		public Class<? extends ItemBlock> getItemBlock() { return this.itemBlock; }
		public Item getItem() { return this.item; }
		public String getKey() { return this.key; }
		public boolean isBlock() { return this.isBlock; }
		public boolean isItem() { return this.isItem; }
		public boolean hasItemBlock() { return this.hasItemBlock; }
	}
	
	public static void addRegister(Block block, String registryName) {
		if (registerMap.containsKey(registryName)) LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
		registerMap.put(registryName, new RegisterInfo(block, registryName));
	}
	
	public static void addRegister(Block block, Class<? extends ItemBlock> itemBlock, String registryName) {
		if (registerMap.containsKey(registryName)) LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
		registerMap.put(registryName, new RegisterInfo(block, itemBlock, registryName));
	}
	
	public static void addRegister(Item item, String registryName) {
		if (registerMap.containsKey(registryName)) LogHelper.warn("Developer Error: Object already called " + registryName + " NOT REGISTERING.");
		registerMap.put(registryName, new RegisterInfo(item, registryName));
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
			if (info.isItem()) {
				GameRegistry.registerItem(info.getItem(), info.getKey());
			}
			if (info.isBlock()) {
				if (info.hasItemBlock()) {
					GameRegistry.registerBlock(info.getBlock(), info.getItemBlock(), info.getKey());
				} else {
					GameRegistry.registerBlock(info.getBlock(), info.getKey());
				}
			}
		}
	}
}