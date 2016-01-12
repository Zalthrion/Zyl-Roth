package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.render.entity.RenderVoidDragon;

public class EntityVoidDragonRenderFactory implements IRenderFactory<EntityVoidDragon> {
	@Override public Render<? super EntityVoidDragon> createRenderFor(RenderManager manager) {
		return new RenderVoidDragon(manager);
	}
}