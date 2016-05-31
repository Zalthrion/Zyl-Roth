package com.zalthrion.zylroth.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ModelCrossbow extends ModelBase {
	public ModelRenderer Base;
	public ModelRenderer Handle;
	public ModelRenderer RightString;
	public ModelRenderer LeftString;
	public ModelRenderer ArrowHandleLeft;
	public ModelRenderer ArrowHandleBase;
	public ModelRenderer ArrowHandleRight;
	public ModelRenderer ShootHandleTop;
	public ModelRenderer ShootHandleBottom;
	public ModelRenderer ArrowWood;
	public ModelRenderer ArrowMetalRight;
	public ModelRenderer ArrowMetalLeft;
	public ModelRenderer ArrowMetalCenter;
	
	public ModelCrossbow() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.ArrowWood = new ModelRenderer(this, 14, 4);
		this.ArrowWood.setRotationPoint(0.5F, 0.3F, -3.5F);
		this.ArrowWood.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.RightString = new ModelRenderer(this, 13, 14);
		this.RightString.setRotationPoint(1.88F, 0.0F, 8.88F);
		this.RightString.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10, 0.0F);
		this.setRotateAngle(RightString, 0.0F, -2.611012560983517F, 0.0F);
		this.Handle = new ModelRenderer(this, 44, 2);
		this.Handle.setRotationPoint(0.0F, 0.0F, 10.0F);
		this.Handle.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5, 0.0F);
		this.setRotateAngle(Handle, -0.8218755447641298F, 0.0F, 0.0F);
		this.ArrowMetalCenter = new ModelRenderer(this, 15, 0);
		this.ArrowMetalCenter.setRotationPoint(1.1F, 0.3F, -5.5F);
		this.ArrowMetalCenter.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		this.setRotateAngle(ArrowMetalCenter, 0.0F, -0.8290313946973066F, 0.0F);
		this.ShootHandleTop = new ModelRenderer(this, 53, 12);
		this.ShootHandleTop.setRotationPoint(0.0F, 1.9F, 6.0F);
		this.ShootHandleTop.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.setRotateAngle(ShootHandleTop, 0.4553564018453205F, 0.0F, 0.0F);
		this.ArrowMetalRight = new ModelRenderer(this, 26, 6);
		this.ArrowMetalRight.setRotationPoint(0.0F, 0.3F, -4.5F);
		this.ArrowMetalRight.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(ArrowMetalRight, 0.0F, -0.8196066167365371F, 0.0F);
		this.ShootHandleBottom = new ModelRenderer(this, 50, 17);
		this.ShootHandleBottom.setRotationPoint(0.0F, 2.6F, 6.9F);
		this.ShootHandleBottom.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
		this.LeftString = new ModelRenderer(this, 36, 15);
		this.LeftString.setRotationPoint(1.0F, 0.0F, 9.2F);
		this.LeftString.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
		this.setRotateAngle(LeftString, 0.0F, 2.586927017305995F, 0.0F);
		this.ArrowMetalLeft = new ModelRenderer(this, 6, 6);
		this.ArrowMetalLeft.setRotationPoint(1.3F, 0.3F, -3.8F);
		this.ArrowMetalLeft.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(ArrowMetalLeft, 0.0F, 0.7740535232594852F, 0.0F);
		this.ArrowHandleLeft = new ModelRenderer(this, 4, 11);
		this.ArrowHandleLeft.setRotationPoint(6.1F, 0.0F, 3.87F);
		this.ArrowHandleLeft.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(ArrowHandleLeft, 0.0F, 2.2525219326238815F, 0.0F);
		this.ArrowHandleRight = new ModelRenderer(this, 4, 15);
		this.ArrowHandleRight.setRotationPoint(-5.82F, 0.0F, 2.48F);
		this.ArrowHandleRight.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F);
		this.setRotateAngle(ArrowHandleRight, 0.0F, 0.8482300164692442F, 0.0F);
		this.ArrowHandleBase = new ModelRenderer(this, 2, 19);
		this.ArrowHandleBase.setRotationPoint(-2.5F, 0.0F, -1.27F);
		this.ArrowHandleBase.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
		this.Base = new ModelRenderer(this, 24, 1);
		this.Base.setRotationPoint(-0.5F, 0.0F, -5.0F);
		this.Base.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
		this.Base.addChild(this.ArrowWood);
		this.Base.addChild(this.RightString);
		this.Base.addChild(this.Handle);
		this.Base.addChild(this.ArrowMetalCenter);
		this.Base.addChild(this.ShootHandleTop);
		this.Base.addChild(this.ArrowMetalRight);
		this.Base.addChild(this.ShootHandleBottom);
		this.Base.addChild(this.LeftString);
		this.Base.addChild(this.ArrowMetalLeft);
		this.Base.addChild(this.ArrowHandleLeft);
		this.Base.addChild(this.ArrowHandleRight);
		this.Base.addChild(this.ArrowHandleBase);
	}
	
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Base.render(f5);
	}
	
	public void render(float f5) {
		this.Base.render(f5);
	}
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}