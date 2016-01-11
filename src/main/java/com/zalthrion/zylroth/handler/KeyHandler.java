package com.zalthrion.zylroth.handler;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KeyHandler {
	@SideOnly(Side.CLIENT) public static KeyBinding openSummonGui;
	
	public static void init() {
		openSummonGui = new KeyBinding("key.zylroth:summongui", Keyboard.KEY_Z, "key.categories.zylroth");
		ClientRegistry.registerKeyBinding(openSummonGui);
	}
}