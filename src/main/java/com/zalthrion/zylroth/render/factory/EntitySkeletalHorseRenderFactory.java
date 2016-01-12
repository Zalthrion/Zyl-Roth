package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.render.entity.RenderSkeletalHorse;

public class EntitySkeletalHorseRenderFactory implements IRenderFactory<EntitySkeletalHorse> {
	@Override public Render<? super EntitySkeletalHorse> createRenderFor(RenderManager manager) {
		return new RenderSkeletalHorse(manager);
	}
}