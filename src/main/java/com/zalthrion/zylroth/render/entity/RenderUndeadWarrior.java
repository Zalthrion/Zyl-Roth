package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityUndeadWarrior;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class RenderUndeadWarrior extends RenderBiped {
	private static final ResourceLocation undeadwarriorTextures = new ResourceLocation("projectexanimus", "textures/entities/undead_unit.png");
	
	/** Scale of the model to use */
	private float scale;
	
	public RenderUndeadWarrior(ModelBiped par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
		this.scale = 0.8F;
	}
	
	public void doRenderUndeadWarrior(EntityUndeadWarrior par1EntityUndeadWarrior, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityUndeadWarrior, par2, par4, par6, par8, par9);
	}
	
	/** Applies the scale to the transform matrix */
	protected void preRenderScale(EntityUndeadWarrior par1EntityUndeadWarrior, float par2) {
		GL11.glScalef(this.scale = 0.8F, this.scale = 0.8F, this.scale = 0.8F);
	}
	
	protected ResourceLocation getUndeadWarriorTextures(EntityUndeadWarrior par1EntityUndeadWarrior) {
		return undeadwarriorTextures;
	}
	
	/** Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime */
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.preRenderScale((EntityUndeadWarrior) par1EntityLivingBase, par2);
	}
	
	protected void rotateUndeadWarriorCorpse(EntityUndeadWarrior par1EntityUndeadWarrior, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityUndeadWarrior, par2, par3, par4);
		
		if ((double) par1EntityUndeadWarrior.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityUndeadWarrior.limbSwing - par1EntityUndeadWarrior.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getUndeadWarriorTextures((EntityUndeadWarrior) par1Entity);
	}
	
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2) {
		this.renderEntityUndeadWarrior((EntityUndeadWarrior) par1EntityLivingBase, par2);
	}
	
	protected void renderEntityUndeadWarrior(EntityUndeadWarrior entityundeadwarrior, float par2) {
		// any other model related renderers can go here.
		// super.func_130005_c(entityundeadwarrior, par2);
		super.renderEquippedItems(entityundeadwarrior, par2);
	}
}
