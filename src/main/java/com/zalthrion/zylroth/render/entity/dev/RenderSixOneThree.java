package com.zalthrion.zylroth.render.entity.dev;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.entity.dev.EntitySixOneThree;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSixOneThree extends RenderLiving {
	
	private static final ResourceLocation sixOneThreeTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/dev/61352151511.png");
	
	public ModelBase modelBase;
	
	public RenderSixOneThree(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(EntitySixOneThree sixOneThree) {
		return sixOneThreeTextures;
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntitySixOneThree) entity);
	}
	
	@Override
	protected void renderLivingAt(EntityLivingBase entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		EntitySixOneThree sixOneThree = (EntitySixOneThree) entity;
		
		if (sixOneThree.isChild()) {
			GL11.glScalef(0.8F, 0.8F, 0.8F);
		}
		
		else {
			GL11.glScalef(1.0F, 1.0F, 1.0F);
		}
	}
}