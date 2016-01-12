package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;

public class MountWarTortoiseRenderFactory implements IRenderFactory<MountWarTortoise> {
	@Override public Render<? super MountWarTortoise> createRenderFor(RenderManager manager) {
		return new RenderWarTortoise(manager);
	}
}