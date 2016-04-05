package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.model.entity.ModelEmpoweredTenebraeGolem;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderTenebraeGuardian extends RenderLiving<EntityTenebraeGuardian> {
	
	//  private static final ResourceLocation explosion = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/EmpoweredTenebraeGolem_exploding.png");
	private static final ResourceLocation etGolemTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Empowered_Tenebrae_Golem.png");
	
	/** Empowered Tenebrae Golem's Model. */
	@SuppressWarnings("unused")
	private final ModelEmpoweredTenebraeGolem empowered_tenebrae_golemModel;
	
	public RenderTenebraeGuardian(RenderManager manager) {
		super(manager, new ModelEmpoweredTenebraeGolem(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.empowered_tenebrae_golemModel = (ModelEmpoweredTenebraeGolem) this.mainModel;
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityTenebraeGuardian par1EntityEmpoweredTenebraeGolem) {
		return etGolemTextures;
	}
	
	/** Rotates Empowered Tenebrae Golem corpse. */
	@Override protected void rotateCorpse(EntityTenebraeGuardian golem, float par2, float par3, float par4) {
		super.rotateCorpse(golem, par2, par3, par4);
		
		if ((double) golem.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = golem.limbSwing - golem.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GlStateManager.rotate(6.5F * f5, 0, 0, 1);
		}
		
		if (golem.deathTime > 0) {
			float f5 = (golem.deathTime + par4 - 1.0F) / 20.0F * 1.6F;
			f5 = MathHelper.sqrt_float(f5);
			if (f5 > 1F) f5 = 1F;
			GlStateManager.rotate(f5 * getDeathMaxRotation(golem), 0, 0, 1);
		}
	}
	
/*	protected void renderEmpoweredTenebraeGolemModel(EntityEmpoweredTenebraeGolem golem, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (golem.deathTicks > 0) {
			float f6 = golem.deathTicks / 200.0F;
			GlStateManager.depthFunc(GL11.GL_LEQUAL);
			GlStateManager.enableAlpha();
			GlStateManager.alphaFunc(GL11.GL_GREATER, f6);
			bindTexture(explosion);
			mainModel.render(golem, par2, par3, par4, par5, par6, par7);
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
			GlStateManager.depthFunc(GL11.GL_EQUAL);
			// TODO Render Glitch, and without it the animation doesn't works.
			// GL11.glDepthFunc(GL11.GL_EQUAL);
		}
		
		bindEntityTexture(golem);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		mainModel.render(golem, par2, par3, par4, par5, par6, par7);
		GlStateManager.disableBlend();
	}*/
	
	@Override public void doRender(EntityTenebraeGuardian golem, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(golem, par2, par4, par6, par8, par9);
	}
	
	@Override protected void renderLivingAt(EntityTenebraeGuardian entity, double x, double y, double z) {
		super.renderLivingAt(entity, x, y, z);
		GlStateManager.scale(0.55F,  0.55F, 0.55F);
	}
	
	public static class Factory implements IRenderFactory<EntityTenebraeGuardian> {
		@Override public Render<? super EntityTenebraeGuardian> createRenderFor(RenderManager manager) {
			return new RenderTenebraeGuardian(manager);
		}
	}
}
