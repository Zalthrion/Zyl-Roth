package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Gold Bag - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelGoldBag extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;
    public ModelRenderer shape1_6;
    public ModelRenderer shape1_7;
    public ModelRenderer shape1_8;
    public ModelRenderer shape1_9;

    public ModelGoldBag() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1_6 = new ModelRenderer(this, 27, 24);
        this.shape1_6.setRotationPoint(0.5F, -1.4F, 0.5F);
        this.shape1_6.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1, 0.0F);
        this.shape1_5 = new ModelRenderer(this, 1, 20);
        this.shape1_5.setRotationPoint(1.5F, -1.0F, 1.5F);
        this.shape1_5.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 47, 0);
        this.shape1_3.setRotationPoint(9.0F, 1.0F, 1.0F);
        this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 30, 0);
        this.shape1_2.setRotationPoint(1.0F, 1.0F, 9.0F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 7, 7, 1, 0.0F);
        this.shape1_9 = new ModelRenderer(this, 47, 18);
        this.shape1_9.setRotationPoint(0.5F, -1.4F, 1.0F);
        this.shape1_9.addBox(0.0F, 0.0F, 0.0F, 1, 2, 7, 0.0F);
        this.shape1_7 = new ModelRenderer(this, 27, 24);
        this.shape1_7.setRotationPoint(0.5F, -1.4F, 7.5F);
        this.shape1_7.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1, 0.0F);
        this.shape1_4 = new ModelRenderer(this, 30, 0);
        this.shape1_4.setRotationPoint(1.0F, 1.0F, -1.0F);
        this.shape1_4.addBox(0.0F, 0.0F, 0.0F, 7, 7, 1, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 47, 0);
        this.shape1_1.setRotationPoint(-1.0F, 1.0F, 1.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-4.5F, 15.0F, -4.5F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 9, 9, 9, 0.0F);
        this.shape1_8 = new ModelRenderer(this, 47, 18);
        this.shape1_8.setRotationPoint(7.5F, -1.4F, 1.0F);
        this.shape1_8.addBox(0.0F, 0.0F, 0.0F, 1, 2, 7, 0.0F);
        this.shape1.addChild(this.shape1_6);
        this.shape1.addChild(this.shape1_5);
        this.shape1.addChild(this.shape1_3);
        this.shape1.addChild(this.shape1_2);
        this.shape1.addChild(this.shape1_9);
        this.shape1.addChild(this.shape1_7);
        this.shape1.addChild(this.shape1_4);
        this.shape1.addChild(this.shape1_1);
        this.shape1.addChild(this.shape1_8);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
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