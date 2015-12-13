package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.entity.boss.EntityEmpoweredTenebraeGolem;

/** TenebraeGolem - Zalthrion Created using Tabula 4.1.0 */
@SideOnly(Side.CLIENT)
public class ModelEmpoweredTenebraeGolem extends ModelBase {
	
	public ModelRenderer TopRightArm;
	public ModelRenderer TopLeftArm;
	public ModelRenderer BottomRightArm;
	public ModelRenderer BottomLeftArm;
	public ModelRenderer Head;
	public ModelRenderer RightArmConnection;
	public ModelRenderer LeftArmConnection;
	public ModelRenderer TopBody;
	public ModelRenderer RightShoulderpad;
	public ModelRenderer TopLeftLeg;
	public ModelRenderer TopRightLeg;
	public ModelRenderer LeftShoulderpad;
	public ModelRenderer BottomBody;
	public ModelRenderer BottomLeftLeg;
	public ModelRenderer BottomRightLeg;
	
	public ModelEmpoweredTenebraeGolem() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.LeftArmConnection = new ModelRenderer(this, 6, 28);
		this.LeftArmConnection.setRotationPoint(-15.0F, -9.0F, -0.5F);
		this.LeftArmConnection.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(LeftArmConnection, 2.275909344600606F, 0.0F, 0.0F);
		this.TopRightLeg = new ModelRenderer(this, 2, 34);
		this.TopRightLeg.setRotationPoint(4.0F, 6.4F, -2.5F);
		this.TopRightLeg.addBox(0.0F, 0.0F, 0.0F, 6, 8, 5, 0.0F);
		this.setRotateAngle(TopRightLeg, -0.31904618726456346F, 0.0F, 0.0F);
		this.TopRightArm = new ModelRenderer(this, 31, 8);
		this.TopRightArm.setRotationPoint(-18.0F, -15.0F, -4.25F);
		this.TopRightArm.addBox(0.0F, 0.0F, 0.0F, 6, 20, 7, 0.0F);
		this.setRotateAngle(TopRightArm, 0.22759093446006054F, 0.0F, 0.0F);
		this.RightShoulderpad = new ModelRenderer(this, 90, 15);
		this.RightShoulderpad.mirror = true;
		this.RightShoulderpad.setRotationPoint(10.6F, -15.3F, -5.4F);
		this.RightShoulderpad.addBox(0.0F, 0.0F, 0.0F, 9, 9, 9, 0.0F);
		this.setRotateAngle(RightShoulderpad, 0.22759093446006054F, 0.0F, 0.0F);
		this.BottomRightArm = new ModelRenderer(this, 1, 2);
		this.BottomRightArm.setRotationPoint(0.0F, 16.4F, 0.9F);
		this.BottomRightArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 7, 0.0F);
		this.setRotateAngle(BottomRightArm, -0.5059709501531561F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 60, 18);
		this.Head.setRotationPoint(-3.5F, -23.7F, -4.7F);
		this.Head.addBox(0.0F, 0.0F, 0.0F, 7, 9, 7, 0.0F);
		this.setRotateAngle(Head, 0.136659280431156F, 0.0F, 0.0F);
		this.RightArmConnection = new ModelRenderer(this, 6, 28);
		this.RightArmConnection.setRotationPoint(10.0F, -9.0F, -0.5F);
		this.RightArmConnection.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(RightArmConnection, 2.275909344600606F, 0.0F, 0.0F);
		this.BottomBody = new ModelRenderer(this, 26, 38);
		this.BottomBody.setRotationPoint(5.0F, 10.0F, 1.8F);
		this.BottomBody.addBox(0.0F, 0.0F, 0.0F, 10, 16, 8, 0.0F);
		this.setRotateAngle(BottomBody, -0.26249751949994715F, 0.0F, 0.0F);
		this.BottomLeftArm = new ModelRenderer(this, 1, 2);
		this.BottomLeftArm.setRotationPoint(0.0F, 16.4F, 0.9F);
		this.BottomLeftArm.addBox(0.0F, 0.0F, 0.0F, 6, 16, 7, 0.0F);
		this.setRotateAngle(BottomLeftArm, -0.5059709501531561F, 0.0F, 0.0F);
		this.TopLeftLeg = new ModelRenderer(this, 2, 34);
		this.TopLeftLeg.setRotationPoint(-10.0F, 6.4F, -2.5F);
		this.TopLeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 8, 5, 0.0F);
		this.setRotateAngle(TopLeftLeg, -0.317649923862968F, 0.0F, 0.0F);
		this.BottomLeftLeg = new ModelRenderer(this, 2, 48);
		this.BottomLeftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.BottomLeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 10, 5, 0.0F);
		this.setRotateAngle(BottomLeftLeg, 0.3490658503988659F, 0.0F, 0.0F);
		this.TopLeftArm = new ModelRenderer(this, 31, 8);
		this.TopLeftArm.setRotationPoint(12.0F, -15.0F, -4.25F);
		this.TopLeftArm.addBox(0.0F, 0.0F, 0.0F, 6, 20, 7, 0.0F);
		this.setRotateAngle(TopLeftArm, 0.22759093446006054F, 0.0F, 0.0F);
		this.LeftShoulderpad = new ModelRenderer(this, 90, 15);
		this.LeftShoulderpad.setRotationPoint(-19.6F, -15.3F, -5.4F);
		this.LeftShoulderpad.addBox(0.0F, 0.0F, 0.0F, 9, 9, 9, 0.0F);
		this.setRotateAngle(LeftShoulderpad, 0.22759093446006054F, 0.0F, 0.0F);
		this.BottomRightLeg = new ModelRenderer(this, 2, 48);
		this.BottomRightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.BottomRightLeg.addBox(0.0F, 0.0F, 0.0F, 6, 10, 5, 0.0F);
		this.setRotateAngle(BottomRightLeg, 0.3490658503988659F, 0.0F, 0.0F);
		this.TopBody = new ModelRenderer(this, 64, 37);
		this.TopBody.setRotationPoint(-10.0F, -14.6F, -5.0F);
		this.TopBody.addBox(0.0F, 0.0F, 0.0F, 20, 15, 10, 0.0F);
		this.setRotateAngle(TopBody, 0.136659280431156F, 0.0F, 0.0F);
		this.TopRightArm.addChild(this.BottomRightArm);
		this.TopBody.addChild(this.BottomBody);
		this.TopLeftArm.addChild(this.BottomLeftArm);
		this.TopLeftLeg.addChild(this.BottomLeftLeg);
		this.TopRightLeg.addChild(this.BottomRightLeg);
	}
	
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		float scaleFactor = 2.5F;
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, 1.5F - 1.5F * scaleFactor, 0);
		GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		this.LeftArmConnection.render(f5);
		this.TopRightLeg.render(f5);
		this.TopRightArm.render(f5);
		this.RightShoulderpad.render(f5);
		this.Head.render(f5);
		this.RightArmConnection.render(f5);
		this.TopLeftLeg.render(f5);
		this.TopLeftArm.render(f5);
		this.LeftShoulderpad.render(f5);
		this.TopBody.render(f5);
		
		GlStateManager.popMatrix();
	}
	
	/** This is a helper function from Tabula to set the rotation of model parts */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		this.TopLeftLeg.rotateAngleX = -2.5F * this.func_78172_a(p_78087_1_, 10.0F) * p_78087_2_;
		this.TopRightLeg.rotateAngleX = 2.5F * this.func_78172_a(p_78087_1_, 10.0F) * p_78087_2_;
		
		this.BottomLeftLeg.rotateAngleX = -2.5F * this.func_78172_a(p_78087_1_, 12.0F) * p_78087_2_;
		this.BottomRightLeg.rotateAngleX = 2.5F * this.func_78172_a(p_78087_1_, 12.0F) * p_78087_2_;
		
		this.BottomLeftLeg.rotateAngleX = 1.5F * p_78087_2_;
		this.BottomRightLeg.rotateAngleX = 1.5F * p_78087_2_;
		
		EntityEmpoweredTenebraeGolem entityEmpoweredTenebraeGolem = (EntityEmpoweredTenebraeGolem) p_78087_7_;
		int i = entityEmpoweredTenebraeGolem.getAttackTimer();
		
		this.BottomRightArm.rotateAngleX = -0.5F;
		this.BottomLeftArm.rotateAngleX = -0.5F;
		
		if (!(i > 0)) {
			this.LeftShoulderpad.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.4F + (float) Math.PI) * 2.0F * p_78087_2_ * 0.5F;
			this.RightShoulderpad.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.4F) * 2.0F * p_78087_2_ * 0.5F;
			
			this.TopRightArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.4F + (float) Math.PI) * 2.0F * p_78087_2_ * 0.5F;
			this.TopLeftArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.4F) * 2.0F * p_78087_2_ * 0.5F;
		}
	}
	
	@Override public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
		EntityEmpoweredTenebraeGolem entityEmpoweredTenebraeGolem = (EntityEmpoweredTenebraeGolem) p_78086_1_;
		int i = entityEmpoweredTenebraeGolem.getAttackTimer();
		
		if (i > 0) {
			// this.RightShoulderpad.rotateAngleX = -1.5F + 1.5F *
			// this.func_78172_a((float)i - p_78086_4_, 10.0F);
			// this.LeftShoulderpad.rotateAngleX = -1.5F + 1.5F *
			// this.func_78172_a((float)i - p_78086_4_, 10.0F);
			
			this.TopRightArm.rotateAngleX = -1.5F + 1.5F * this.func_78172_a((float) i - p_78086_4_, 10.0F);
			this.TopLeftArm.rotateAngleX = -1.5F + 1.5F * this.func_78172_a((float) i - p_78086_4_, 10.0F);
			
			this.BottomRightArm.rotateAngleX = -0.5F;
			this.BottomLeftArm.rotateAngleX = -0.5F;
			
			this.BottomLeftLeg.rotateAngleX = 0.5F * p_78086_2_;
			this.BottomRightLeg.rotateAngleX = 0.5F * p_78086_2_;
		}
	}
	
	private float func_78172_a(float p_78172_1_, float p_78172_2_) { // Taken from ModelIronGolem
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}
}
