package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.dev.EntityZalthrion;
import com.zalthrion.zylroth.render.entity.dev.RenderZalthrion;

public class EntityZalthrionRenderFactory implements IRenderFactory<EntityZalthrion> {
	@Override public Render<? super EntityZalthrion> createRenderFor(RenderManager manager) {
		return new RenderZalthrion(manager);
	}
}