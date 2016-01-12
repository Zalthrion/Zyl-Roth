package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.render.entity.RenderVoidLordBoss;

public class EntityVoidLordBossRenderFactory implements IRenderFactory<EntityVoidLordBoss> {
	@Override public Render<? super EntityVoidLordBoss> createRenderFor(RenderManager manager) {
		return new RenderVoidLordBoss(manager);
	}
}