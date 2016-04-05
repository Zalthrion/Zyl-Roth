package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.reference.Reference;

public class RenderBird extends RenderLiving<EntityBird> {
	private static final ResourceLocation birdTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Bird.png");
	
	private int renderedBirdSize;
	
	public RenderBird(RenderManager renderManager) {
		super(renderManager, new ModelBird(), 0.5F);
		this.renderedBirdSize = ((ModelBird) this.mainModel).getBirdSize();
	}
	
	@Override protected void preRenderCallback(EntityBird par1EntityLivingBase, float par2) {
		GlStateManager.scale(0.35F, 0.35F, 0.35F);
	}
	
	@Override protected void renderLivingAt(EntityBird par1EntityBird, double par2, double par4, double par6) {
		super.renderLivingAt(par1EntityBird, par2, par4, par6);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityBird par1Entity) {
		return birdTexture;
	}
	
	@Override public void doRender(EntityBird par1EntityBird, double par2, double par4, double par6, float par8, float par9) {
		int i = ((ModelBird) this.mainModel).getBirdSize();
		
		if (i != this.renderedBirdSize) {
			this.renderedBirdSize = i;
			this.mainModel = new ModelBird();
		}
		
		super.doRender(par1EntityBird, par2, par4, par6, par8, par9);
	}
	
	public static class Factory implements IRenderFactory<EntityBird> {
		@Override public Render<? super EntityBird> createRenderFor(RenderManager manager) {
			return new RenderBird(manager);
		}
	}
}