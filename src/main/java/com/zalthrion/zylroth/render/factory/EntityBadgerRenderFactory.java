package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityBadger;
import com.zalthrion.zylroth.render.entity.RenderBadger;

public class EntityBadgerRenderFactory implements IRenderFactory<EntityBadger> {
	@Override public Render<? super EntityBadger> createRenderFor(RenderManager manager) {
		return new RenderBadger(manager);
	}
}