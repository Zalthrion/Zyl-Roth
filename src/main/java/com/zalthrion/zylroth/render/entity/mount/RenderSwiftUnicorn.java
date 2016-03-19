package com.zalthrion.zylroth.render.entity.mount;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Maps;
import com.zalthrion.zylroth.entity.mount.MountSwiftUnicorn;
import com.zalthrion.zylroth.model.entity.ModelSwiftUnicorn;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderSwiftUnicorn extends RenderLiving<MountSwiftUnicorn> {
	private static final Map<String, ResourceLocation> field_110852_a = Maps.<String, ResourceLocation>newHashMap();
	private static final ResourceLocation unicornTextures = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/entities/Unicorn.png");
	
	public RenderSwiftUnicorn(RenderManager manager) {
		super(manager, new ModelSwiftUnicorn(), 0.5F);
	}
	
	/**
	 * Renders the model in RenderLiving
	 */
	@Override protected void renderModel(MountSwiftUnicorn p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		if (p_77036_1_.isInvisible()) {
			this.mainModel.setRotationAngles(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, p_77036_1_);
		} else {
			this.bindEntityTexture(p_77036_1_);
			this.mainModel.render(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
		}
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	@Override protected ResourceLocation getEntityTexture(MountSwiftUnicorn p_110775_1_) {
		if (!p_110775_1_.func_110239_cn()) {
			switch (p_110775_1_.getType()) {
				case HORSE:
				default:
					return unicornTextures;
			}
		}
		else {
			return this.func_110848_b(p_110775_1_);
		}
	}
	
	private ResourceLocation func_110848_b(MountSwiftUnicorn p_110848_1_) {
		String s = p_110848_1_.getHorseTexture();
		ResourceLocation resourcelocation = (ResourceLocation) field_110852_a.get(s);
		
		if (resourcelocation == null) {
			resourcelocation = new ResourceLocation(s);
			Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(p_110848_1_.getVariantTexturePaths()));
			field_110852_a.put(s, resourcelocation);
		}
		
		return resourcelocation;
	}
}