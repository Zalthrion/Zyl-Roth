package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.model.entity.ModelRainbowPig;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderRainbowPig extends RenderLiving<EntityRainbowPig> {
	private static final ResourceLocation pigTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Rainbow_Pig.png");
	
	public RenderRainbowPig(RenderManager renderManager) {
		super(renderManager, new ModelRainbowPig(), 0.5F);
        this.addLayer(new LayerRainbowPigSaddle(this));
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityRainbowPig p_110775_1_) {
		return pigTexture;
	}
}