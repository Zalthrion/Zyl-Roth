package com.zalthrion.zylroth.render.entity;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityTuskarr;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTuskarr extends RenderLiving {
	
	private static final ResourceLocation tuskarrTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Tuskarr.png");
	
	public ModelBase modelBase;
	
	public RenderTuskarr(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(EntityTuskarr tuskarr) {
		return tuskarrTextures;
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityTuskarr) entity);
	}
	
	@Override
	protected void renderLivingAt(EntityLivingBase entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		EntityTuskarr tuskarr = (EntityTuskarr) entity;
		
		if (tuskarr.isChild()) {
			GL11.glScalef(0.45F, 0.45F, 0.45F);
		}
		
		else {
			GL11.glScalef(0.75F, 0.75F, 0.75F);
		}
	}
}