package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityFancyBadger;
import com.zalthrion.zylroth.render.entity.RenderFancyBadger;

public class EntityFancyBadgerRenderFactory implements IRenderFactory<EntityFancyBadger> {
	@Override public Render<? super EntityFancyBadger> createRenderFor(RenderManager manager) {
		return new RenderFancyBadger(manager);
	}
}