package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityStag;
import com.zalthrion.zylroth.render.entity.RenderStag;

public class EntityStagRenderFactory implements IRenderFactory<EntityStag> {
	@Override public Render<? super EntityStag> createRenderFor(RenderManager manager) {
		return new RenderStag(manager);
	}
}