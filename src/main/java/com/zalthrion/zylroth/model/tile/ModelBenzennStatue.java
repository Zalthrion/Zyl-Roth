package com.zalthrion.zylroth.model.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Benzenn Statue - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelBenzennStatue extends ModelBase {
    public ModelRenderer PedestalBottom;
    public ModelRenderer PedestalTop;
    public ModelRenderer Stomach;
    public ModelRenderer BodyFront;
    public ModelRenderer BodyBase;
    public ModelRenderer Belt;
    public ModelRenderer Pants;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFeet;
    public ModelRenderer RightFeet;
    public ModelRenderer LeftSandal;
    public ModelRenderer RightSandal;
    public ModelRenderer LeftToe1;
    public ModelRenderer LeftToe2;
    public ModelRenderer RightToe1;
    public ModelRenderer RightToe3;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftShoulder;
    public ModelRenderer RightShoulder;
    public ModelRenderer RightArm;
    public ModelRenderer BodyTop;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer RightTusk;
    public ModelRenderer LeftTusk;
    public ModelRenderer RightToe2;
    public ModelRenderer LeftToe3;
    public ModelRenderer RightBottomTusk;
    public ModelRenderer LeftBottomTusk;

    public ModelBenzennStatue() {
        this.textureWidth = 254;
        this.textureHeight = 128;
        this.LeftBottomTusk = new ModelRenderer(this, 37, 117);
        this.LeftBottomTusk.setRotationPoint(1.2F, -14.8F, -5.9F);
        this.LeftBottomTusk.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftBottomTusk, 0.27314402793711257F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 136, 73);
        this.Snout.setRotationPoint(-3.8F, -22.5F, -6.1F);
        this.Snout.addBox(0.0F, 0.0F, 0.0F, 8, 5, 3, 0.0F);
        this.RightBottomTusk = new ModelRenderer(this, 37, 117);
        this.RightBottomTusk.setRotationPoint(-2.8F, -14.8F, -5.9F);
        this.RightBottomTusk.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightBottomTusk, 0.27314402793711257F, 0.0F, 0.0F);
        this.LeftToe1 = new ModelRenderer(this, 3, 8);
        this.LeftToe1.setRotationPoint(1.7F, 15.04F, -4.94F);
        this.LeftToe1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftToe1, 0.8628907821859966F, 0.0F, 0.0F);
        this.RightTusk = new ModelRenderer(this, 28, 115);
        this.RightTusk.setRotationPoint(-2.8F, -19.8F, -5.9F);
        this.RightTusk.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.BodyBase = new ModelRenderer(this, 2, 32);
        this.BodyBase.setRotationPoint(-8.8F, -16.0F, -2.0F);
        this.BodyBase.addBox(0.0F, 0.0F, 0.0F, 18, 19, 10, 0.0F);
        this.RightLeg = new ModelRenderer(this, 15, 86);
        this.RightLeg.setRotationPoint(-8.8F, 10.0F, -3.0F);
        this.RightLeg.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8, 0.0F);
        this.RightFeet = new ModelRenderer(this, 20, 104);
        this.RightFeet.setRotationPoint(-8.8F, 10.84F, -1.74F);
        this.RightFeet.addBox(0.0F, 0.0F, 0.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(RightFeet, -0.5848598323432997F, 0.0F, 0.0F);
        this.Stomach = new ModelRenderer(this, 103, 20);
        this.Stomach.setRotationPoint(-8.8F, -6.0F, -6.0F);
        this.Stomach.addBox(0.0F, 0.0F, 0.0F, 18, 9, 4, 0.0F);
        this.PedestalBottom = new ModelRenderer(this, 150, 75);
        this.PedestalBottom.setRotationPoint(-11.0F, 20.0F, -11.0F);
        this.PedestalBottom.addBox(0.0F, 0.0F, 0.0F, 22, 4, 22, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 15, 86);
        this.LeftLeg.setRotationPoint(1.2F, 10.0F, -3.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8, 0.0F);
        this.LeftToe2 = new ModelRenderer(this, 3, 8);
        this.LeftToe2.setRotationPoint(4.2F, 15.04F, -4.94F);
        this.LeftToe2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftToe2, 0.8628907821859966F, 0.0F, 0.0F);
        this.LeftFeet = new ModelRenderer(this, 20, 104);
        this.LeftFeet.setRotationPoint(1.2F, 10.84F, -1.74F);
        this.LeftFeet.addBox(0.0F, 0.0F, 0.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(LeftFeet, -0.5848598323432997F, 0.0F, 0.0F);
        this.LeftSandal = new ModelRenderer(this, 156, 17);
        this.LeftSandal.setRotationPoint(0.7F, 15.0F, -5.5F);
        this.LeftSandal.addBox(0.0F, 0.0F, 0.0F, 9, 2, 11, 0.0F);
        this.RightArm = new ModelRenderer(this, 62, 38);
        this.RightArm.setRotationPoint(-14.57F, -14.9F, -1.0F);
        this.RightArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F);
        this.setRotateAngle(RightArm, 0.0F, 0.0F, 0.07016223593017204F);
        this.RightToe1 = new ModelRenderer(this, 3, 8);
        this.RightToe1.setRotationPoint(-8.3F, 15.04F, -4.94F);
        this.RightToe1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightToe1, 0.8628907821859966F, 0.0F, 0.0F);
        this.LeftShoulder = new ModelRenderer(this, 85, 9);
        this.LeftShoulder.setRotationPoint(9.05F, -16.9F, -1.0F);
        this.LeftShoulder.addBox(0.0F, 0.0F, 0.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(LeftShoulder, 0.0F, 0.0F, 0.3113667385557884F);
        this.RightShoulder = new ModelRenderer(this, 85, 9);
        this.RightShoulder.setRotationPoint(-14.55F, -14.9F, -1.0F);
        this.RightShoulder.addBox(0.0F, 0.0F, 0.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(RightShoulder, 0.0F, 0.0F, -0.3113667385557884F);
        this.RightSandal = new ModelRenderer(this, 156, 17);
        this.RightSandal.setRotationPoint(-9.3F, 15.0F, -5.5F);
        this.RightSandal.addBox(0.0F, 0.0F, 0.0F, 9, 2, 11, 0.0F);
        this.PedestalTop = new ModelRenderer(this, 155, 103);
        this.PedestalTop.setRotationPoint(-10.0F, 17.0F, -10.0F);
        this.PedestalTop.addBox(0.0F, 0.0F, 0.0F, 20, 3, 20, 0.0F);
        this.RightToe2 = new ModelRenderer(this, 3, 8);
        this.RightToe2.setRotationPoint(-5.8F, 15.04F, -4.94F);
        this.RightToe2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightToe2, 0.8628907821859966F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 80, 61);
        this.Head.setRotationPoint(-6.3F, -27.0F, -4.5F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 13, 10, 12, 0.0F);
        this.BodyTop = new ModelRenderer(this, 75, 90);
        this.BodyTop.setRotationPoint(-8.8F, -17.0F, -4.0F);
        this.BodyTop.addBox(0.0F, 0.0F, 0.0F, 18, 3, 12, 0.0F);
        this.LeftToe3 = new ModelRenderer(this, 3, 8);
        this.LeftToe3.setRotationPoint(6.7F, 15.04F, -4.94F);
        this.LeftToe3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftToe3, 0.8628907821859966F, 0.0F, 0.0F);
        this.Belt = new ModelRenderer(this, 4, 64);
        this.Belt.setRotationPoint(-9.8F, 1.0F, -7.0F);
        this.Belt.addBox(0.0F, 0.0F, 0.0F, 20, 3, 16, 0.0F);
        this.BodyFront = new ModelRenderer(this, 2, 12);
        this.BodyFront.setRotationPoint(-8.8F, -6.0F, -6.0F);
        this.BodyFront.addBox(0.0F, 0.0F, 0.0F, 18, 4, 11, 0.0F);
        this.setRotateAngle(BodyFront, 1.3414600630828417F, 0.0F, 0.0F);
        this.LeftTusk = new ModelRenderer(this, 28, 115);
        this.LeftTusk.setRotationPoint(1.2F, -19.8F, -5.9F);
        this.LeftTusk.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.Pants = new ModelRenderer(this, 92, 38);
        this.Pants.setRotationPoint(-9.3F, 4.0F, -6.5F);
        this.Pants.addBox(0.0F, 0.0F, 0.0F, 19, 6, 15, 0.0F);
        this.RightToe3 = new ModelRenderer(this, 3, 8);
        this.RightToe3.setRotationPoint(-3.3F, 15.04F, -4.94F);
        this.RightToe3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightToe3, 0.8628907821859966F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 62, 38);
        this.LeftArm.setRotationPoint(8.77F, -14.62F, -1.0F);
        this.LeftArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F);
        this.setRotateAngle(LeftArm, 0.0F, 0.0F, -0.07016223593017204F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LeftBottomTusk.render(f5);
        this.Snout.render(f5);
        this.RightBottomTusk.render(f5);
        this.LeftToe1.render(f5);
        this.RightTusk.render(f5);
        this.BodyBase.render(f5);
        this.RightLeg.render(f5);
        this.RightFeet.render(f5);
        this.Stomach.render(f5);
        this.PedestalBottom.render(f5);
        this.LeftLeg.render(f5);
        this.LeftToe2.render(f5);
        this.LeftFeet.render(f5);
        this.LeftSandal.render(f5);
        this.RightArm.render(f5);
        this.RightToe1.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.RightSandal.render(f5);
        this.PedestalTop.render(f5);
        this.RightToe2.render(f5);
        this.Head.render(f5);
        this.BodyTop.render(f5);
        this.LeftToe3.render(f5);
        this.Belt.render(f5);
        this.BodyFront.render(f5);
        this.LeftTusk.render(f5);
        this.Pants.render(f5);
        this.RightToe3.render(f5);
        this.LeftArm.render(f5);
    }
    
    public void render(float f5){
        this.LeftBottomTusk.render(f5);
        this.Snout.render(f5);
        this.RightBottomTusk.render(f5);
        this.LeftToe1.render(f5);
        this.RightTusk.render(f5);
        this.BodyBase.render(f5);
        this.RightLeg.render(f5);
        this.RightFeet.render(f5);
        this.Stomach.render(f5);
        this.PedestalBottom.render(f5);
        this.LeftLeg.render(f5);
        this.LeftToe2.render(f5);
        this.LeftFeet.render(f5);
        this.LeftSandal.render(f5);
        this.RightArm.render(f5);
        this.RightToe1.render(f5);
        this.LeftShoulder.render(f5);
        this.RightShoulder.render(f5);
        this.RightSandal.render(f5);
        this.PedestalTop.render(f5);
        this.RightToe2.render(f5);
        this.Head.render(f5);
        this.BodyTop.render(f5);
        this.LeftToe3.render(f5);
        this.Belt.render(f5);
        this.BodyFront.render(f5);
        this.LeftTusk.render(f5);
        this.Pants.render(f5);
        this.RightToe3.render(f5);
        this.LeftArm.render(f5);
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
