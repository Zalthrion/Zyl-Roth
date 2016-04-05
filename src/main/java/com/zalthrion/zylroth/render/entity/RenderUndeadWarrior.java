package com.zalthrion.zylroth.render.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.model.entity.ModelUndead;
import com.zalthrion.zylroth.reference.Reference;

@SideOnly(Side.CLIENT)
public class RenderUndeadWarrior extends RenderBiped<EntityUndeadWarrior> {
	private static final ResourceLocation undeadwarriorTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entities/Undead_Unit.png");
	/** Scale of the model to use */
	private float scale = 0.8F;
	
	public RenderUndeadWarrior(RenderManager manager) {
		super(manager, new ModelUndead(), 0.25F);
		this.addLayer(new LayerBipedArmor(this));
		this.addLayer(new LayerHeldItem(this));
	}
	
	/** Applies the scale to the transform matrix */
	@Override protected void preRenderCallback(EntityUndeadWarrior par1EntityUndeadWarrior, float par2) {
		GlStateManager.scale(scale, scale, scale);
	}
	
	@Override protected ResourceLocation getEntityTexture(EntityUndeadWarrior par1EntityUndeadWarrior) {
		return undeadwarriorTextures;
	}
	
	@Override protected void rotateCorpse(EntityUndeadWarrior par1EntityUndeadWarrior, float par2, float par3, float par4) {
		super.rotateCorpse(par1EntityUndeadWarrior, par2, par3, par4);
		
		if ((double) par1EntityUndeadWarrior.limbSwingAmount >= 0.01D) {
			float f3 = 13.0F;
			float f4 = par1EntityUndeadWarrior.limbSwing - par1EntityUndeadWarrior.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GlStateManager.rotate(6.5F * f5, 0, 0, 1);
		}
	}
	
	public static class Factory implements IRenderFactory<EntityUndeadWarrior> {
		@Override public Render<? super EntityUndeadWarrior> createRenderFor(RenderManager manager) {
			return new RenderUndeadWarrior(manager);
		}
	}
}