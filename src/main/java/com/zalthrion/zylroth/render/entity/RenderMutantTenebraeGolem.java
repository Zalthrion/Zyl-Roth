package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelMutantTenebraeGolem;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMutantTenebraeGolem extends RenderLiving {
	
	private static final ResourceLocation MTgolemTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Mutant_Tenebrae_Golem.png");
	
	/** Iron Golem's Model. */
	@SuppressWarnings("unused")
	private final ModelMutantTenebraeGolem mutant_tenebrae_golemModel;
	
	public RenderMutantTenebraeGolem(ModelMutantTenebraeGolem modelMutantTenebraeGolem, float shadowSize) {
		super(new ModelMutantTenebraeGolem(), 0.5F);
		this.mutant_tenebrae_golemModel = (ModelMutantTenebraeGolem) this.mainModel;
	}
	
	/** Renders the Iron Golem. */
	public void doRenderMutantTenebraeGolem(EntityEmpoweredTenebraeGolem par1EntityMutantTenebraeGolem, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityMutantTenebraeGolem, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getMutantTenebraeGolemTextures(EntityEmpoweredTenebraeGolem par1EntityMutantTenebraeGolem) {
		return MTgolemTextures;
	}
	
	/** Rotates Mutant Tenebrae Golem corpse. */
	protected void rotateMutantTenebraeGolemCorpse(EntityEmpoweredTenebraeGolem par1EntityMutantTenebraeGolem, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityMutantTenebraeGolem, par2, par3, par4);
		
		if ((double) par1EntityMutantTenebraeGolem.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityMutantTenebraeGolem.limbSwing - par1EntityMutantTenebraeGolem.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}
	
	/** Renders Iron Golem Equipped items. */
	protected void renderMutantTenebraeGolemEquippedItems(EntityEmpoweredTenebraeGolem par1EntityMutantTenebraeGolem, float par2) {
		super.renderEquippedItems(par1EntityMutantTenebraeGolem, par2);
		
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderMutantTenebraeGolem((EntityEmpoweredTenebraeGolem) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2) {
		this.renderMutantTenebraeGolemEquippedItems((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2);
	}
	
	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.rotateMutantTenebraeGolemCorpse((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2, par3, par4);
	}
	
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderMutantTenebraeGolem((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2, par4, par6, par8, par9);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getMutantTenebraeGolemTextures((EntityEmpoweredTenebraeGolem) par1Entity);
	}
	
	/** Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that. */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderMutantTenebraeGolem((EntityEmpoweredTenebraeGolem) par1Entity, par2, par4, par6, par8, par9);
	}
	
}
