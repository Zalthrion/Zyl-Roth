package com.zalthrion.zylroth.render.entity.dev;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.dev.EntitySixOneThree;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
 public class RenderSixOneThree extends RenderLiving<EntitySixOneThree> {
	private static final ResourceLocation sixOneThreeTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/dev/61352151511.png");
	
	public RenderSixOneThree(RenderManager renderManager) {
		super(renderManager, new ModelBiped(), 0.5F);
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
}