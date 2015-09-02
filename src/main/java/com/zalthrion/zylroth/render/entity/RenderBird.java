package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.reference.Reference;

public class RenderBird extends RenderLiving {
	private static final ResourceLocation birdTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Bird.png");
	
	private int renderedBirdSize;
	
	public RenderBird(RenderManager renderManager, ModelBird birdModel, float shadowSize) {
		super(renderManager, new ModelBird(), shadowSize);
		this.renderedBirdSize = ((ModelBird) this.mainModel).getBirdSize();
	}
	
	public void func_82443_a(EntityBird par1EntityBird, double par2, double par4, double par6, float par8, float par9) {
		int i = ((ModelBird) this.mainModel).getBirdSize();
		
		if (i != this.renderedBirdSize) {
			this.renderedBirdSize = i;
			this.mainModel = new ModelBird();
		}
		
		super.doRender(par1EntityBird, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getBirdTextures(EntityBird par1EntityBird) {
		return birdTextures;
	}
	
	protected void func_82442_a(EntityBird par1EntityBird, float par2) {
		GlStateManager.scale(0.35F, 0.35F, 0.35F);
	}
	
	protected void func_82445_a(EntityBird par1EntityBird, double par2, double par4, double par6) {
		super.renderLivingAt(par1EntityBird, par2, par4, par6);
	}
	
	@Override protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.func_82442_a((EntityBird) par1EntityLivingBase, par2);
	}
	
	@Override protected void renderLivingAt(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {
		this.func_82445_a((EntityBird) par1EntityLivingBase, par2, par4, par6);
	}
	
	@Override protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getBirdTextures((EntityBird) par1Entity);
	}
	
	@Override public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.func_82443_a((EntityBird) par1Entity, par2, par4, par6, par8, par9);
	}
}
