package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityDeer;
import com.zalthrion.zylroth.render.entity.RenderDeer;

public class EntityDeerRenderFactory implements IRenderFactory<EntityDeer> {
	@Override public Render<? super EntityDeer> createRenderFor(RenderManager manager) {
		return new RenderDeer(manager);
	}
}