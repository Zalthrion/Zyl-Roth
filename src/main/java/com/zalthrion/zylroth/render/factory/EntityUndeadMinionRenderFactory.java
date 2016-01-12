package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.render.entity.RenderUndeadMinion;

public class EntityUndeadMinionRenderFactory implements IRenderFactory<EntityUndeadMinion> {
	@Override public Render<? super EntityUndeadMinion> createRenderFor(RenderManager manager) {
		return new RenderUndeadMinion(manager);
	}
}