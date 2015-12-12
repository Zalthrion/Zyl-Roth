package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityPyroKnight;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderPyroKnight extends RenderBiped<EntityPyroKnight> {
	private static final ResourceLocation pyroknightTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Pyro_Knight.png");
	
	/** Scale of the model to use */
	private float scale = 1.1F;
	
	public RenderPyroKnight(RenderManager renderManager, ModelBiped par1ModelBase, float par2, float par3) {
		super(renderManager, par1ModelBase, par2 * par3);
		this.addLayer(new LayerHeldItem(this));
	}
	
	public void doRenderPyroKnight(EntityPyroKnight par1EntityPyroKnight, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityPyroKnight, par2, par4, par6, par8, par9);
	}
	
	/** Applies the scale to the transform matrix */
	@Override protected void preRenderCallback(EntityPyroKnight par1EntityPyroKnight, float par2) {
		GlStateManager.scale(scale, scale, scale);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityPyroKnight par1EntityPyroKnight) {
		return pyroknightTextures;
	}
	
	protected void rotatePyroKnightCorpse(EntityPyroKnight par1EntityPyroKnight, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityPyroKnight, par2, par3, par4);
		
		if ((double) par1EntityPyroKnight.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityPyroKnight.limbSwing - par1EntityPyroKnight.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GlStateManager.rotate(6.5F * f5, 0, 0, 1);
		}
	}
	
	protected void renderEntityPyroKnight(EntityPyroKnight entitypyroknight, float par2) {
		// any other model related renderers can go here.
		// super.func_130005_c(entitypyroknight, par2);
	}
}
