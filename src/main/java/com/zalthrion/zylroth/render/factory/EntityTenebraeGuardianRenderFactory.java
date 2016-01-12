package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.render.entity.RenderTenebraeGuardian;

public class EntityTenebraeGuardianRenderFactory implements IRenderFactory<EntityTenebraeGuardian> {
	@Override public Render<? super EntityTenebraeGuardian> createRenderFor(RenderManager manager) {
		return new RenderTenebraeGuardian(manager);
	}
}