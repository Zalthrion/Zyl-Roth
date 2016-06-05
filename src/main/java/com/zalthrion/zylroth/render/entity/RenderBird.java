package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.lib.ModInit.ResourceLocationInit;
import com.zalthrion.zylroth.model.entity.ModelBird;

public class RenderBird extends RenderLiving<EntityBird> {
	public ModelBase modelBase;
	
	public RenderBird(RenderManager renderManager) {
		super(renderManager, new ModelBird(), 0.5F);
	}
	
	@Override protected void renderLivingAt(EntityBird bird, double par2, double par4, double par6) {
		super.renderLivingAt(bird, par2, par4, par6);
		
		if (bird.isChild()) {
			GlStateManager.scale(0.25F, 0.25F, 0.25F);
		} else {
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityBird par1Entity) {
		return ResourceLocationInit.ENTITY_BIRD;
	}
	
	public static class Factory implements IRenderFactory<EntityBird> {
		@Override public Render<? super EntityBird> createRenderFor(RenderManager manager) {
			return new RenderBird(manager);
		}
	}
}