package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;

public class MountPlaguedHorseRenderFactory implements IRenderFactory<MountPlaguedHorse> {
	@Override public Render<? super MountPlaguedHorse> createRenderFor(RenderManager manager) {
		return new RenderPlaguedHorse(manager);
	}
}