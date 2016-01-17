package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

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
    public ModelRenderer Snout;
    public ModelRenderer LeftTuskBase;
    public ModelRenderer LeftTusk;
    public ModelRenderer RightTuskBase;
    public ModelRenderer RightTusk;

    public ModelBoar() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Snout = new ModelRenderer(this, 16, 16);
        this.Snout.setRotationPoint(0.0F, 12.5F, -6.0F);
        this.Snout.addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F);
        this.LeftTusk = new ModelRenderer(this, 0, 0);
        this.LeftTusk.setRotationPoint(2.0F, 1.73F, -9.35F);
        this.LeftTusk.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(LeftTusk, 2.280098134805392F, 0.0F, 0.0F);
        this.BackLeftLeg = new ModelRenderer(this, 0, 16);
        this.BackLeftLeg.setRotationPoint(3.0F, 18.0F, 5.5F);
        this.BackLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 0, 16);
        this.FrontRightLeg.setRotationPoint(-3.0F, 18.0F, -5.0F);
        this.FrontRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.RightTuskBase = new ModelRenderer(this, 0, 0);
        this.RightTuskBase.setRotationPoint(-2.0F, 0.7F, -9.3F);
        this.RightTuskBase.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(-0.5F, 13.5F, -6.0F);
        this.Head.addBox(-4.0F, -4.0F, -8.0F, 9, 7, 8, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 0, 16);
        this.BackRightLeg.setRotationPoint(-3.0F, 18.0F, 5.5F);
        this.BackRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Body = new ModelRenderer(this, 28, 8);
        this.Body.setRotationPoint(0.0F, 11.0F, 2.0F);
        this.Body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F);
        this.setRotateAngle(Body, 1.5707963267948966F, 0.0F, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 0, 16);
        this.FrontLeftLeg.setRotationPoint(3.0F, 18.0F, -5.0F);
        this.FrontLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.RightTusk = new ModelRenderer(this, 0, 0);
        this.RightTusk.setRotationPoint(-2.0F, 1.73F, -9.35F);
        this.RightTusk.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(RightTusk, 2.280098134805392F, 0.0F, 0.0F);
        this.LeftTuskBase = new ModelRenderer(this, 0, 0);
        this.LeftTuskBase.setRotationPoint(2.0F, 0.7F, -9.3F);
        this.LeftTuskBase.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.Head.addChild(this.LeftTusk);
        this.Head.addChild(this.RightTuskBase);
        this.Head.addChild(this.RightTusk);
        this.Head.addChild(this.LeftTuskBase);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Snout.render(f5);
        this.BackLeftLeg.render(f5);
        this.FrontRightLeg.render(f5);
        this.Head.render(f5);
        this.BackRightLeg.render(f5);
        this.Body.render(f5);
        this.FrontLeftLeg.render(f5);
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