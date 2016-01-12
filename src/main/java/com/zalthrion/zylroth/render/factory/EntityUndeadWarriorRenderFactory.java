package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.render.entity.RenderUndeadWarrior;

public class EntityUndeadWarriorRenderFactory implements IRenderFactory<EntityUndeadWarrior> {
	@Override public Render<? super EntityUndeadWarrior> createRenderFor(RenderManager manager) {
		return new RenderUndeadWarrior(manager);
	}
}