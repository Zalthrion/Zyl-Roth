package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Boar - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelBoar extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer BackLeftLeg;
	public ModelRenderer FrontLeftLeg;
	public ModelRenderer BackRightLeg;
	public ModelRenderer FrontRightLeg;
	public ModelRenderer Head;
	public ModelRenderer LeftTuskBase;
	public ModelRenderer LeftTusk;
	public ModelRenderer RightTuskBase;
	public ModelRenderer RightTusk;
	public ModelRenderer Snout;
	
    protected float field_78145_g = 8.0F;
    protected float field_78151_h = 4.0F;
	
	public ModelBoar() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.BackRightLeg = new ModelRenderer(this, 0, 16);
		this.BackRightLeg.setRotationPoint(-3.0F, 17.0F, 5.5F);
		this.BackRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.Body = new ModelRenderer(this, 28, 8);
		this.Body.setRotationPoint(0.0F, 11.0F, 2.0F);
		this.Body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F);
		this.setRotateAngle(Body, 1.5707963267948966F, 0.0F, 0.0F);
		this.RightTusk = new ModelRenderer(this, 0, 0);
		this.RightTusk.setRotationPoint(-2.0F, 1.73F, -9.35F);
		this.RightTusk.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(RightTusk, 2.280098134805392F, 0.0F, 0.0F);
		this.BackLeftLeg = new ModelRenderer(this, 0, 16);
		this.BackLeftLeg.setRotationPoint(3.0F, 17.0F, 5.5F);
		this.BackLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.RightTuskBase = new ModelRenderer(this, 0, 0);
		this.RightTuskBase.setRotationPoint(-2.0F, 0.7F, -9.3F);
		this.RightTuskBase.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.FrontLeftLeg = new ModelRenderer(this, 0, 16);
		this.FrontLeftLeg.setRotationPoint(3.0F, 17.0F, -5.0F);
		this.FrontLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.Snout = new ModelRenderer(this, 16, 16);
		this.Snout.setRotationPoint(0.5F, -1.0F, 0.0F);
		this.Snout.addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F);
		this.LeftTusk = new ModelRenderer(this, 0, 0);
		this.LeftTusk.setRotationPoint(2.0F, 1.73F, -9.35F);
		this.LeftTusk.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(LeftTusk, 2.280098134805392F, 0.0F, 0.0F);
		this.FrontRightLeg = new ModelRenderer(this, 0, 16);
		this.FrontRightLeg.setRotationPoint(-3.0F, 17.0F, -5.0F);
		this.FrontRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.LeftTuskBase = new ModelRenderer(this, 0, 0);
		this.LeftTuskBase.setRotationPoint(2.0F, 0.7F, -9.3F);
		this.LeftTuskBase.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(-0.5F, 13.5F, -6.0F);
		this.Head.addBox(-4.0F, -4.0F, -8.0F, 9, 7, 8, 0.0F);
		this.Head.addChild(this.RightTusk);
		this.Head.addChild(this.RightTuskBase);
		this.Head.addChild(this.Snout);
		this.Head.addChild(this.LeftTusk);
		this.Head.addChild(this.LeftTuskBase);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		if (this.isChild) {
			float f6 = 2.0F;
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.5F / f6, 1.5F / f6, 1.5F / f6);
			GlStateManager.translate(0.0F, field_78145_g * f5, field_78151_h * f5);
			this.Head.render(f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.scale(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GlStateManager.translate(0.0F, 24.0F * f5, 0.0F);
			this.FrontRightLeg.render(f5);
			this.FrontLeftLeg.render(f5);
			this.BackLeftLeg.render(f5);
			this.BackRightLeg.render(f5);
			this.Body.render(f5);
			GlStateManager.popMatrix();
		} else {
			this.Head.render(f5);
			this.FrontRightLeg.render(f5);
			this.FrontLeftLeg.render(f5);
			this.BackLeftLeg.render(f5);
			this.BackRightLeg.render(f5);
			this.Body.render(f5);
		}
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn) {
		this.Head.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Head.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.Body.rotateAngleX = ((float) Math.PI / 2F);
		this.FrontLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
		this.FrontRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.BackLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.BackRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}