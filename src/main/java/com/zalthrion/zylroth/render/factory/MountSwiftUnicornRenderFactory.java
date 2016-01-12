package com.zalthrion.zylroth.render.factory;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.render.entity.mount.RenderSwiftUnicorn;

public class MountSwiftUnicornRenderFactory implements IRenderFactory<MountSwiftUnicorn> {
	@Override public Render<? super MountSwiftUnicorn> createRenderFor(RenderManager manager) {
		return new RenderSwiftUnicorn(manager);
	}
}