package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityTuskarr;
import com.zalthrion.zylroth.model.entity.ModelTuskarr;
import com.zalthrion.zylroth.reference.Reference;

public class RenderTuskarr extends RenderLiving<EntityTuskarr> {
	private static final ResourceLocation tuskarrTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Tuskarr.png");
	public ModelBase modelBase;
	
	public RenderTuskarr(RenderManager renderManager) {
		super(renderManager, new ModelTuskarr(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityTuskarr stag) {
		return tuskarrTexture;
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