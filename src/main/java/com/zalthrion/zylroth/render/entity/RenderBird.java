package com.zalthrion.zylroth.render.entity;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderBird extends RenderLiving {
	private static final ResourceLocation birdTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Bird.png");
	
	public ModelBase modelBase;
	
	public RenderBird(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(EntityBird bird) {
		return birdTextures;
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityBird) entity);
	}
	
	@Override
	protected void renderLivingAt(EntityLivingBase entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		EntityBird bird = (EntityBird) entity;
		
		if (bird.isChild()) {
			GL11.glScalef(0.25F, 0.25F, 0.25F);
		}
		
		else {
			GL11.glScalef(0.5F, 0.5F, 0.5F);
		}
	}
}
