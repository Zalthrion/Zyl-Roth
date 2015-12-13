package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.entity.EntityFancyBadger;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderFancyBadger extends RenderLiving<EntityFancyBadger> {
	private static final ResourceLocation fancybadgerTextures = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Badger.png");
	public ModelBase modelBase;
	
	public RenderFancyBadger(RenderManager manager, ModelBase model, float shadowSize) {
		super(manager, model, shadowSize);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override protected ResourceLocation getEntityTexture(EntityFancyBadger fancybadger) {
		return fancybadgerTextures;
	}
	
	@Override
	protected void renderLivingAt(EntityFancyBadger entity, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt(entity, p_77039_2_, p_77039_4_, p_77039_6_);
		
		if (entity.isChild()) {
			GL11.glScalef(0.8F, 0.8F, 0.8F);
		}
		
		else {
			GL11.glScalef(1.2F, 1.2F, 1.2F);
		}
	}
}