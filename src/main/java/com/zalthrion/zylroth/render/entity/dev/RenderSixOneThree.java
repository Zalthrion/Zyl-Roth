package com.zalthrion.zylroth.render.entity.dev;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.dev.EntitySixOneThree;
import com.zalthrion.zylroth.model.entity.ModelSpecialBiped;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
 public class RenderSixOneThree extends RenderBiped<EntitySixOneThree> {
	private static final ResourceLocation sixOneThreeTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/dev/61352151511.png");
	
	public RenderSixOneThree(RenderManager renderManager) {
		super(renderManager, new ModelSpecialBiped(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntitySixOneThree sixOneThree) {
		return sixOneThreeTexture;
	}
	
	@Override protected void renderLivingAt(EntitySixOneThree entity, double x, double y, double z) {
		super.renderLivingAt(entity, x, y, z);
		
		if (entity.isChild()) {
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
		} else {
			GlStateManager.scale(1.0F, 1.0F, 1.0F);
		}
	}
	
	public static class Factory implements IRenderFactory<EntitySixOneThree> {
		@Override public Render<? super EntitySixOneThree> createRenderFor(RenderManager manager) {
			return new RenderSixOneThree(manager);
		}
	}
}