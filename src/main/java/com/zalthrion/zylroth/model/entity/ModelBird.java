package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** Bird Model - Zalthrion Created using Tabula 4.1.0 */
@SideOnly(Side.CLIENT) public class ModelBird extends ModelBase {
	public ModelRenderer Body;
	public ModelRenderer Head;
	public ModelRenderer LeftWing;
	public ModelRenderer Tail;
	public ModelRenderer Peck;
	public ModelRenderer RightWing;
	public ModelRenderer LeftEye;
	public ModelRenderer RightEye;
	public ModelRenderer LeftLeg;
	public ModelRenderer RightLeg;
	public ModelRenderer RightBottomLeg;
	public ModelRenderer LeftBottomLeg;
	
	public ModelBird() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.LeftBottomLeg = new ModelRenderer(this, 0, 0);
		this.LeftBottomLeg.setRotationPoint(6.7F, 10.3F, 6.7F);
		this.LeftBottomLeg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(1.0F, -6.3F, -7.23F);
		this.Head.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.RightBottomLeg = new ModelRenderer(this, 0, 0);
		this.RightBottomLeg.setRotationPoint(1.2F, 10.3F, 6.7F);
		this.RightBottomLeg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.Tail = new ModelRenderer(this, 0, 0);
		this.Tail.setRotationPoint(1.75F, 3.3F, 11.85F);
		this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.LeftEye = new ModelRenderer(this, 0, 0);
		this.LeftEye.setRotationPoint(8.2F, -4.65F, -6.1F);
		this.LeftEye.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.LeftWing = new ModelRenderer(this, 0, 0);
		this.LeftWing.setRotationPoint(10.0F, 2.0F, 3.0F);
		this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(LeftWing, 0.5009094953223726F, 0.0F, 0.0F);
		this.RightLeg = new ModelRenderer(this, 0, 0);
		this.RightLeg.setRotationPoint(1.5F, 8.0F, 8.0F);
		this.RightLeg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.RightWing = new ModelRenderer(this, 0, 0);
		this.RightWing.setRotationPoint(-0.6F, 2.0F, 3.0F);
		this.RightWing.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(RightWing, 0.5009094953223726F, 0.0F, 0.0F);
		this.Peck = new ModelRenderer(this, 0, 0);
		this.Peck.setRotationPoint(3.5F, -2.5F, -9.13F);
		this.Peck.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.LeftLeg = new ModelRenderer(this, 0, 0);
		this.LeftLeg.setRotationPoint(7.0F, 8.0F, 8.0F);
		this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.RightEye = new ModelRenderer(this, 0, 0);
		this.RightEye.setRotationPoint(0.6F, -4.65F, -6.1F);
		this.RightEye.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
	}
	
	/* Custom Methods */
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	public int getBirdSize() {
		return 36;
	}
	
	/* Overridden */
	
	@Override public void render(Entity entityIn, float p_78088_2_, float limbSwing, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.LeftBottomLeg.offsetX, this.LeftBottomLeg.offsetY, this.LeftBottomLeg.offsetZ);
		GlStateManager.translate(this.LeftBottomLeg.rotationPointX * scale, this.LeftBottomLeg.rotationPointY * scale, this.LeftBottomLeg.rotationPointZ * scale);
		GlStateManager.scale(2.1D, 0.8D, 3.0D);
		GlStateManager.translate(-this.LeftBottomLeg.offsetX, -this.LeftBottomLeg.offsetY, -this.LeftBottomLeg.offsetZ);
		GlStateManager.translate(-this.LeftBottomLeg.rotationPointX * scale, -this.LeftBottomLeg.rotationPointY * scale, -this.LeftBottomLeg.rotationPointZ * scale);
		this.LeftBottomLeg.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
		GlStateManager.translate(this.Head.rotationPointX * scale, this.Head.rotationPointY * scale, this.Head.rotationPointZ * scale);
		GlStateManager.scale(8.0D, 8.0D, 8.0D);
		GlStateManager.translate(-this.Head.offsetX, -this.Head.offsetY, -this.Head.offsetZ);
		GlStateManager.translate(-this.Head.rotationPointX * scale, -this.Head.rotationPointY * scale, -this.Head.rotationPointZ * scale);
		this.Head.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.RightBottomLeg.offsetX, this.RightBottomLeg.offsetY, this.RightBottomLeg.offsetZ);
		GlStateManager.translate(this.RightBottomLeg.rotationPointX * scale, this.RightBottomLeg.rotationPointY * scale, this.RightBottomLeg.rotationPointZ * scale);
		GlStateManager.scale(2.1D, 0.8D, 3.0D);
		GlStateManager.translate(-this.RightBottomLeg.offsetX, -this.RightBottomLeg.offsetY, -this.RightBottomLeg.offsetZ);
		GlStateManager.translate(-this.RightBottomLeg.rotationPointX * scale, -this.RightBottomLeg.rotationPointY * scale, -this.RightBottomLeg.rotationPointZ * scale);
		this.RightBottomLeg.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.Tail.offsetX, this.Tail.offsetY, this.Tail.offsetZ);
		GlStateManager.translate(this.Tail.rotationPointX * scale, this.Tail.rotationPointY * scale, this.Tail.rotationPointZ * scale);
		GlStateManager.scale(6.5D, 0.4D, 7.3D);
		GlStateManager.translate(-this.Tail.offsetX, -this.Tail.offsetY, -this.Tail.offsetZ);
		GlStateManager.translate(-this.Tail.rotationPointX * scale, -this.Tail.rotationPointY * scale, -this.Tail.rotationPointZ * scale);
		this.Tail.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.LeftEye.offsetX, this.LeftEye.offsetY, this.LeftEye.offsetZ);
		GlStateManager.translate(this.LeftEye.rotationPointX * scale, this.LeftEye.rotationPointY * scale, this.LeftEye.rotationPointZ * scale);
		GlStateManager.scale(1.2D, 1.6D, 1.6D);
		GlStateManager.translate(-this.LeftEye.offsetX, -this.LeftEye.offsetY, -this.LeftEye.offsetZ);
		GlStateManager.translate(-this.LeftEye.rotationPointX * scale, -this.LeftEye.rotationPointY * scale, -this.LeftEye.rotationPointZ * scale);
		this.LeftEye.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
		GlStateManager.translate(this.Body.rotationPointX * scale, this.Body.rotationPointY * scale, this.Body.rotationPointZ * scale);
		GlStateManager.scale(10.0D, 8.0D, 16.0D);
		GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);
		GlStateManager.translate(-this.Body.rotationPointX * scale, -this.Body.rotationPointY * scale, -this.Body.rotationPointZ * scale);
		this.Body.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.LeftWing.offsetX, this.LeftWing.offsetY, this.LeftWing.offsetZ);
		GlStateManager.translate(this.LeftWing.rotationPointX * scale, this.LeftWing.rotationPointY * scale, this.LeftWing.rotationPointZ * scale);
		GlStateManager.scale(0.6D, 3.4D, 5.0D);
		GlStateManager.translate(-this.LeftWing.offsetX, -this.LeftWing.offsetY, -this.LeftWing.offsetZ);
		GlStateManager.translate(-this.LeftWing.rotationPointX * scale, -this.LeftWing.rotationPointY * scale, -this.LeftWing.rotationPointZ * scale);
		this.LeftWing.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.RightLeg.offsetX, this.RightLeg.offsetY, this.RightLeg.offsetZ);
		GlStateManager.translate(this.RightLeg.rotationPointX * scale, this.RightLeg.rotationPointY * scale, this.RightLeg.rotationPointZ * scale);
		GlStateManager.scale(1.5D, 3.0D, 1.5D);
		GlStateManager.translate(-this.RightLeg.offsetX, -this.RightLeg.offsetY, -this.RightLeg.offsetZ);
		GlStateManager.translate(-this.RightLeg.rotationPointX * scale, -this.RightLeg.rotationPointY * scale, -this.RightLeg.rotationPointZ * scale);
		this.RightLeg.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.RightWing.offsetX, this.RightWing.offsetY, this.RightWing.offsetZ);
		GlStateManager.translate(this.RightWing.rotationPointX * scale, this.RightWing.rotationPointY * scale, this.RightWing.rotationPointZ * scale);
		GlStateManager.scale(0.6D, 3.4D, 5.0D);
		GlStateManager.translate(-this.RightWing.offsetX, -this.RightWing.offsetY, -this.RightWing.offsetZ);
		GlStateManager.translate(-this.RightWing.rotationPointX * scale, -this.RightWing.rotationPointY * scale, -this.RightWing.rotationPointZ * scale);
		this.RightWing.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.Peck.offsetX, this.Peck.offsetY, this.Peck.offsetZ);
		GlStateManager.translate(this.Peck.rotationPointX * scale, this.Peck.rotationPointY * scale, this.Peck.rotationPointZ * scale);
		GlStateManager.scale(3.2D, 0.9D, 4.2D);
		GlStateManager.translate(-this.Peck.offsetX, -this.Peck.offsetY, -this.Peck.offsetZ);
		GlStateManager.translate(-this.Peck.rotationPointX * scale, -this.Peck.rotationPointY * scale, -this.Peck.rotationPointZ * scale);
		this.Peck.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.LeftLeg.offsetX, this.LeftLeg.offsetY, this.LeftLeg.offsetZ);
		GlStateManager.translate(this.LeftLeg.rotationPointX * scale, this.LeftLeg.rotationPointY * scale, this.LeftLeg.rotationPointZ * scale);
		GlStateManager.scale(1.5D, 3.0D, 1.5D);
		GlStateManager.translate(-this.LeftLeg.offsetX, -this.LeftLeg.offsetY, -this.LeftLeg.offsetZ);
		GlStateManager.translate(-this.LeftLeg.rotationPointX * scale, -this.LeftLeg.rotationPointY * scale, -this.LeftLeg.rotationPointZ * scale);
		this.LeftLeg.render(scale);
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		GlStateManager.translate(this.RightEye.offsetX, this.RightEye.offsetY, this.RightEye.offsetZ);
		GlStateManager.translate(this.RightEye.rotationPointX * scale, this.RightEye.rotationPointY * scale, this.RightEye.rotationPointZ * scale);
		GlStateManager.scale(1.2D, 1.6D, 1.6D);
		GlStateManager.translate(-this.RightEye.offsetX, -this.RightEye.offsetY, -this.RightEye.offsetZ);
		GlStateManager.translate(-this.RightEye.rotationPointX * scale, -this.RightEye.rotationPointY * scale, -this.RightEye.rotationPointZ * scale);
		this.RightEye.render(scale);
		GlStateManager.popMatrix();
	}
}