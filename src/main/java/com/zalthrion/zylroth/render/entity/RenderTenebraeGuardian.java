package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.model.entity.ModelEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTenebraeGuardian extends RenderLiving {
	
	//	private static final ResourceLocation Explosion = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/EmpoweredTenebraeGolem_exploding.png");
	
	private static final ResourceLocation ETgolemTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Empowered_Tenebrae_Golem.png");
	
	/** Empowered Tenebrae Golem's Model. */
	@SuppressWarnings("unused")
	private final ModelEmpoweredTenebraeGolem empowered_tenebrae_golemModel;
	
	public RenderTenebraeGuardian(ModelEmpoweredTenebraeGolem modelEmpoweredTenebraeGolem, float shadowSize) {
		super(new ModelEmpoweredTenebraeGolem(), 0.5F);
		this.empowered_tenebrae_golemModel = (ModelEmpoweredTenebraeGolem) this.mainModel;
	}
	
	/** Rotates Empowered Tenebrae Golem corpse. */
	protected void rotateEmpoweredTenebraeGolemCorpse(EntityTenebraeGuardian golem, float par2, float par3, float par4) {
		super.rotateCorpse(golem, par2, par3, par4);
		
		if ((double) golem.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = golem.limbSwing - golem.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
		
		if (golem.deathTime > 0) {
			float f5 = (golem.deathTime + par4 - 1.0F) / 20.0F * 1.6F;
			f5 = MathHelper.sqrt_float(f5);
			
			if (f5 > 1.0F)
				f5 = 1.0F;
			
			GL11.glRotatef(f5 * getDeathMaxRotation(golem), 0.0F, 0.0F, 1.0F);
		}
	}
	
	/* protected void
	 * renderEmpoweredTenebraeGolemModel(EntityEmpoweredTenebraeGolem golem,
	 * float par2, float par3, float par4, float par5, float par6, float par7) {
	 * if (golem.deathTicks > 0) { float f6 = golem.deathTicks / 200.0F;
	 * GL11.glDepthFunc(GL11.GL_LEQUAL); GL11.glEnable(GL11.GL_ALPHA_TEST);
	 * GL11.glAlphaFunc(GL11.GL_GREATER, f6); bindTexture(Explosion);
	 * mainModel.render(golem, par2, par3, par4, par5, par6, par7);
	 * GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F); //TODO Render Glitch, and
	 * without it the animation doesn't works. //
	 * GL11.glDepthFunc(GL11.GL_EQUAL); } bindEntityTexture(golem);
	 * GL11.glEnable(GL11.GL_BLEND); GL11.glBlendFunc(GL11.GL_SRC_ALPHA,
	 * GL11.GL_ONE_MINUS_SRC_ALPHA); mainModel.render(golem, par2, par3, par4,
	 * par5, par6, par7); GL11.glDisable(GL11.GL_BLEND); } */
	
	/** Renders the Empowered Tenebrae Golem. */
	public void renderEmpoweredTenebraeGolem(EntityTenebraeGuardian golem, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(golem, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEmpoweredTenebraeGolemTextures(EntityTenebraeGuardian golem) {
		return ETgolemTextures;
	}
	
	/** Renders Equipped items. */
	protected void renderEmpoweredTenebraeGolemEquippedItems(EntityTenebraeGuardian golem, float par2) {
		super.renderEquippedItems(golem, par2);
		
	}
	
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2) {
		this.renderEmpoweredTenebraeGolemEquippedItems((EntityTenebraeGuardian) par1EntityLivingBase, par2);
	}
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.rotateEmpoweredTenebraeGolemCorpse((EntityTenebraeGuardian) par1EntityLivingBase, par2, par3, par4);
	}
	
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		this.renderEmpoweredTenebraeGolem((EntityTenebraeGuardian) par1EntityLivingBase, par2, par4, par6, par8, par9);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getEmpoweredTenebraeGolemTextures((EntityTenebraeGuardian) par1Entity);
	}
	
	/** Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that. */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEmpoweredTenebraeGolem((EntityTenebraeGuardian) par1Entity, par2, par4, par6, par8, par9);
	}
	
	/** Renders the model in RenderLiving */
	/* @Override W.I.P protected void renderModel(EntityLivingBase
	 * par1EntityLivingBase, float par2, float par3, float par4, float par5,
	 * float par6, float par7) {
	 * renderEmpoweredTenebraeGolemModel((EntityEmpoweredTenebraeGolem)
	 * par1EntityLivingBase, par2, par3, par4, par5, par6, par7); } */
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderEmpoweredTenebraeGolem((EntityTenebraeGuardian) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	protected void renderLivingAt(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
		GL11.glScalef(0.55F, 0.55F, 0.55F);
		
		// The lols are real.
		//		GL11.glScalef(p_77039_1_.worldObj.rand.nextFloat(), p_77039_1_.worldObj.rand.nextFloat(), p_77039_1_.worldObj.rand.nextFloat());
	}
}
