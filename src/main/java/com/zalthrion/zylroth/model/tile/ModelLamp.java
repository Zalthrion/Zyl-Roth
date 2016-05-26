package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Lamp - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelLamp extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer Light;
    public ModelRenderer TopBase;
    public ModelRenderer FrontRightCorner;
    public ModelRenderer FrontLeftCorner;
    public ModelRenderer BackLeftCorner;
    public ModelRenderer BackRightCorner;
    public ModelRenderer Top;

    public ModelLamp() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.TopBase = new ModelRenderer(this, 0, 0);
        this.TopBase.setRotationPoint(-18.1F, -2.0F, -18.0F);
        this.TopBase.addBox(0.0F, 0.0F, 0.0F, 36, 26, 36, -12.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(-18.1F, 10.0F, -18.0F);
        this.Base.addBox(0.0F, 0.0F, 0.0F, 36, 26, 36, -12.0F);
        this.FrontLeftCorner = new ModelRenderer(this, 130, 36);
        this.FrontLeftCorner.setRotationPoint(-9.6F, -2.0F, -19.5F);
        this.FrontLeftCorner.addBox(0.0F, 0.0F, 0.0F, 29, 38, 29, -14.0F);
        this.BackLeftCorner = new ModelRenderer(this, 130, 36);
        this.BackLeftCorner.setRotationPoint(-9.6F, -2.0F, -9.5F);
        this.BackLeftCorner.addBox(0.0F, 0.0F, 0.0F, 29, 38, 29, -14.0F);
        this.BackRightCorner = new ModelRenderer(this, 130, 36);
        this.BackRightCorner.setRotationPoint(-19.6F, -2.0F, -9.5F);
        this.BackRightCorner.addBox(0.0F, 0.0F, 0.0F, 29, 38, 29, -14.0F);
        this.Top = new ModelRenderer(this, 0, 160);
        this.Top.setRotationPoint(-18.1F, -3.7F, -18.0F);
        this.Top.addBox(0.0F, 0.0F, 0.0F, 36, 27, 36, -12.5F);
        this.Light = new ModelRenderer(this, 0, 75);
        this.Light.setRotationPoint(-18.1F, -2.0F, -18.0F);
        this.Light.addBox(0.0F, 0.0F, 0.0F, 36, 38, 36, -14.0F);
        this.FrontRightCorner = new ModelRenderer(this, 130, 36);
        this.FrontRightCorner.setRotationPoint(-19.6F, -2.0F, -19.5F);
        this.FrontRightCorner.addBox(0.0F, 0.0F, 0.0F, 29, 38, 29, -14.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.TopBase.render(f5);
        this.Base.render(f5);
        this.FrontLeftCorner.render(f5);
        this.BackLeftCorner.render(f5);
        this.BackRightCorner.render(f5);
        this.Top.render(f5);
        this.Light.render(f5);
        this.FrontRightCorner.render(f5);
    }
    
    public void render(float f5) { 
        this.TopBase.render(f5);
        this.Base.render(f5);
        this.FrontLeftCorner.render(f5);
        this.BackLeftCorner.render(f5);
        this.BackRightCorner.render(f5);
        this.Top.render(f5);
        this.Light.render(f5);
        this.FrontRightCorner.render(f5);
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
