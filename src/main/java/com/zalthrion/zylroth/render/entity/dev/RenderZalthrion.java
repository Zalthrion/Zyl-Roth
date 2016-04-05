package com.zalthrion.zylroth.render.entity.dev;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.dev.EntityZalthrion;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
 public class RenderZalthrion extends RenderLiving<EntityZalthrion> {
	private static final ResourceLocation zalthrionTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/dev/Zalthrion.png");

	public RenderZalthrion(RenderManager renderManager) {
		super(renderManager, new ModelBiped(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityZalthrion zalthrion) {
		return zalthrionTexture;
	}
	
	@Override protected void renderLivingAt(EntityZalthrion entity, double x, double y, double z) {
		super.renderLivingAt(entity, x, y, z);
		
		if (entity.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else {
			GlStateManager.scale(1.0F, 1.0F, 1.0F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityZalthrion> {
		@Override public Render<? super EntityZalthrion> createRenderFor(RenderManager manager) {
			return new RenderZalthrion(manager);
		}
	}
}