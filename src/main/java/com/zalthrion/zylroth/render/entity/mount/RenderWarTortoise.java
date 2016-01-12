package com.zalthrion.zylroth.render.entity.mount;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.model.entity.mount.ModelWarTortoise;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderWarTortoise extends RenderLiving<MountWarTortoise> {
	
	private static final ResourceLocation pigTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Rainbow_Pig.png");
	
	public ModelBase modelBase;
	
	public RenderWarTortoise(RenderManager manager) {
		super(manager, new ModelWarTortoise(), 0.5F);
	}
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override protected ResourceLocation getEntityTexture(MountWarTortoise p_110775_1_) {
		return pigTextures;
	}
}