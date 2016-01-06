package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.boss.EntityVoidLordBoss;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVoidLordBoss extends RenderBiped {
	private static final ResourceLocation pyroknightTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Pyro_Knight.png");
	
	/** Scale of the model to use */
	private float scale = 1.1F;
	
	public RenderVoidLordBoss(ModelBiped par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
	}
	
	public void doRenderPyroKnight(EntityVoidLordBoss par1EntityPyroKnight, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityPyroKnight, par2, par4, par6, par8, par9);
	}
	
	/** Applies the scale to the transform matrix */
	protected void preRenderScale(EntityVoidLordBoss par1EntityPyroKnight, float par2) {
		GL11.glScalef(scale, scale, scale);
	}
	
	protected ResourceLocation getPyroKnightTextures(EntityVoidLordBoss par1EntityPyroKnight) {
		return pyroknightTextures;
	}
	
	/** Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime */
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityVoidLordBoss) par1EntityLivingBase, par2);
	}
	
	protected void rotatePyroKnightCorpse(EntityVoidLordBoss par1EntityPyroKnight, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityPyroKnight, par2, par3, par4);
		
		if ((double) par1EntityPyroKnight.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityPyroKnight.limbSwing - par1EntityPyroKnight.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getPyroKnightTextures((EntityVoidLordBoss) par1Entity);
	}
}
