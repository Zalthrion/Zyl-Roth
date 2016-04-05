package com.zalthrion.zylroth.handler;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

public class KeyHandler {
	@SideOnly(Side.CLIENT) public static KeyBinding openSummonGui = new KeyBinding("key.zylroth:summongui", Keyboard.KEY_Z, "key.categories.zylroth");
	
	public static void preInit() {
		ClientRegistry.registerKeyBinding(openSummonGui);
	}
}