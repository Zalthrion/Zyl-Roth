package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelTuskarr3 - Zalthrion
 * Created using Tabula 4.1.1
 */
public class ModelTuskarr extends ModelBase {
    public ModelRenderer LeftShoulder;
    public ModelRenderer RightShoulder;
    public ModelRenderer LeftArm;
    public ModelRenderer LeftShoulderWool;
    public ModelRenderer RightArm;
    public ModelRenderer RightShoulderWool;
    public ModelRenderer Stomach;
    public ModelRenderer BodyFront;
    public ModelRenderer BodyBase;
    public ModelRenderer Belt;
    public ModelRenderer Pants;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer BodyTop;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer RightTusk;
    public ModelRenderer LeftTusk;
    public ModelRenderer RightBottomTusk;
    public ModelRenderer LeftBottomTusk;
    public ModelRenderer RightFeet;
    public ModelRenderer RightToe1;
    public ModelRenderer RightToe2;
    public ModelRenderer RightToe3;
    public ModelRenderer RightSandal;
    public ModelRenderer RightTopLeg;
    public ModelRenderer LeftFeet;
    public ModelRenderer LeftToe1;
    public ModelRenderer LeftToe2;
    public ModelRenderer LeftToe3;
    public ModelRenderer LeftSandal;
    public ModelRenderer LeftTopLeg;

    public ModelTuskarr() {
        this.textureWidth = 254;
        this.textureHeight = 128;
        this.LeftArm = new ModelRenderer(this, 62, 38);
        this.LeftArm.setRotationPoint(0.5F, 2.4F, 0.0F);
        this.LeftArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F);
        this.setRotateAngle(LeftArm, 0.0F, 0.0F, -0.40980330836826856F);
        this.RightBottomTusk = new ModelRenderer(this, 37, 117);
        this.RightBottomTusk.setRotationPoint(-2.8F, -7.800000000000025F, -5.9F);
        this.RightBottomTusk.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightBottomTusk, 0.27314402793711257F, 0.0F, 0.0F);
        this.LeftShoulderWool = new ModelRenderer(this, 183, 35);
        this.LeftShoulderWool.setRotationPoint(0.0F, -0.35F, -0.5F);
        this.LeftShoulderWool.addBox(0.0F, 0.0F, 0.0F, 2, 6, 7, 0.0F);
        this.RightToe2 = new ModelRenderer(this, 3, 8);
        this.RightToe2.setRotationPoint(3.0F, 5.0F, -1.9F);
        this.RightToe2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightToe2, 0.8628907821859966F, 0.0F, 0.0F);
        this.LeftTopLeg = new ModelRenderer(this, 48, 111);
        this.LeftTopLeg.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.LeftTopLeg.addBox(0.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F);
        this.BodyTop = new ModelRenderer(this, 75, 90);
        this.BodyTop.setRotationPoint(-8.8F, -10.00000000000001F, -4.0F);
        this.BodyTop.addBox(0.0F, 0.0F, 0.0F, 18, 3, 12, 0.0F);
        this.LeftToe2 = new ModelRenderer(this, 3, 8);
        this.LeftToe2.setRotationPoint(3.0F, 5.0F, -1.9F);
        this.LeftToe2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftToe2, 0.8628907821859966F, 0.0F, 0.0F);
        this.BodyFront = new ModelRenderer(this, 2, 12);
        this.BodyFront.setRotationPoint(-8.8F, 0.9999999999999974F, -6.0F);
        this.BodyFront.addBox(0.0F, 0.0F, 0.0F, 18, 4, 11, 0.0F);
        this.setRotateAngle(BodyFront, 1.3414600630828417F, 0.0F, 0.0F);
        this.LeftShoulder = new ModelRenderer(this, 85, 9);
        this.LeftShoulder.setRotationPoint(9.05F, -9.5F, -1.0F);
        this.LeftShoulder.addBox(0.0F, 0.0F, 0.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(LeftShoulder, 0.0F, 0.0F, 0.3113667385557884F);
        this.RightTusk = new ModelRenderer(this, 28, 115);
        this.RightTusk.setRotationPoint(-2.8F, -12.799999999999981F, -5.9F);
        this.RightTusk.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.LeftBottomTusk = new ModelRenderer(this, 37, 117);
        this.LeftBottomTusk.setRotationPoint(1.2F, -7.800000000000025F, -5.9F);
        this.LeftBottomTusk.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftBottomTusk, 0.27314402793711257F, 0.0F, 0.0F);
        this.RightToe1 = new ModelRenderer(this, 3, 8);
        this.RightToe1.setRotationPoint(0.5F, 5.0F, -1.9F);
        this.RightToe1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightToe1, 0.8628907821859966F, 0.0F, 0.0F);
        this.RightSandal = new ModelRenderer(this, 156, 17);
        this.RightSandal.setRotationPoint(-0.5F, 5.0F, -2.5F);
        this.RightSandal.addBox(0.0F, 0.0F, 0.0F, 9, 2, 11, 0.0F);
        this.LeftToe1 = new ModelRenderer(this, 3, 8);
        this.LeftToe1.setRotationPoint(0.5F, 5.0F, -1.9F);
        this.LeftToe1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftToe1, 0.8628907821859966F, 0.0F, 0.0F);
        this.RightFeet = new ModelRenderer(this, 20, 104);
        this.RightFeet.setRotationPoint(0.0F, 0.8F, 1.3F);
        this.RightFeet.addBox(0.0F, 0.0F, 0.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(RightFeet, -0.5848598323432997F, 0.0F, 0.0F);
        this.BodyBase = new ModelRenderer(this, 2, 32);
        this.BodyBase.setRotationPoint(-8.8F, -9.000000000000025F, -2.0F);
        this.BodyBase.addBox(0.0F, 0.0F, 0.0F, 18, 19, 10, 0.0F);
        this.LeftSandal = new ModelRenderer(this, 156, 17);
        this.LeftSandal.setRotationPoint(-0.5F, 5.0F, -2.5F);
        this.LeftSandal.addBox(0.0F, 0.0F, 0.0F, 9, 2, 11, 0.0F);
        this.LeftTusk = new ModelRenderer(this, 28, 115);
        this.LeftTusk.setRotationPoint(1.2F, -12.799999999999981F, -5.9F);
        this.LeftTusk.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
        this.RightLeg = new ModelRenderer(this, 48, 111);
        this.RightLeg.setRotationPoint(-8.8F, 17.0F, -3.0F);
        this.RightLeg.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8, 0.0F);
        this.RightTopLeg = new ModelRenderer(this, 15, 86);
        this.RightTopLeg.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.RightTopLeg.addBox(0.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F);
        this.Belt = new ModelRenderer(this, 4, 64);
        this.Belt.setRotationPoint(-9.8F, 7.999999999999995F, -7.0F);
        this.Belt.addBox(0.0F, 0.0F, 0.0F, 20, 3, 16, 0.0F);
        this.Pants = new ModelRenderer(this, 92, 38);
        this.Pants.setRotationPoint(-9.3F, 10.99999999999998F, -6.5F);
        this.Pants.addBox(0.0F, 0.0F, 0.0F, 19, 6, 15, 0.0F);
        this.Stomach = new ModelRenderer(this, 103, 20);
        this.Stomach.setRotationPoint(-8.8F, 0.9999999999999974F, -6.0F);
        this.Stomach.addBox(0.0F, 0.0F, 0.0F, 18, 9, 4, 0.0F);
        this.LeftFeet = new ModelRenderer(this, 20, 104);
        this.LeftFeet.setRotationPoint(0.0F, 0.8F, 1.3F);
        this.LeftFeet.addBox(0.0F, 0.0F, 0.0F, 8, 5, 2, 0.0F);
        this.setRotateAngle(LeftFeet, -0.5848598323432997F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 80, 61);
        this.Head.setRotationPoint(-6.3F, -19.999999999999943F, -4.5F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 13, 10, 12, 0.0F);
        this.RightShoulderWool = new ModelRenderer(this, 183, 35);
        this.RightShoulderWool.setRotationPoint(4.0F, -0.4F, -0.5F);
        this.RightShoulderWool.addBox(0.0F, 0.0F, 0.0F, 2, 6, 7, 0.0F);
        this.RightToe3 = new ModelRenderer(this, 3, 8);
        this.RightToe3.setRotationPoint(5.5F, 5.0F, -1.9F);
        this.RightToe3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(RightToe3, 0.8628907821859966F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 62, 38);
        this.RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 6, 0.0F);
        this.setRotateAngle(RightArm, 0.0F, 0.0F, 0.40980330836826856F);
        this.LeftLeg = new ModelRenderer(this, 15, 86);
        this.LeftLeg.setRotationPoint(1.2F, 16.99999999999999F, -3.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8, 0.0F);
        this.Snout = new ModelRenderer(this, 136, 73);
        this.Snout.setRotationPoint(-3.8F, -15.49999999999995F, -6.1F);
        this.Snout.addBox(0.0F, 0.0F, 0.0F, 8, 5, 3, 0.0F);
        this.RightShoulder = new ModelRenderer(this, 85, 9);
        this.RightShoulder.setRotationPoint(-14.55F, -7.5F, -1.0F);
        this.RightShoulder.addBox(0.0F, 0.0F, 0.0F, 6, 4, 6, 0.0F);
        this.setRotateAngle(RightShoulder, 0.0F, 0.0F, -0.3113667385557884F);
        this.LeftToe3 = new ModelRenderer(this, 3, 8);
        this.LeftToe3.setRotationPoint(5.5F, 5.0F, -1.9F);
        this.LeftToe3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(LeftToe3, 0.8628907821859966F, 0.0F, 0.0F);
        this.LeftShoulder.addChild(this.LeftArm);
        this.LeftShoulder.addChild(this.LeftShoulderWool);
        this.RightLeg.addChild(this.RightToe2);
        this.LeftLeg.addChild(this.LeftTopLeg);
        this.LeftLeg.addChild(this.LeftToe2);
        this.RightLeg.addChild(this.RightToe1);
        this.RightLeg.addChild(this.RightSandal);
        this.LeftLeg.addChild(this.LeftToe1);
        this.RightLeg.addChild(this.RightFeet);
        this.LeftLeg.addChild(this.LeftSandal);
        this.RightLeg.addChild(this.RightTopLeg);
        this.LeftLeg.addChild(this.LeftFeet);
        this.RightShoulder.addChild(this.RightShoulderWool);
        this.RightLeg.addChild(this.RightToe3);
        this.RightShoulder.addChild(this.RightArm);
        this.LeftLeg.addChild(this.LeftToe3);
    }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.BodyFront.render(f5);
		this.Belt.render(f5);
		this.LeftLeg.render(f5);
		this.LeftTusk.render(f5);
		this.BodyBase.render(f5);
		this.RightShoulder.render(f5);
		this.LeftShoulder.render(f5);
		this.Head.render(f5);
		this.RightLeg.render(f5);
		this.LeftBottomTusk.render(f5);
		this.Stomach.render(f5);
		this.RightTusk.render(f5);
		this.Snout.render(f5);
		this.BodyTop.render(f5);
		this.Pants.render(f5);
		this.RightBottomTusk.render(f5);
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		this.RightShoulder.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.1F * p_78087_2_ * 0.25F;
		this.LeftShoulder.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.1F * p_78087_2_ * 0.25F;
		this.RightShoulder.rotateAngleY = 0.0F;
		this.LeftShoulder.rotateAngleY = 0.0F;
		this.RightShoulder.rotateAngleZ = -0.3F;
		this.LeftShoulder.rotateAngleZ = 0.3F;
		this.RightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 0.4F * p_78087_2_;
		this.LeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 0.4F * p_78087_2_;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
	}
}
