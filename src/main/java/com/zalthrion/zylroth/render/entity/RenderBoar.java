package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import com.zalthrion.zylroth.entity.EntityBoar;
import com.zalthrion.zylroth.model.entity.ModelBoar;
import com.zalthrion.zylroth.reference.Reference;

public class RenderBoar extends RenderLiving<EntityBoar> {
	private static final ResourceLocation boarTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Boar.png");
	
	public RenderBoar(RenderManager renderManager) {
		super(renderManager, new ModelBoar(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityBoar entity) {
		return boarTexture;
	}
	
	public static class Factory implements IRenderFactory<EntityBoar> {
		@Override public Render<? super EntityBoar> createRenderFor(RenderManager manager) {
			return new RenderBoar(manager);
		}
	}
}