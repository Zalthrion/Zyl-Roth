package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;

public class MountDeathchargerRenderFactory implements IRenderFactory<MountDeathcharger> {
	@Override public Render<? super MountDeathcharger> createRenderFor(RenderManager manager) {
		return new RenderDeathcharger(manager);
	}
}