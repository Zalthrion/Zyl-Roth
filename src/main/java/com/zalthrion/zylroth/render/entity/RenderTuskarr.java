package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityTuskarr;
import com.zalthrion.zylroth.lib.ModInit.ResourceLocationInit;
import com.zalthrion.zylroth.model.entity.ModelTuskarr;

@SideOnly(Side.CLIENT) public class RenderTuskarr extends RenderLiving<EntityTuskarr> {
	public RenderTuskarr(RenderManager renderManager) {
		super(renderManager, new ModelTuskarr(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityTuskarr stag) {
		return ResourceLocationInit.ENTITY_TUSKARR;
	}
	
	@Override protected void renderLivingAt(EntityTuskarr tuskarr, double x, double y, double z) {
		super.renderLivingAt(tuskarr, x, y, z);
		if (tuskarr.isChild()) {
			GlStateManager.scale(0.45F, 0.45F, 0.45F);
		} else {
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityTuskarr> {
		@Override public Render<? super EntityTuskarr> createRenderFor(RenderManager manager) {
			return new RenderTuskarr(manager);
		}
	}
}