package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.lib.ModInit.ResourceLocationInit;
import com.zalthrion.zylroth.model.entity.ModelTenebraeGolem;

@SideOnly(Side.CLIENT) public class RenderTenebraeProtector extends RenderLiving<EntityTenebraeProtector> {
	public RenderTenebraeProtector(RenderManager manager) {
		super(manager, new ModelTenebraeGolem(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
	}
	
	@Override public void doRender(EntityTenebraeProtector par1EntityTenebraeGolem, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityTenebraeGolem, par2, par4, par6, par8, par9);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityTenebraeProtector par1EntityTenebraeGolem) {
		return ResourceLocationInit.ENTITY_TENEBRAE_GOLEM;
	}
	
	@Override protected void rotateCorpse(EntityTenebraeProtector par1EntityTenebraeGolem, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityTenebraeGolem, par2, par3, par4);
		
		if ((double) par1EntityTenebraeGolem.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityTenebraeGolem.limbSwing - par1EntityTenebraeGolem.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GlStateManager.rotate(6.5F * f5, 0, 0, 1);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityTenebraeProtector> {
		@Override public Render<? super EntityTenebraeProtector> createRenderFor(RenderManager manager) {
			return new RenderTenebraeProtector(manager);
		}
	}
}