package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * ModelInfuser 2.0 - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelInfuser extends ModelBase {
    public ModelRenderer Cube;
    public ModelRenderer ColumnI;
    public ModelRenderer ColumnII;
    public ModelRenderer ColumnIII;
    public ModelRenderer ColumnIV;
    public ModelRenderer BaseI;
    public ModelRenderer BaseII;
    public ModelRenderer BaseIII;
    public ModelRenderer BaseIV;
    public ModelRenderer TopI;
    public ModelRenderer TopII;
    public ModelRenderer TopIII;
    public ModelRenderer TopIV;
    public ModelRenderer OnButton;
    public ModelRenderer OffButton;
    public ModelRenderer ItemEntrance;
    public ModelRenderer IEFrameI;
    public ModelRenderer IEFrameII;
    public ModelRenderer IEFrameIII;
    public ModelRenderer IEFrameIV;
    public ModelRenderer Screen;
    public ModelRenderer SCFrameI;
    public ModelRenderer SCFrameII;
    public ModelRenderer SCFrameIII;
    public ModelRenderer SCFrameIV;
    public ModelRenderer StartButton;
    public ModelRenderer LeftButton;
    public ModelRenderer RightButton;

    public ModelInfuser() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.BaseIII = new ModelRenderer(this, 60, 20);
        this.BaseIII.setRotationPoint(-7.5F, 23.0F, -8.0F);
        this.BaseIII.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.IEFrameI = new ModelRenderer(this, 20, 31);
        this.IEFrameI.setRotationPoint(-2.5F, 8.0F, -2.5F);
        this.IEFrameI.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.SCFrameII = new ModelRenderer(this, 24, 40);
        this.SCFrameII.setRotationPoint(5.0F, 11.5F, -7.8F);
        this.SCFrameII.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.OnButton = new ModelRenderer(this, 10, 31);
        this.OnButton.setRotationPoint(5.2F, 20.6F, -7.7F);
        this.OnButton.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.TopIII = new ModelRenderer(this, 60, 20);
        this.TopIII.setRotationPoint(-7.5F, 8.0F, 7.0F);
        this.TopIII.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.TopII = new ModelRenderer(this, 73, 30);
        this.TopII.setRotationPoint(7.0F, 8.0F, -8.0F);
        this.TopII.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.SCFrameI = new ModelRenderer(this, 60, 25);
        this.SCFrameI.setRotationPoint(-1.0F, 10.5F, -7.8F);
        this.SCFrameI.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.SCFrameIII = new ModelRenderer(this, 78, 25);
        this.SCFrameIII.setRotationPoint(-1.0F, 14.5F, -7.8F);
        this.SCFrameIII.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.Screen = new ModelRenderer(this, 10, 40);
        this.Screen.setRotationPoint(0.0F, 11.5F, -7.7F);
        this.Screen.addBox(0.0F, 0.0F, 0.0F, 5, 3, 1, 0.0F);
        this.ColumnIII = new ModelRenderer(this, 5, 30);
        this.ColumnIII.setRotationPoint(-8.0F, 9.0F, -8.0F);
        this.ColumnIII.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.Cube = new ModelRenderer(this, 0, 0);
        this.Cube.setRotationPoint(-7.5F, 8.5F, -7.5F);
        this.Cube.addBox(0.0F, 0.0F, 0.0F, 15, 15, 15, 0.0F);
        this.IEFrameIII = new ModelRenderer(this, 20, 31);
        this.IEFrameIII.setRotationPoint(-2.5F, 8.0F, 1.5F);
        this.IEFrameIII.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
        this.BaseI = new ModelRenderer(this, 73, 0);
        this.BaseI.setRotationPoint(-8.0F, 23.0F, -8.0F);
        this.BaseI.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.SCFrameIV = new ModelRenderer(this, 30, 40);
        this.SCFrameIV.setRotationPoint(-1.0F, 11.5F, -7.8F);
        this.SCFrameIV.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.StartButton = new ModelRenderer(this, 95, 25);
        this.StartButton.setRotationPoint(-3.5F, 17.6F, -7.7F);
        this.StartButton.addBox(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
        this.BaseII = new ModelRenderer(this, 73, 30);
        this.BaseII.setRotationPoint(7.0F, 23.0F, -8.0F);
        this.BaseII.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.OffButton = new ModelRenderer(this, 15, 31);
        this.OffButton.setRotationPoint(3.3F, 20.6F, -7.7F);
        this.OffButton.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.TopI = new ModelRenderer(this, 73, 0);
        this.TopI.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.TopI.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.TopIV = new ModelRenderer(this, 94, 20);
        this.TopIV.setRotationPoint(-7.5F, 8.0F, -8.0F);
        this.TopIV.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.RightButton = new ModelRenderer(this, 41, 41);
        this.RightButton.setRotationPoint(-3.0F, 12.0F, -7.7F);
        this.RightButton.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.LeftButton = new ModelRenderer(this, 35, 41);
        this.LeftButton.setRotationPoint(-4.5F, 12.0F, -7.7F);
        this.LeftButton.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.BaseIV = new ModelRenderer(this, 94, 20);
        this.BaseIV.setRotationPoint(-7.5F, 23.0F, 7.0F);
        this.BaseIV.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.ItemEntrance = new ModelRenderer(this, 10, 35);
        this.ItemEntrance.setRotationPoint(-1.5F, 8.3F, -1.5F);
        this.ItemEntrance.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        this.IEFrameII = new ModelRenderer(this, 24, 35);
        this.IEFrameII.setRotationPoint(-2.5F, 8.0F, -1.5F);
        this.IEFrameII.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.IEFrameIV = new ModelRenderer(this, 24, 35);
        this.IEFrameIV.setRotationPoint(1.5F, 8.0F, -1.5F);
        this.IEFrameIV.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.ColumnIV = new ModelRenderer(this, 0, 30);
        this.ColumnIV.setRotationPoint(-8.0F, 9.0F, 7.0F);
        this.ColumnIV.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.ColumnII = new ModelRenderer(this, 5, 30);
        this.ColumnII.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.ColumnII.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.ColumnI = new ModelRenderer(this, 0, 30);
        this.ColumnI.setRotationPoint(7.0F, 9.0F, -8.0F);
        this.ColumnI.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BaseIII.render(f5);
        this.IEFrameI.render(f5);
        this.SCFrameII.render(f5);
        this.OnButton.render(f5);
        this.TopIII.render(f5);
        this.TopII.render(f5);
        this.SCFrameI.render(f5);
        this.SCFrameIII.render(f5);
        this.Screen.render(f5);
        this.ColumnIII.render(f5);
        this.Cube.render(f5);
        this.IEFrameIII.render(f5);
        this.BaseI.render(f5);
        this.SCFrameIV.render(f5);
        this.StartButton.render(f5);
        this.BaseII.render(f5);
        this.OffButton.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.TopI.offsetX, this.TopI.offsetY, this.TopI.offsetZ);
        GlStateManager.translate(this.TopI.rotationPointX * f5, this.TopI.rotationPointY * f5, this.TopI.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 0.9D, 1.0D);
        GlStateManager.translate(-this.TopI.offsetX, -this.TopI.offsetY, -this.TopI.offsetZ);
        GlStateManager.translate(-this.TopI.rotationPointX * f5, -this.TopI.rotationPointY * f5, -this.TopI.rotationPointZ * f5);
        this.TopI.render(f5);
        GlStateManager.popMatrix();
        this.TopIV.render(f5);
        this.RightButton.render(f5);
        this.LeftButton.render(f5);
        this.BaseIV.render(f5);
        this.ItemEntrance.render(f5);
        this.IEFrameII.render(f5);
        this.IEFrameIV.render(f5);
        this.ColumnIV.render(f5);
        this.ColumnII.render(f5);
        this.ColumnI.render(f5);
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