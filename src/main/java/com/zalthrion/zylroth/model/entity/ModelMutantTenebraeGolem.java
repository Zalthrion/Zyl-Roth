package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/** TenebraeGolem - Zalthrion Created using Tabula 4.1.0 */
public class ModelMutantTenebraeGolem extends ModelBase {
	public ModelRenderer Head;
	public ModelRenderer RightArmConnection;
	public ModelRenderer LeftArmConnection;
	public ModelRenderer TopBody;
	public ModelRenderer BottomBody;
	public ModelRenderer TopRightArm;
	public ModelRenderer BottomRightArm;
	public ModelRenderer TopLeftArm;
	public ModelRenderer BottomLeftArm;
	public ModelRenderer TopRightLeg;
	public ModelRenderer BottomRightLeg;
	public ModelRenderer TopLeftLeg;
	public ModelRenderer BottomLeftLeg;
	
	public ModelMutantTenebraeGolem() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.BottomLeftLeg = new ModelRenderer(this, 2, 48);
		this.BottomLeftLeg.setRotationPoint(-10.0F, 14.0F, -5.0F);
		this.BottomLeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 10, 5, 0.0F);
		this.BottomLeftArm = new ModelRenderer(this, 1, 2);
		this.BottomLeftArm.setRotationPoint(-18.0F, -1.0F, 1.3F);
		this.BottomLeftArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 7, 0.0F);
		this.setRotateAngle(BottomLeftArm, -0.5059709501531561F, 0.0F, 0.0F);
		this.LeftArmConnection = new ModelRenderer(this, 6, 28);
		this.LeftArmConnection.setRotationPoint(-15.0F, -9.0F, -0.5F);
		this.LeftArmConnection.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(LeftArmConnection, 2.275909344600606F, 0.0F, 0.0F);
		this.TopBody = new ModelRenderer(this, 64, 37);
		this.TopBody.setRotationPoint(-10.0F, -14.6F, -5.0F);
		this.TopBody.addBox(0.0F, 0.0F, 0.0F, 20, 15, 10, 0.0F);
		this.setRotateAngle(TopBody, 0.136659280431156F, 0.0F, 0.0F);
		this.BottomRightArm = new ModelRenderer(this, 1, 2);
		this.BottomRightArm.setRotationPoint(12.0F, -1.0F, 1.3F);
		this.BottomRightArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 7, 0.0F);
		this.setRotateAngle(BottomRightArm, -0.5059709501531561F, 0.0F, 0.0F);
		this.BottomBody = new ModelRenderer(this, 26, 38);
		this.BottomBody.setRotationPoint(-5.0F, -5.0F, -3.1F);
		this.BottomBody.addBox(0.0F, 0.0F, 0.0F, 10, 16, 8, 0.0F);
		this.setRotateAngle(BottomBody, -0.22759093446006054F, 0.0F, 0.0F);
		this.TopLeftLeg = new ModelRenderer(this, 2, 34);
		this.TopLeftLeg.setRotationPoint(-10.0F, 6.4F, -2.5F);
		this.TopLeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 8, 5, 0.0F);
		this.setRotateAngle(TopLeftLeg, -0.317649923862968F, 0.0F, 0.0F);
		this.TopRightLeg = new ModelRenderer(this, 2, 34);
		this.TopRightLeg.setRotationPoint(4.0F, 6.4F, -2.5F);
		this.TopRightLeg.addBox(0.0F, 0.0F, 0.0F, 6, 8, 5, 0.0F);
		this.setRotateAngle(TopRightLeg, -0.31904618726456346F, 0.0F, 0.0F);
		this.TopRightArm = new ModelRenderer(this, 31, 8);
		this.TopRightArm.setRotationPoint(12.0F, -15.5F, -3.9F);
		this.TopRightArm.addBox(0.0F, 0.0F, 0.0F, 6, 20, 7, 0.0F);
		this.setRotateAngle(TopRightArm, 0.22759093446006054F, 0.0F, 0.0F);
		this.BottomRightLeg = new ModelRenderer(this, 2, 48);
		this.BottomRightLeg.setRotationPoint(4.0F, 14.0F, -5.0F);
		this.BottomRightLeg.addBox(0.0F, 0.0F, 0.0F, 6, 10, 5, 0.0F);
		this.RightArmConnection = new ModelRenderer(this, 6, 28);
		this.RightArmConnection.setRotationPoint(10.0F, -9.0F, -0.5F);
		this.RightArmConnection.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(RightArmConnection, 2.275909344600606F, 0.0F, 0.0F);
		this.TopLeftArm = new ModelRenderer(this, 31, 8);
		this.TopLeftArm.setRotationPoint(-18.0F, -15.5F, -3.9F);
		this.TopLeftArm.addBox(0.0F, 0.0F, 0.0F, 6, 20, 7, 0.0F);
		this.setRotateAngle(TopLeftArm, 0.22759093446006054F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 60, 18);
		this.Head.setRotationPoint(-3.5F, -23.7F, -4.7F);
		this.Head.addBox(0.0F, 0.0F, 0.0F, 7, 9, 7, 0.0F);
		this.setRotateAngle(Head, 0.136659280431156F, 0.0F, 0.0F);
	}
	
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.BottomLeftLeg.render(f5);
		this.BottomLeftArm.render(f5);
		this.LeftArmConnection.render(f5);
		this.TopBody.render(f5);
		this.BottomRightArm.render(f5);
		this.BottomBody.render(f5);
		this.TopLeftLeg.render(f5);
		this.TopRightLeg.render(f5);
		this.TopRightArm.render(f5);
		this.BottomRightLeg.render(f5);
		this.RightArmConnection.render(f5);
		this.TopLeftArm.render(f5);
		this.Head.render(f5);
	}
	
	/** This is a helper function from Tabula to set the rotation of model parts */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
