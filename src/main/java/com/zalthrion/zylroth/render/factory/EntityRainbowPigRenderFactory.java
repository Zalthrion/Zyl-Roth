package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.render.entity.RenderRainbowPig;

public class EntityRainbowPigRenderFactory implements IRenderFactory<EntityRainbowPig> {
	@Override public Render<? super EntityRainbowPig> createRenderFor(RenderManager manager) {
		return new RenderRainbowPig(manager);
	}
}