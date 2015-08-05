package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEmpoweredTenebraeGolem extends RenderLiving {
	
	private static final ResourceLocation ETgolemTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Empowered_Tenebrae_Golem.png");
	
	/** Empowered Tenebrae Golem's Model. */
	@SuppressWarnings("unused")
	private final ModelEmpoweredTenebraeGolem empowered_tenebrae_golemModel;
	
	public RenderEmpoweredTenebraeGolem(ModelEmpoweredTenebraeGolem modelEmpoweredTenebraeGolem, float shadowSize) {
		super(new ModelEmpoweredTenebraeGolem(), 0.5F);
		this.empowered_tenebrae_golemModel = (ModelEmpoweredTenebraeGolem) this.mainModel;
	}
	
	/** Renders the Empowered Tenebrae Golem. */
	public void doRenderEmpoweredTenebraeGolem(EntityEmpoweredTenebraeGolem par1EntityEmpoweredTenebraeGolem, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityEmpoweredTenebraeGolem, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEmpoweredTenebraeGolemTextures(EntityEmpoweredTenebraeGolem par1EntityEmpoweredTenebraeGolem) {
		return ETgolemTextures;
	}
	
	/** Rotates Empowered Tenebrae Golem corpse. */
	protected void rotateEmpoweredTenebraeGolemCorpse(EntityEmpoweredTenebraeGolem par1EntityEmpoweredTenebraeGolem, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityEmpoweredTenebraeGolem, par2, par3, par4);
		
		if ((double) par1EntityEmpoweredTenebraeGolem.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityEmpoweredTenebraeGolem.limbSwing - par1EntityEmpoweredTenebraeGolem.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}
	
	/** Renders Equipped items. */
	protected void renderEmpoweredTenebraeGolemEquippedItems(EntityEmpoweredTenebraeGolem par1EntityEmpoweredTenebraeGolem, float par2) {
		super.renderEquippedItems(par1EntityEmpoweredTenebraeGolem, par2);
		
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderEmpoweredTenebraeGolem((EntityEmpoweredTenebraeGolem) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2) {
		this.renderEmpoweredTenebraeGolemEquippedItems((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2);
	}
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.rotateEmpoweredTenebraeGolemCorpse((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2, par3, par4);
	}
	
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderEmpoweredTenebraeGolem((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2, par4, par6, par8, par9);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getEmpoweredTenebraeGolemTextures((EntityEmpoweredTenebraeGolem) par1Entity);
	}
	
	/** Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that. */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderEmpoweredTenebraeGolem((EntityEmpoweredTenebraeGolem) par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected void renderLivingAt(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
		GL11.glScalef(0.55F, 0.55F, 0.55F);
		
		// The lols are real.
//		GL11.glScalef(p_77039_1_.worldObj.rand.nextFloat(), p_77039_1_.worldObj.rand.nextFloat(), p_77039_1_.worldObj.rand.nextFloat());
	}	
}
