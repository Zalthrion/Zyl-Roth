package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityUnicorn;
import com.zalthrion.zylroth.render.entity.RenderUnicorn;

public class EntityUnicornRenderFactory implements IRenderFactory<EntityUnicorn> {
	@Override public Render<? super EntityUnicorn> createRenderFor(RenderManager manager) {
		return new RenderUnicorn(manager);
	}
}