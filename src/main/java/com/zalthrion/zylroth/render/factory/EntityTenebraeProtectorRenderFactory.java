package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.render.entity.RenderTenebraeProtector;

public class EntityTenebraeProtectorRenderFactory implements IRenderFactory<EntityTenebraeProtector> {
	@Override public Render<? super EntityTenebraeProtector> createRenderFor(RenderManager manager) {
		return new RenderTenebraeProtector(manager);
	}
}