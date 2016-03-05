package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.dev.EntitySixOneThree;
import com.zalthrion.zylroth.render.entity.dev.RenderSixOneThree;

public class EntitySixOneThreeRenderFactory implements IRenderFactory<EntitySixOneThree> {
	@Override public Render<? super EntitySixOneThree> createRenderFor(RenderManager manager) {
		return new RenderSixOneThree(manager);
	}
}