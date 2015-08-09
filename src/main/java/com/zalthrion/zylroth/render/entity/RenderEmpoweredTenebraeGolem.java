package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderEmpoweredTenebraeGolem extends RenderLiving {
	
	private static final ResourceLocation ETgolemTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Empowered_Tenebrae_Golem.png");
	
	/** Empowered Tenebrae Golem's Model. */
	@SuppressWarnings("unused")
	private final ModelEmpoweredTenebraeGolem empowered_tenebrae_golemModel;
	
	public RenderEmpoweredTenebraeGolem(RenderManager manager, ModelEmpoweredTenebraeGolem modelEmpoweredTenebraeGolem, float shadowSize) {
		super(manager, new ModelEmpoweredTenebraeGolem(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
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
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderEmpoweredTenebraeGolem((EntityEmpoweredTenebraeGolem) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.rotateEmpoweredTenebraeGolemCorpse((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2, par3, par4);
	}
	
	public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderEmpoweredTenebraeGolem((EntityEmpoweredTenebraeGolem) par1EntityLivingBase, par2, par4, par6, par8, par9);
	}
	
	@Override protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getEmpoweredTenebraeGolemTextures((EntityEmpoweredTenebraeGolem) par1Entity);
	}
	
	@Override public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.doRenderEmpoweredTenebraeGolem((EntityEmpoweredTenebraeGolem) par1Entity, par2, par4, par6, par8, par9);
	}
	
	@Override protected void renderLivingAt(EntityLivingBase entity, double x, double y, double z) {
		super.renderLivingAt(entity, x, y, z);
		GlStateManager.scale(0.55F,  0.55F, 0.55F);
	}
}
