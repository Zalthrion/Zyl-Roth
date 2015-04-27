package com.zalthrion.zylroth.render.entity.mount;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWarTortoise extends RenderLiving {
	
	private static final ResourceLocation pigTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Rainbow_Pig.png");
	
	public ModelBase modelBase;
	
	public RenderWarTortoise(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(MountWarTortoise p_110775_1_) {
		return pigTextures;
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((MountWarTortoise) p_110775_1_);
	}
}