package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.model.entity.ModelUndead;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderVoidLordBoss extends RenderBiped<EntityVoidLordBoss> {
	private static final ResourceLocation pyroknightTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Pyro_Knight.png");
	
	/** Scale of the model to use */
	private float scale = 1.1F;
	
	public RenderVoidLordBoss(RenderManager renderManager) {
		super(renderManager, new ModelUndead(), 0.25F);
		this.addLayer(new LayerHeldItem(this));
	}
	
	/** Applies the scale to the transform matrix */
	@Override protected void preRenderCallback(EntityVoidLordBoss par1EntityPyroKnight, float par2) {
		GlStateManager.scale(scale, scale, scale);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityVoidLordBoss par1EntityPyroKnight) {
		return pyroknightTextures;
	}
	
	@Override protected void rotateCorpse(EntityVoidLordBoss par1EntityPyroKnight, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityPyroKnight, par2, par3, par4);
		
		if ((double) par1EntityPyroKnight.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityPyroKnight.limbSwing - par1EntityPyroKnight.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GlStateManager.rotate(6.5F * f5, 0, 0, 1);
		}
	}
	
	protected void renderEntityPyroKnight(EntityVoidLordBoss entitypyroknight, float par2) {
		// any other model related renderers can go here.
		// super.func_130005_c(entitypyroknight, par2);
	}
	
	public static class Factory implements IRenderFactory<EntityVoidLordBoss> {
		@Override public Render<? super EntityVoidLordBoss> createRenderFor(RenderManager manager) {
			return new RenderVoidLordBoss(manager);
		}
	}
}
