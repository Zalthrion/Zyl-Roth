package com.zalthrion.zylroth.lib;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRegistry {
	static HashMap<Integer, RegisterInfo> registerMap = new HashMap<Integer, RegisterInfo>();
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
	
	public static void addRegister(Integer pos, Block block, String key) {
		registerMap.put(pos, new RegisterInfo(block, key));
	}
	
	public static void addRegister(Integer pos, Block block, Class<? extends ItemBlock> itemBlock, String key) {
		registerMap.put(pos, new RegisterInfo(block, itemBlock, key));
	}
	
	public static void addRegister(Integer pos, Item item, String key) {
		registerMap.put(pos, new RegisterInfo(item, key));
	}
	
	public static void register() {
		for (int pos = 0; pos <= registerMap.size(); pos ++) {
			RegisterInfo info = registerMap.get(pos);
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