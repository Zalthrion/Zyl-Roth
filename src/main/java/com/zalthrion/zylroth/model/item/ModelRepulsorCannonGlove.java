package com.zalthrion.zylroth.model.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Repulsor Cannon (+ModelBiped) V2 - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelRepulsorCannonGlove extends ModelBiped {
    public ModelRenderer LeftArmGloveBase;
    public ModelRenderer LeftArmGloveProp;
    public ModelRenderer LeftArmGloveBorders;

    public ModelRepulsorCannonGlove() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.LeftArmGloveProp = new ModelRenderer(this, 71, 4);
        this.LeftArmGloveProp.mirror = true;
        this.LeftArmGloveProp.setRotationPoint(0.5F, 3.35F, 0.5F);
        this.LeftArmGloveProp.addBox(-1.0F, -2.0F, -2.0F, 4, 1, 4, 0.0F);
        this.LeftArmGloveBase = new ModelRenderer(this, 69, 20);
        this.LeftArmGloveBase.mirror = true;
        this.LeftArmGloveBase.setRotationPoint(-0.5F, 10.5F, -0.5F);
        this.LeftArmGloveBase.addBox(-1.0F, -2.0F, -2.0F, 5, 4, 5, 0.0F);
        this.LeftArmGloveBorders = new ModelRenderer(this, 67, 11);
        this.LeftArmGloveBorders.mirror = true;
        this.LeftArmGloveBorders.setRotationPoint(-1.5F, -2.7F, -2.5F);
        this.LeftArmGloveBorders.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.LeftArmGloveBase.addChild(this.LeftArmGloveProp);
        this.bipedLeftArm.addChild(this.LeftArmGloveBase);
        this.LeftArmGloveBase.addChild(this.LeftArmGloveBorders);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	this.LeftArmGloveBase.render(f5);
    }
    
    public void render(float f5) { 
    	this.LeftArmGloveBase.render(f5);
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
