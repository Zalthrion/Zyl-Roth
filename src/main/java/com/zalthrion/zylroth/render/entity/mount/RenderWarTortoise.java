package com.zalthrion.zylroth.render.entity.mount;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.lib.ModInit.ResourceLocationInit;
import com.zalthrion.zylroth.model.entity.mount.ModelWarTortoise;

@SideOnly(Side.CLIENT) public class RenderWarTortoise extends RenderLiving<MountWarTortoise> {
	public ModelBase modelBase;
	
	public RenderWarTortoise(RenderManager manager) {
		super(manager, new ModelWarTortoise(), 0.5F);
	}
	
	@Override protected ResourceLocation getEntityTexture(MountWarTortoise p_110775_1_) {
		return ResourceLocationInit.ENTITY_WAR_TORTOISE;
	}
	
	public static class Factory implements IRenderFactory<MountWarTortoise> {
		@Override public Render<? super MountWarTortoise> createRenderFor(RenderManager manager) {
			return new RenderWarTortoise(manager);
		}
	}
}