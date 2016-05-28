package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.projectile.RepulsorBolt;
import com.zalthrion.zylroth.model.entity.projectile.ModelRepulsorBolt;
import com.zalthrion.zylroth.reference.Reference;

public class RenderRepulsorBolt extends Render<RepulsorBolt> {
	private static final ResourceLocation projectileTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/projectiles/RepulsorBolt.png");
	private ModelRepulsorBolt repulsorBolt = new ModelRepulsorBolt();
	
	public RenderRepulsorBolt(RenderManager renderManager) {
		super(renderManager);
	}
	
	@Override protected ResourceLocation getEntityTexture(RepulsorBolt stag) {
		return projectileTexture;
	}
	
	@Override public void doRender(RepulsorBolt entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		
		GlStateManager.translate(x, y, z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
		
		GlStateManager.translate(0.6F, -1.15F, 0.2F);
		GlStateManager.scale(0.8F, 0.8F, 0.8F);
		
		this.bindEntityTexture(entity);
		this.repulsorBolt.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.05625F);
		
		GlStateManager.popMatrix();
	}
	
	public static class Factory implements IRenderFactory<RepulsorBolt> {
		@Override public Render<? super RepulsorBolt> createRenderFor(RenderManager manager) {
			return new RenderRepulsorBolt(manager);
		}
	}
}