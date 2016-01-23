package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.model.entity.ModelBoar;
import com.zalthrion.zylroth.reference.Reference;

public class RenderBoar extends RenderLiving {
	private static final ResourceLocation boarTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Boar.png");
	
	public RenderBoar(ModelBoar modelBoar, float shadowSize) {
		super(modelBoar, shadowSize);
	}
	
	@Override protected ResourceLocation getEntityTexture(Entity entity) {
		return boarTexture;
	}
}