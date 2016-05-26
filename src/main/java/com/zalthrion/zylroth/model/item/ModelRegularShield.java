package com.zalthrion.zylroth.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Shield2 - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelRegularShield extends ModelBase {
    public ModelRenderer ShieldBottomRight;
    public ModelRenderer ShieldBottomLeft;
    public ModelRenderer ShieldCenter;
    public ModelRenderer ShieldCenterRight;
    public ModelRenderer ShieldCenterLeft;
    public ModelRenderer ShieldTopRight;
    public ModelRenderer ShieldTopLeft;
    public ModelRenderer ShieldTopLeftCorner;
    public ModelRenderer ShieldTopCornerLeft;
    public ModelRenderer ShieldTopRightCorner;
    public ModelRenderer ShieldTopCornerRight;
    public ModelRenderer ShieldTopCenter;
    public ModelRenderer BorderBottomLeftCorner;
    public ModelRenderer BorderBottomCenter;
    public ModelRenderer BorderBottomRightCorner;
    public ModelRenderer BorderLeftSide;
    public ModelRenderer BorderRightSide;
    public ModelRenderer BorderTopLeftCorner;
    public ModelRenderer BorderTopRightCorner;
    public ModelRenderer BorderTopCenter;
    public ModelRenderer BorderTopLeftConnection;
    public ModelRenderer HolderBase;
    public ModelRenderer MainHandler;
    public ModelRenderer HandlerRightSide;
    public ModelRenderer HandleLeftSide;

    public ModelRegularShield() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.ShieldBottomLeft = new ModelRenderer(this, 77, 17);
        this.ShieldBottomLeft.setRotationPoint(3.5F, 16.1F, -1.1F);
        this.ShieldBottomLeft.addBox(0.0F, 0.0F, 0.0F, 4, 7, 2, 0.0F);
        this.setRotateAngle(ShieldBottomLeft, 0.0F, 0.0F, 0.7086036763096978F);
        this.ShieldTopLeftCorner = new ModelRenderer(this, 70, 5);
        this.ShieldTopLeftCorner.setRotationPoint(0.29F, 11.3F, -1.1F);
        this.ShieldTopLeftCorner.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(ShieldTopLeftCorner, 0.0F, 0.0F, -0.8100073058505682F);
        this.BorderTopLeftConnection = new ModelRenderer(this, 61, 12);
        this.BorderTopLeftConnection.setRotationPoint(3.8F, 6.4F, -1.25F);
        this.BorderTopLeftConnection.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.ShieldBottomRight = new ModelRenderer(this, 62, 17);
        this.ShieldBottomRight.setRotationPoint(-6.65F, 18.8F, -1.1F);
        this.ShieldBottomRight.addBox(0.0F, 0.0F, 0.0F, 4, 7, 2, 0.0F);
        this.setRotateAngle(ShieldBottomRight, 0.0F, 0.0F, -0.7312929565856241F);
        this.BorderLeftSide = new ModelRenderer(this, 12, 29);
        this.BorderLeftSide.setRotationPoint(5.47F, 7.52F, -1.25F);
        this.BorderLeftSide.addBox(0.0F, 0.0F, 0.0F, 1, 11, 2, 0.0F);
        this.ShieldTopCornerRight = new ModelRenderer(this, 44, 11);
        this.ShieldTopCornerRight.setRotationPoint(-5.2F, 6.25F, -1.1F);
        this.ShieldTopCornerRight.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
        this.HandleLeftSide = new ModelRenderer(this, 31, 30);
        this.HandleLeftSide.setRotationPoint(0.8F, 14.0F, 0.7F);
        this.HandleLeftSide.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, -0.2F);
        this.ShieldCenterRight = new ModelRenderer(this, 14, 7);
        this.ShieldCenterRight.setRotationPoint(-6.65F, 11.8F, -1.1F);
        this.ShieldCenterRight.addBox(0.0F, 0.0F, 0.0F, 5, 7, 2, 0.0F);
        this.ShieldTopCornerLeft = new ModelRenderer(this, 29, 11);
        this.ShieldTopCornerLeft.setRotationPoint(0.1F, 6.25F, -1.1F);
        this.ShieldTopCornerLeft.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
        this.ShieldTopCenter = new ModelRenderer(this, 40, 5);
        this.ShieldTopCenter.setRotationPoint(-0.6F, 6.25F, -1.1F);
        this.ShieldTopCenter.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.HolderBase = new ModelRenderer(this, 29, 35);
        this.HolderBase.setRotationPoint(-2.0F, 13.2F, 0.3F);
        this.HolderBase.addBox(0.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
        this.HandlerRightSide = new ModelRenderer(this, 31, 41);
        this.HandlerRightSide.setRotationPoint(-1.8F, 14.0F, 0.7F);
        this.HandlerRightSide.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, -0.2F);
        this.MainHandler = new ModelRenderer(this, 41, 36);
        this.MainHandler.setRotationPoint(-1.5F, 14.0F, 1.8F);
        this.MainHandler.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, -0.2F);
        this.BorderTopCenter = new ModelRenderer(this, 14, 4);
        this.BorderTopCenter.setRotationPoint(-4.8F, 6.4F, -1.25F);
        this.BorderTopCenter.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
        this.BorderBottomCenter = new ModelRenderer(this, 5, 56);
        this.BorderBottomCenter.setRotationPoint(-2.0F, 22.9F, -1.25F);
        this.BorderBottomCenter.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
        this.BorderTopRightCorner = new ModelRenderer(this, 20, 31);
        this.BorderTopRightCorner.setRotationPoint(-5.9F, 8.35F, -1.25F);
        this.BorderTopRightCorner.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(BorderTopRightCorner, 0.0F, 0.0F, -2.165779068799764F);
        this.BorderBottomLeftCorner = new ModelRenderer(this, 5, 45);
        this.BorderBottomLeftCorner.setRotationPoint(5.7F, 17.87F, -1.25F);
        this.BorderBottomLeftCorner.addBox(0.0F, 0.0F, 0.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(BorderBottomLeftCorner, 0.0F, 0.0F, 0.6911503837897545F);
        this.BorderBottomRightCorner = new ModelRenderer(this, 12, 45);
        this.BorderBottomRightCorner.setRotationPoint(-6.48F, 18.52F, -1.25F);
        this.BorderBottomRightCorner.addBox(0.0F, 0.0F, 0.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(BorderBottomRightCorner, 0.0F, 0.0F, -0.6946410422937431F);
        this.BorderRightSide = new ModelRenderer(this, 5, 29);
        this.BorderRightSide.setRotationPoint(-6.48F, 7.52F, -1.25F);
        this.BorderRightSide.addBox(0.0F, 0.0F, 0.0F, 1, 11, 2, 0.0F);
        this.ShieldTopRight = new ModelRenderer(this, 17, 18);
        this.ShieldTopRight.setRotationPoint(-6.65F, 7.6F, -1.1F);
        this.ShieldTopRight.addBox(0.0F, 0.0F, 0.0F, 7, 5, 2, 0.0F);
        this.ShieldTopRightCorner = new ModelRenderer(this, 50, 5);
        this.ShieldTopRightCorner.setRotationPoint(-5.06F, 6.4F, -1.1F);
        this.ShieldTopRightCorner.addBox(-0.2F, 0.0F, 0.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(ShieldTopRightCorner, 0.0F, 0.0F, 0.8100073058505682F);
        this.ShieldCenterLeft = new ModelRenderer(this, 1, 16);
        this.ShieldCenterLeft.setRotationPoint(1.55F, 11.7F, -1.1F);
        this.ShieldCenterLeft.addBox(0.0F, 0.0F, 0.0F, 5, 7, 2, 0.0F);
        this.ShieldTopLeft = new ModelRenderer(this, 37, 19);
        this.ShieldTopLeft.setRotationPoint(-0.45F, 7.6F, -1.1F);
        this.ShieldTopLeft.addBox(0.0F, 0.0F, 0.0F, 7, 5, 2, 0.0F);
        this.ShieldCenter = new ModelRenderer(this, 1, 1);
        this.ShieldCenter.setRotationPoint(-2.0F, 12.0F, -1.1F);
        this.ShieldCenter.addBox(0.0F, 0.0F, 0.0F, 4, 12, 2, 0.0F);
        this.BorderTopLeftCorner = new ModelRenderer(this, 20, 37);
        this.BorderTopLeftCorner.setRotationPoint(6.45F, 7.52F, -1.25F);
        this.BorderTopLeftCorner.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(BorderTopLeftCorner, 0.0F, 0.0F, 2.1682225297525557F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ShieldBottomLeft.render(f5);
        this.ShieldTopLeftCorner.render(f5);
        this.BorderTopLeftConnection.render(f5);
        this.ShieldBottomRight.render(f5);
        this.BorderLeftSide.render(f5);
        this.ShieldTopCornerRight.render(f5);
        this.HandleLeftSide.render(f5);
        this.ShieldCenterRight.render(f5);
        this.ShieldTopCornerLeft.render(f5);
        this.ShieldTopCenter.render(f5);
        this.HolderBase.render(f5);
        this.HandlerRightSide.render(f5);
        this.MainHandler.render(f5);
        this.BorderTopCenter.render(f5);
        this.BorderBottomCenter.render(f5);
        this.BorderTopRightCorner.render(f5);
        this.BorderBottomLeftCorner.render(f5);
        this.BorderBottomRightCorner.render(f5);
        this.BorderRightSide.render(f5);
        this.ShieldTopRight.render(f5);
        this.ShieldTopRightCorner.render(f5);
        this.ShieldCenterLeft.render(f5);
        this.ShieldTopLeft.render(f5);
        this.ShieldCenter.render(f5);
        this.BorderTopLeftCorner.render(f5);
    }
    
    public void render(float f5) { 
        this.ShieldBottomLeft.render(f5);
        this.ShieldTopLeftCorner.render(f5);
        this.BorderTopLeftConnection.render(f5);
        this.ShieldBottomRight.render(f5);
        this.BorderLeftSide.render(f5);
        this.ShieldTopCornerRight.render(f5);
        this.HandleLeftSide.render(f5);
        this.ShieldCenterRight.render(f5);
        this.ShieldTopCornerLeft.render(f5);
        this.ShieldTopCenter.render(f5);
        this.HolderBase.render(f5);
        this.HandlerRightSide.render(f5);
        this.MainHandler.render(f5);
        this.BorderTopCenter.render(f5);
        this.BorderBottomCenter.render(f5);
        this.BorderTopRightCorner.render(f5);
        this.BorderBottomLeftCorner.render(f5);
        this.BorderBottomRightCorner.render(f5);
        this.BorderRightSide.render(f5);
        this.ShieldTopRight.render(f5);
        this.ShieldTopRightCorner.render(f5);
        this.ShieldCenterLeft.render(f5);
        this.ShieldTopLeft.render(f5);
        this.ShieldCenter.render(f5);
        this.BorderTopLeftCorner.render(f5);
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
