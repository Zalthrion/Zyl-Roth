package com.zalthrion.zylroth.model.item;

import com.zalthrion.zylroth.item.tools.others.RepulsorCannon;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Repulsor Cannon (+ModelBiped) V2 - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelRepulsorCannon extends ModelBiped {
    public ModelRenderer RepulsorBase;
    public ModelRenderer RepulsorCover;
    public ModelRenderer RepulsorOutside;
    public ModelRenderer TopBorder;
    public ModelRenderer BottomBorder;
    public ModelRenderer RightBorder;
    public ModelRenderer LeftBorder;
    public ModelRenderer DisableButton;
    public ModelRenderer PropButtonLeft;
    public ModelRenderer LaserModeButton;
    public ModelRenderer CannonModeButton;
    public ModelRenderer PropButtonRight;
    public ModelRenderer RepulsorInside;
    public ModelRenderer RightChannelerBase;
    public ModelRenderer RightChannelerTop;
    public ModelRenderer LeftChannelerBase;
    public ModelRenderer LeftChannelerTop;
    public ModelRenderer CelestiumEnergyCore;

    public ModelRepulsorCannon() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.RightChannelerBase = new ModelRenderer(this, 38, 34);
        this.RightChannelerBase.setRotationPoint(-0.49F, 0.52F, 1.0F);
        this.RightChannelerBase.addBox(-3.0F, -2.0F, -2.0F, 1, 1, 1, 0.0F);
        this.RepulsorBase = new ModelRenderer(this, 42, 3);
        this.RepulsorBase.setRotationPoint(-0.5F, 8.5F, -0.5F);
        this.RepulsorBase.addBox(-3.0F, -2.0F, -2.0F, 5, 7, 5, 0.0F);
        this.RightBorder = new ModelRenderer(this, 30, 26);
        this.RightBorder.setRotationPoint(0.5F, 7.0F, 1.5F);
        this.RightBorder.addBox(-3.0F, -2.0F, -2.0F, 1, 1, 2, 0.0F);
        this.BottomBorder = new ModelRenderer(this, 28, 23);
        this.BottomBorder.setRotationPoint(0.5F, 7.0F, 3.5F);
        this.BottomBorder.addBox(-3.0F, -2.0F, -2.0F, 4, 1, 1, 0.0F);
        this.LeftChannelerBase = new ModelRenderer(this, 38, 34);
        this.LeftChannelerBase.setRotationPoint(2.49F, 0.51F, 1.09F);
        this.LeftChannelerBase.addBox(-3.0F, -2.0F, -2.0F, 1, 1, 1, 0.0F);
        this.PropButtonRight = new ModelRenderer(this, 9, 20);
        this.PropButtonRight.setRotationPoint(-2.0F, 2.7F, -2.1F);
        this.PropButtonRight.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.CannonModeButton = new ModelRenderer(this, 40, 18);
        this.CannonModeButton.setRotationPoint(-0.7F, -0.8F, -2.1F);
        this.CannonModeButton.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.DisableButton = new ModelRenderer(this, 18, 25);
        this.DisableButton.setRotationPoint(-3.1F, -0.5F, -1.0F);
        this.DisableButton.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.RightChannelerTop = new ModelRenderer(this, 31, 35);
        this.RightChannelerTop.setRotationPoint(0.12F, -0.48F, 1.0F);
        this.RightChannelerTop.addBox(-3.0F, -2.0F, -2.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(RightChannelerTop, 0.0F, 0.0F, -0.5873032932960919F);
        this.LeftBorder = new ModelRenderer(this, 30, 26);
        this.LeftBorder.setRotationPoint(3.5F, 7.0F, 1.5F);
        this.LeftBorder.addBox(-3.0F, -2.0F, -2.0F, 1, 1, 2, 0.0F);
        this.LaserModeButton = new ModelRenderer(this, 34, 18);
        this.LaserModeButton.setRotationPoint(0.7F, -0.8F, -2.1F);
        this.LaserModeButton.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.PropButtonLeft = new ModelRenderer(this, 17, 18);
        this.PropButtonLeft.setRotationPoint(-2.35F, 0.0F, -2.1F);
        this.PropButtonLeft.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.RepulsorOutside = new ModelRenderer(this, 22, 12);
        this.RepulsorOutside.setRotationPoint(0.5F, 15.75F, 0.5F);
        this.RepulsorOutside.addBox(-3.0F, -2.0F, -2.0F, 3, 1, 3, 0.0F);
        this.CelestiumEnergyCore = new ModelRenderer(this, 14, 15);
        this.CelestiumEnergyCore.setRotationPoint(-2.0F, 1.1F, -1.0F);
        this.CelestiumEnergyCore.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.RepulsorCover = new ModelRenderer(this, 40, 17);
        this.RepulsorCover.setRotationPoint(-4.0F, 4.5F, -2.9F);
        this.RepulsorCover.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6, 0.0F);
        this.RepulsorInside = new ModelRenderer(this, 22, 7);
        this.RepulsorInside.setRotationPoint(1.0F, 6.85F, 1.0F);
        this.RepulsorInside.addBox(-3.0F, -2.0F, -2.0F, 3, 1, 3, 0.0F);
        this.LeftChannelerTop = new ModelRenderer(this, 31, 31);
        this.LeftChannelerTop.setRotationPoint(-0.34F, -1.04F, -0.9F);
        this.LeftChannelerTop.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(LeftChannelerTop, 0.0F, 0.0F, 0.5873032932960919F);
        this.TopBorder = new ModelRenderer(this, 28, 23);
        this.TopBorder.setRotationPoint(0.5F, 7.0F, 0.5F);
        this.TopBorder.addBox(-3.0F, -2.0F, -2.0F, 4, 1, 1, 0.0F);
        this.RepulsorOutside.addChild(this.RightChannelerBase);
        this.bipedRightArm.addChild(this.RepulsorBase);
        this.RepulsorBase.addChild(this.RightBorder);
        this.RepulsorBase.addChild(this.BottomBorder);
        this.RepulsorOutside.addChild(this.LeftChannelerBase);
        this.RepulsorBase.addChild(this.PropButtonRight);
        this.RepulsorBase.addChild(this.CannonModeButton);
        this.RepulsorBase.addChild(this.DisableButton);
        this.RepulsorOutside.addChild(this.RightChannelerTop);
        this.RepulsorBase.addChild(this.LeftBorder);
        this.RepulsorBase.addChild(this.LaserModeButton);
        this.RepulsorBase.addChild(this.PropButtonLeft);
        this.bipedRightArm.addChild(this.RepulsorOutside);
        this.RepulsorOutside.addChild(this.CelestiumEnergyCore);
        this.bipedRightArm.addChild(this.RepulsorCover);
        this.RepulsorBase.addChild(this.RepulsorInside);
        this.RepulsorOutside.addChild(this.LeftChannelerTop);
        this.RepulsorBase.addChild(this.TopBorder);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	RepulsorCannon repulsorCannon = new RepulsorCannon(0);
    	
        this.RepulsorBase.render(f5);
        this.RepulsorCover.render(f5);
        
        if(repulsorCannon.isOnCannonMode){
        	this.RepulsorOutside.render(f5);
        }
    }
    
    public void render(float f5) {
    	RepulsorCannon repulsorCannon = new RepulsorCannon(0);
    	
        this.RepulsorBase.render(f5);
        this.RepulsorCover.render(f5);
        
        if(repulsorCannon.isOnCannonMode){
        	this.RepulsorOutside.render(f5);
        }
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
