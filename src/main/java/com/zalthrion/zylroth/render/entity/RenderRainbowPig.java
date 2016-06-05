package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.lib.ModInit.ResourceLocationInit;
import com.zalthrion.zylroth.model.entity.ModelRainbowPig;

@SideOnly(Side.CLIENT) public class RenderRainbowPig extends RenderLiving<EntityRainbowPig> {
	public RenderRainbowPig(RenderManager renderManager) {
		super(renderManager, new ModelRainbowPig(), 0.5F);
		this.addLayer(new LayerRainbowPigSaddle(this));
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityRainbowPig p_110775_1_) {
		return ResourceLocationInit.ENTITY_RAINBOW_PIG;
	}
	
	public static class Factory implements IRenderFactory<EntityRainbowPig> {
		@Override public Render<? super EntityRainbowPig> createRenderFor(RenderManager manager) {
			return new RenderRainbowPig(manager);
		}
	}
}