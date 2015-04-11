package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
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

    public ModelInfuser() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Cube = new ModelRenderer(this, 0, 0);
        this.Cube.setRotationPoint(-7.5F, 8.5F, -7.5F);
        this.Cube.addBox(0.0F, 0.0F, 0.0F, 15, 15, 15, 0.0F);
        this.BaseIII = new ModelRenderer(this, 60, 20);
        this.BaseIII.setRotationPoint(-7.5F, 23.0F, -8.0F);
        this.BaseIII.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.ColumnIII = new ModelRenderer(this, 10, 30);
        this.ColumnIII.setRotationPoint(-8.0F, 9.0F, -8.0F);
        this.ColumnIII.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.TopI = new ModelRenderer(this, 60, 30);
        this.TopI.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.TopI.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.BaseII = new ModelRenderer(this, 94, 0);
        this.BaseII.setRotationPoint(7.0F, 23.0F, -8.0F);
        this.BaseII.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.TopII = new ModelRenderer(this, 94, 30);
        this.TopII.setRotationPoint(7.0F, 8.0F, -8.0F);
        this.TopII.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.TopIII = new ModelRenderer(this, 60, 25);
        this.TopIII.setRotationPoint(-7.5F, 8.0F, 7.0F);
        this.TopIII.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.ColumnII = new ModelRenderer(this, 5, 30);
        this.ColumnII.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.ColumnII.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.ColumnIV = new ModelRenderer(this, 15, 30);
        this.ColumnIV.setRotationPoint(-8.0F, 9.0F, 7.0F);
        this.ColumnIV.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.ColumnI = new ModelRenderer(this, 0, 30);
        this.ColumnI.setRotationPoint(7.0F, 9.0F, -8.0F);
        this.ColumnI.addBox(0.0F, 0.0F, 0.0F, 1, 15, 1, 0.0F);
        this.BaseI = new ModelRenderer(this, 60, 0);
        this.BaseI.setRotationPoint(-8.0F, 23.0F, -8.0F);
        this.BaseI.addBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F);
        this.TopIV = new ModelRenderer(this, 94, 25);
        this.TopIV.setRotationPoint(-7.5F, 8.0F, -8.0F);
        this.TopIV.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
        this.BaseIV = new ModelRenderer(this, 94, 20);
        this.BaseIV.setRotationPoint(-7.5F, 23.0F, 7.0F);
        this.BaseIV.addBox(0.0F, 0.0F, 0.0F, 15, 1, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Cube.render(f5);
        this.BaseIII.render(f5);
        this.ColumnIII.render(f5);
        this.TopI.render(f5);
        this.BaseII.render(f5);
        this.TopII.render(f5);
        this.TopIII.render(f5);
        this.ColumnII.render(f5);
        this.ColumnIV.render(f5);
        this.ColumnI.render(f5);
        this.BaseI.render(f5);
        this.TopIV.render(f5);
        this.BaseIV.render(f5);
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
