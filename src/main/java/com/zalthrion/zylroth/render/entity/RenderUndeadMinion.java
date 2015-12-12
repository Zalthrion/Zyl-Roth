package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderUndeadMinion extends RenderBiped {
	private static final ResourceLocation undeadminionTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Undead_Unit.png");
	
	/** Scale of the model to use */
	private float scale = 0.8F;
	
	public RenderUndeadMinion(RenderManager renderManager, ModelBiped par1ModelBase, float par2, float par3) {
		super(renderManager, par1ModelBase, par2 * par3);
		this.addLayer(new LayerHeldItem(this));
	}
	
	public void doRenderUndeadMinion(EntityUndeadMinion par1EntityUndeadMinion, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityUndeadMinion, par2, par4, par6, par8, par9);
	}
	
	/** Applies the scale to the transform matrix */
	protected void preRenderScale(EntityUndeadMinion par1EntityUndeadMinion, float par2) {
		GlStateManager.scale(scale, scale, scale);
	}
	
	protected ResourceLocation getUndeadMinionTextures(EntityUndeadMinion par1EntityUndeadMinion) {
		return undeadminionTextures;
	}
	
	/** Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime */
	@Override protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityUndeadMinion) par1EntityLivingBase, par2);
	}
	
	protected void rotateUndeadMinionCorpse(EntityUndeadMinion par1EntityUndeadMinion, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityUndeadMinion, par2, par3, par4);
		
		if ((double) par1EntityUndeadMinion.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityUndeadMinion.limbSwing - par1EntityUndeadMinion.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GlStateManager.rotate(6.5F * f5, 0, 0, 1);
		}
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getUndeadMinionTextures((EntityUndeadMinion) par1Entity);
	}
	
	protected void renderEntityUndeadMinion(EntityUndeadMinion entityundeadminion, float par2) {
		// any other model related renderers can go here.
		// super.func_130005_c(entityundeadminion, par2);
	}
}
