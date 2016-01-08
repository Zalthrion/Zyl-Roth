package com.zalthrion.zylroth.model.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

/**
 * Void Lord Armor - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelVoidLordArmor extends ModelBiped {
    public ModelRenderer RightLegArmor1;
    public ModelRenderer RightLegArmor2;
    public ModelRenderer RightLegArmor3;
    public ModelRenderer RightBootsArmor1;
    public ModelRenderer RightBootsArmor2;
    public ModelRenderer RightBootsArmor3;
    public ModelRenderer RightShoulderpadBase;
    public ModelRenderer RightShoulderpadBorder1;
    public ModelRenderer RightShoulderpadBorder2;
    public ModelRenderer RightShoulderpadBorder3;
    public ModelRenderer RightArmArmor3;
    public ModelRenderer RightArmArmor1;
    public ModelRenderer RightArmArmor4;
    public ModelRenderer RightArmArmor2;
    public ModelRenderer ChestplateFront;
    public ModelRenderer ChestplateBack;
    public ModelRenderer LeftLegArmor1;
    public ModelRenderer LeftLegArmor2;
    public ModelRenderer LeftLegArmor3;
    public ModelRenderer LeftBootsArmor1;
    public ModelRenderer LeftBootsArmor2;
    public ModelRenderer LeftBootsArmor3;
    public ModelRenderer LeftShoulderpadBase;
    public ModelRenderer LeftShoulderpadBorder1;
    public ModelRenderer LeftShoulderpadBorder2;
    public ModelRenderer LeftShoulderpadBorder3;
    public ModelRenderer LeftArmArmor3;
    public ModelRenderer LeftArmArmor1;
    public ModelRenderer LeftArmArmor2;
    public ModelRenderer LeftArmArmor4;
    public ModelRenderer Helmet;
    public ModelRenderer LeftBottomHornBase;
    public ModelRenderer LeftTopHorn;
    public ModelRenderer RightBottomHorn;
    public ModelRenderer RightTopHorn;
    public ModelRenderer HelmetBackground;
    public ModelRenderer LeftBottomHorn;
    public ModelRenderer RightBottomHornBase;

    public ModelVoidLordArmor() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        
        this.LeftLegArmor1 = new ModelRenderer(this, 18, 28);
        this.LeftLegArmor1.setRotationPoint(0.5F, 2.0F, -1.0F);
        this.LeftLegArmor1.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 1, 0.0F);
        
        this.RightShoulderpadBorder1 = new ModelRenderer(this, 48, 27);
        this.RightShoulderpadBorder1.setRotationPoint(-1.0F, -0.4F, -0.9F);
        this.RightShoulderpadBorder1.addBox(-3.0F, -2.0F, -2.0F, 5, 6, 2, 0.0F);
        this.setRotateAngle(RightShoulderpadBorder1, -0.3782128489071712F, 0.0F, 0.0F);
        
        this.RightArmArmor2 = new ModelRenderer(this, 68, 26);
        this.RightArmArmor2.setRotationPoint(-2.0F, 4.0F, 0.5F);
        this.RightArmArmor2.addBox(-2.0F, 0.0F, -2.0F, 1, 4, 3, 0.0F);
        
        this.RightShoulderpadBorder3 = new ModelRenderer(this, 48, 27);
        this.RightShoulderpadBorder3.setRotationPoint(-1.0F, -1.15F, 2.77F);
        this.RightShoulderpadBorder3.addBox(-3.0F, -2.0F, -2.0F, 5, 6, 2, 0.0F);
        this.setRotateAngle(RightShoulderpadBorder3, 0.3956661414271145F, 0.0F, 0.0F);
        
        this.RightBottomHorn = new ModelRenderer(this, 10, 8);
        this.RightBottomHorn.setRotationPoint(-7.5F, -5.93F, -0.5F);
        this.RightBottomHorn.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(RightBottomHorn, 0.0F, 0.0F, 0.1785471824790199F);
        
        this.LeftArmArmor2 = new ModelRenderer(this, 68, 26);
        this.LeftArmArmor2.setRotationPoint(5.0F, 4.0F, 0.5F);
        this.LeftArmArmor2.addBox(-2.0F, 0.0F, -2.0F, 1, 4, 3, 0.0F);
        
        this.ChestplateBack = new ModelRenderer(this, 8, 14);
        this.ChestplateBack.setRotationPoint(1.0F, 1.4F, 3.5F);
        this.ChestplateBack.addBox(-4.0F, 0.0F, -2.0F, 6, 9, 2, 0.0F);
        
        this.LeftBottomHorn = new ModelRenderer(this, 10, 8);
        this.LeftBottomHorn.setRotationPoint(5.5F, -5.3F, -0.5F);
        this.LeftBottomHorn.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(LeftBottomHorn, 0.0F, 0.0F, -0.1785471824790199F);
        
        this.LeftArmArmor1 = new ModelRenderer(this, 78, 28);
        this.LeftArmArmor1.setRotationPoint(1.5F, 4.0F, -1.0F);
        this.LeftArmArmor1.addBox(-2.0F, 0.0F, -2.0F, 3, 4, 1, 0.0F);
        
        this.LeftLegArmor3 = new ModelRenderer(this, 18, 28);
        this.LeftLegArmor3.setRotationPoint(0.5F, 2.0F, 4.0F);
        this.LeftLegArmor3.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 1, 0.0F);
        
        this.LeftShoulderpadBorder1 = new ModelRenderer(this, 48, 27);
        this.LeftShoulderpadBorder1.setRotationPoint(2.0F, -0.4F, -0.88F);
        this.LeftShoulderpadBorder1.addBox(-3.0F, -2.0F, -2.0F, 5, 6, 2, 0.0F);
        this.setRotateAngle(LeftShoulderpadBorder1, -0.3782128489071712F, 0.0F, 0.0F);
        
        this.LeftBootsArmor2 = new ModelRenderer(this, 5, 35);
        this.LeftBootsArmor2.setRotationPoint(4.0F, 8.0F, 0.5F);
        this.LeftBootsArmor2.addBox(-2.0F, 0.0F, -2.0F, 1, 3, 3, 0.0F);
        
        this.Helmet = new ModelRenderer(this, 27, 1);
        this.Helmet.setRotationPoint(-0.5F, -0.5F, -0.5F);
        this.Helmet.addBox(-4.0F, -8.0F, -4.0F, 9, 9, 9, 0.0F);
        
        this.RightBootsArmor1 = new ModelRenderer(this, 18, 37);
        this.RightBootsArmor1.setRotationPoint(0.5F, 8.0F, -1.0F);
        this.RightBootsArmor1.addBox(-2.0F, 0.0F, -2.0F, 3, 3, 1, 0.0F);
        
        this.RightBootsArmor2 = new ModelRenderer(this, 5, 35);
        this.RightBootsArmor2.setRotationPoint(-1.0F, 8.0F, 0.5F);
        this.RightBootsArmor2.addBox(-2.0F, 0.0F, -2.0F, 1, 3, 3, 0.0F);
        
        this.LeftArmArmor4 = new ModelRenderer(this, 68, 26);
        this.LeftArmArmor4.setRotationPoint(0.0F, 4.0F, 0.5F);
        this.LeftArmArmor4.addBox(-2.0F, 0.0F, -2.0F, 1, 4, 3, 0.0F);
        
        this.RightBottomHornBase = new ModelRenderer(this, 68, 8);
        this.RightBottomHornBase.setRotationPoint(-5.5F, -6.02F, -1.0F);
        this.RightBottomHornBase.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(RightBottomHornBase, 0.0F, 0.0F, 0.1785471824790199F);
        
        this.RightLegArmor2 = new ModelRenderer(this, 5, 26);
        this.RightLegArmor2.setRotationPoint(-1.0F, 2.0F, 0.5F);
        this.RightLegArmor2.addBox(-2.0F, 0.0F, -2.0F, 1, 5, 3, 0.0F);
        
        this.RightLegArmor3 = new ModelRenderer(this, 18, 28);
        this.RightLegArmor3.setRotationPoint(0.5F, 2.0F, 4.0F);
        this.RightLegArmor3.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 1, 0.0F);
        
        this.RightShoulderpadBorder2 = new ModelRenderer(this, 32, 25);
        this.RightShoulderpadBorder2.setRotationPoint(-1.95F, -0.03F, 0.0F);
        this.RightShoulderpadBorder2.addBox(-3.0F, -2.0F, -2.0F, 2, 6, 4, 0.0F);
        this.setRotateAngle(RightShoulderpadBorder2, 0.0F, 0.0F, 0.3782128489071712F);
        
        this.LeftBootsArmor1 = new ModelRenderer(this, 18, 37);
        this.LeftBootsArmor1.setRotationPoint(0.5F, 8.0F, -1.0F);
        this.LeftBootsArmor1.addBox(-2.0F, 0.0F, -2.0F, 3, 3, 1, 0.0F);
        
        this.RightArmArmor4 = new ModelRenderer(this, 68, 26);
        this.RightArmArmor4.setRotationPoint(3.0F, 4.0F, 0.5F);
        this.RightArmArmor4.addBox(-2.0F, 0.0F, -2.0F, 1, 4, 3, 0.0F);
        
        this.RightArmArmor1 = new ModelRenderer(this, 78, 28);
        this.RightArmArmor1.setRotationPoint(-0.5F, 4.0F, -1.0F);
        this.RightArmArmor1.addBox(-2.0F, 0.0F, -2.0F, 3, 4, 1, 0.0F);
        
        this.HelmetBackground = new ModelRenderer(this, 5, 43);
        this.HelmetBackground.setRotationPoint(0.5F, 0.5F, 0.5F);
        this.HelmetBackground.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        
        this.RightBootsArmor3 = new ModelRenderer(this, 18, 37);
        this.RightBootsArmor3.setRotationPoint(0.5F, 8.0F, 4.0F);
        this.RightBootsArmor3.addBox(-2.0F, 0.0F, -2.0F, 3, 3, 1, 0.0F);
        
        this.RightArmArmor3 = new ModelRenderer(this, 78, 28);
        this.RightArmArmor3.setRotationPoint(-0.5F, 4.0F, 4.0F);
        this.RightArmArmor3.addBox(-2.0F, 0.0F, -2.0F, 3, 4, 1, 0.0F);
        
        this.LeftLegArmor2 = new ModelRenderer(this, 5, 26);
        this.LeftLegArmor2.setRotationPoint(4.0F, 2.0F, 0.5F);
        this.LeftLegArmor2.addBox(-2.0F, 0.0F, -2.0F, 1, 5, 3, 0.0F);
        
        this.RightTopHorn = new ModelRenderer(this, 23, 2);
        this.RightTopHorn.setRotationPoint(-8.6F, -8.94F, -0.5F);
        this.RightTopHorn.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(RightTopHorn, 0.0F, 0.0F, -0.1308996938995747F);
        
        this.RightLegArmor1 = new ModelRenderer(this, 18, 28);
        this.RightLegArmor1.setRotationPoint(0.5F, 2.0F, -1.0F);
        this.RightLegArmor1.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 1, 0.0F);
        
        this.RightShoulderpadBase = new ModelRenderer(this, 40, 40);
        this.RightShoulderpadBase.setRotationPoint(-1.0F, -1.0F, 0.0F);
        this.RightShoulderpadBase.addBox(-3.0F, -2.0F, -2.0F, 5, 1, 4, 0.0F);
        
        this.ChestplateFront = new ModelRenderer(this, 8, 14);
        this.ChestplateFront.setRotationPoint(1.0F, 1.4F, -1.5F);
        this.ChestplateFront.addBox(-4.0F, 0.0F, -2.0F, 6, 9, 2, 0.0F);
        
        this.LeftBootsArmor3 = new ModelRenderer(this, 18, 28);
        this.LeftBootsArmor3.setRotationPoint(0.5F, 8.0F, 4.0F);
        this.LeftBootsArmor3.addBox(-2.0F, 0.0F, -2.0F, 3, 3, 1, 0.0F);
        
        this.LeftShoulderpadBorder2 = new ModelRenderer(this, 32, 25);
        this.LeftShoulderpadBorder2.setRotationPoint(5.67F, -1.51F, 0.0F);
        this.LeftShoulderpadBorder2.addBox(-3.0F, -2.0F, -2.0F, 2, 6, 4, 0.0F);
        this.setRotateAngle(LeftShoulderpadBorder2, 0.0F, 0.0F, -0.3782128489071712F);
        
        this.LeftBottomHornBase = new ModelRenderer(this, 68, 8);
        this.LeftBottomHornBase.setRotationPoint(4.5F, -5.6F, -1.0F);
        this.LeftBottomHornBase.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(LeftBottomHornBase, 0.0F, 0.0F, -0.1785471824790199F);
        
        this.LeftShoulderpadBase = new ModelRenderer(this, 40, 40);
        this.LeftShoulderpadBase.setRotationPoint(2.0F, -1.0F, 0.0F);
        this.LeftShoulderpadBase.addBox(-3.0F, -2.0F, -2.0F, 5, 1, 4, 0.0F);
        
        this.LeftTopHorn = new ModelRenderer(this, 23, 2);
        this.LeftTopHorn.setRotationPoint(7.6F, -9.1F, -0.5F);
        this.LeftTopHorn.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(LeftTopHorn, 0.0F, 0.0F, 0.1308996938995747F);
        
        this.LeftShoulderpadBorder3 = new ModelRenderer(this, 48, 27);
        this.LeftShoulderpadBorder3.setRotationPoint(2.0F, -1.15F, 2.78F);
        this.LeftShoulderpadBorder3.addBox(-3.0F, -2.0F, -2.0F, 5, 6, 2, 0.0F);
        this.setRotateAngle(LeftShoulderpadBorder3, 0.3956661414271145F, 0.0F, 0.0F);
        
        this.LeftArmArmor3 = new ModelRenderer(this, 78, 28);
        this.LeftArmArmor3.setRotationPoint(1.5F, 4.0F, 4.0F);
        this.LeftArmArmor3.addBox(-2.0F, 0.0F, -2.0F, 3, 4, 1, 0.0F);
        
        this.bipedLeftLeg.addChild(this.LeftLegArmor1);
        this.bipedRightArm.addChild(this.RightShoulderpadBorder1);
        this.bipedRightArm.addChild(this.RightArmArmor2);
        this.bipedRightArm.addChild(this.RightShoulderpadBorder3);
        this.Helmet.addChild(this.RightBottomHorn);
        this.bipedLeftArm.addChild(this.LeftArmArmor2);
        this.bipedBody.addChild(this.ChestplateBack);
        this.Helmet.addChild(this.LeftBottomHorn);
        this.bipedLeftArm.addChild(this.LeftArmArmor1);
        this.bipedLeftLeg.addChild(this.LeftLegArmor3);
        this.bipedLeftArm.addChild(this.LeftShoulderpadBorder1);
        this.bipedLeftLeg.addChild(this.LeftBootsArmor2);
        this.bipedHead.addChild(this.Helmet);
        this.bipedRightLeg.addChild(this.RightBootsArmor1);
        this.bipedRightLeg.addChild(this.RightBootsArmor2);
        this.bipedLeftArm.addChild(this.LeftArmArmor4);
        this.Helmet.addChild(this.RightBottomHornBase);
        this.bipedRightLeg.addChild(this.RightLegArmor2);
        this.bipedRightLeg.addChild(this.RightLegArmor3);
        this.bipedRightArm.addChild(this.RightShoulderpadBorder2);
        this.bipedLeftLeg.addChild(this.LeftBootsArmor1);
        this.bipedRightArm.addChild(this.RightArmArmor4);
        this.bipedRightArm.addChild(this.RightArmArmor1);
        this.Helmet.addChild(this.HelmetBackground);
        this.bipedRightLeg.addChild(this.RightBootsArmor3);
        this.bipedRightArm.addChild(this.RightArmArmor3);
        this.bipedLeftLeg.addChild(this.LeftLegArmor2);
        this.Helmet.addChild(this.RightTopHorn);
        this.bipedRightLeg.addChild(this.RightLegArmor1);
        this.bipedRightArm.addChild(this.RightShoulderpadBase);
        this.bipedBody.addChild(this.ChestplateFront);
        this.bipedLeftLeg.addChild(this.LeftBootsArmor3);
        this.bipedLeftArm.addChild(this.LeftShoulderpadBorder2);
        this.Helmet.addChild(this.LeftBottomHornBase);
        this.bipedLeftArm.addChild(this.LeftShoulderpadBase);
        this.Helmet.addChild(this.LeftTopHorn);
        this.bipedLeftArm.addChild(this.LeftShoulderpadBorder3);
        this.bipedLeftArm.addChild(this.LeftArmArmor3);
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
