package com.zalthrion.zylroth.render;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

import com.zalthrion.zylroth.utility.LogHelper;

public class ZylrothRenderer {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ZylrothRenderer());
	}
	
	public static void registerItemRender(Item item) {
		LogHelper.warn(item.getRegistryName().toString());
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}