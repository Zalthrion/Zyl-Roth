package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderRainbowPig extends RenderLiving<EntityRainbowPig> {
	
    private static final ResourceLocation saddledPigTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Rainbow_Pig_saddle.png");
	private static final ResourceLocation pigTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Rainbow_Pig.png");
	
	public ModelBase modelBase;
	
	public RenderRainbowPig(RenderManager renderManager, ModelBase model, float shadowSize) {
		super(renderManager, model, shadowSize);
        
        this.modelBase = model;
	}
	
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityRainbowPig p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ == 0 && p_77032_1_.getSaddled())
        {
            this.bindTexture(saddledPigTextures);
            return 1;
        }
        else
        {
            return -1;
        }
    }
	
	/** Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture. */
	@Override protected ResourceLocation getEntityTexture(EntityRainbowPig p_110775_1_) {
		return pigTextures;
	}
	
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityRainbowPig)p_77032_1_, p_77032_2_, p_77032_3_);
    }
}