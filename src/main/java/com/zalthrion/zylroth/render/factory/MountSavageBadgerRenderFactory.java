package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.mount.MountSavageBadger;
import com.zalthrion.zylroth.render.entity.mount.RenderSavageBadger;

public class MountSavageBadgerRenderFactory implements IRenderFactory<MountSavageBadger> {
	@Override public Render<? super MountSavageBadger> createRenderFor(RenderManager manager) {
		return new RenderSavageBadger(manager);
	}
}