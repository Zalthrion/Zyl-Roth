package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.reference.Reference;

public class RenderBird extends RenderLiving {
	private static final ResourceLocation birdTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Bird.png");
	
	private int renderedBirdSize;
	
	public RenderBird(ModelBird birdModel, float shadowSize, float shadowSize2) {
		super(new ModelBird(), 0.20F);
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
		GL11.glScalef(0.35F, 0.35F, 0.35F);
	}
	
	protected void func_82445_a(EntityBird par1EntityBird, double par2, double par4, double par6) {
		super.renderLivingAt(par1EntityBird, par2, par4, par6);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.func_82443_a((EntityBird) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	/** Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime */
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.func_82442_a((EntityBird) par1EntityLivingBase, par2);
	}
	
	/** Sets a simple glTranslate on a LivingEntity. */
	@Override
	protected void renderLivingAt(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) {
		this.func_82445_a((EntityBird) par1EntityLivingBase, par2, par4, par6);
	}
	
	public void doRenderLiving(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		this.func_82443_a((EntityBird) par1EntityLivingBase, par2, par4, par6, par8, par9);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getBirdTextures((EntityBird) par1Entity);
	}
	
	/** Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that. */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.func_82443_a((EntityBird) par1Entity, par2, par4, par6, par8, par9);
	}
}
