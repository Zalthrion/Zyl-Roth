package com.zalthrion.zylroth.render.entity.dev;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.entity.dev.EntityZalthrion;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderZalthrion extends RenderLiving {
	
	private static final ResourceLocation zalthrionTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/dev/Zalthrion.png");
	
	public ModelBase modelBase;
	
	public RenderZalthrion(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(EntityZalthrion zalthrion) {
		return zalthrionTextures;
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityZalthrion) entity);
	}
	
	@Override
	protected void renderLivingAt(EntityLivingBase entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		EntityZalthrion zalthrion = (EntityZalthrion) entity;
		
		if (zalthrion.isChild()) {
			GL11.glScalef(0.8F, 0.8F, 0.8F);
		}
		
		else {
			GL11.glScalef(1.0F, 1.0F, 1.0F);
		}
	}
}