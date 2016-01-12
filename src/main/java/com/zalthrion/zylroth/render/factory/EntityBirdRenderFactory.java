package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.render.entity.RenderBird;

public class EntityBirdRenderFactory implements IRenderFactory<EntityBird> {
	@Override public Render<? super EntityBird> createRenderFor(RenderManager manager) {
		return new RenderBird(manager);
	}
}