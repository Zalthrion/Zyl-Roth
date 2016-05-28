package com.zalthrion.zylroth.model.entity.mount;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ModelWarTortoise extends ModelBase {
	public ModelRenderer rotationDerpFixer;
	public ModelRenderer LampLight;
	public ModelRenderer FrontRightLeg;
	public ModelRenderer BackLeftLeg;
	public ModelRenderer BackRightLeg;
	public ModelRenderer FrontLeftLeg;
	public ModelRenderer SeatBaseBackRightCorner;
	public ModelRenderer SeatBaseBackRightCorner_1;
	public ModelRenderer SeatBaseBackRightCorner_2;
	public ModelRenderer SeatBaseBackRightCorner_3;
	public ModelRenderer SeatBaseBackRightCorner_4;
	public ModelRenderer TopShellBackCorner;
	public ModelRenderer TopShellMiddle;
	public ModelRenderer TopShellFrontCorner;
	public ModelRenderer TurtleShellTopFront;
	public ModelRenderer SeatExtraBack;
	public ModelRenderer LampBottom;
	public ModelRenderer LampTop;
	public ModelRenderer LampLowerHandle;
	public ModelRenderer LampMainHandle;
	public ModelRenderer MantleProp;
	public ModelRenderer SeatBaseBackLeftCornerProp;
	public ModelRenderer SeatBaseBackRightCornerProp;
	public ModelRenderer SeatBaseFrontLeftCornerProp;
	public ModelRenderer SeatExtra;
	public ModelRenderer SeatBaseFrontRightCornerProp;
	public ModelRenderer SeatBaseBackTop;
	public ModelRenderer SeatBaseBack;
	public ModelRenderer SeatBase;
	public ModelRenderer SeatBaseBackRightCorner_5;
	public ModelRenderer SeatBaseFrontRightCorner;
	public ModelRenderer SeatBaseFrontLeftCorner;
	public ModelRenderer SeatBaseBackLeftCorner;
	public ModelRenderer SeatBaseFrontHandle;
	public ModelRenderer SeatBaseBackHandle;
	public ModelRenderer SeatBaseLeftHandle;
	public ModelRenderer SeatBaseRightHandle;
	public ModelRenderer LeftEye;
	public ModelRenderer RightEye;
	public ModelRenderer TurtleHeadBottom;
	public ModelRenderer TurtleHeadBottomCorner;
	public ModelRenderer TurtleHeadTop;
	public ModelRenderer TurtleHeadTopCorner;
	public ModelRenderer TurtleHeadCenter;
	public ModelRenderer TurtleShellTopBack;
	public ModelRenderer TurtleShellTopRightSide;
	public ModelRenderer TurtleShellTopLeftSide;
	public ModelRenderer InnerTurtleShellTop;
	public ModelRenderer TurtleShellFrontCenter;
	public ModelRenderer InnerTurtleShell;
	public ModelRenderer TurtleShellLowerFront;
	public ModelRenderer TurtleShellLowerBack;
	public ModelRenderer TurtleShellLowerRightSide;
	public ModelRenderer TurtleShellLowerLeftSide;
	public ModelRenderer TurtleShellBase;
	public ModelRenderer LegArmorFrontLeftLeg;
	public ModelRenderer LegArmorBackRightLeg;
	public ModelRenderer LegArmorBackLeftLeg;
	public ModelRenderer LegArmorFrontRightLeg;
	
	public ModelWarTortoise() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.LampTop = new ModelRenderer(this, 152, 28);
		this.LampTop.setRotationPoint(18.03F, 0.16F, 7.3F);
		this.LampTop.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.setRotateAngle(LampTop, 0.0F, 0.0F, -0.18203784098300857F);
		this.SeatBaseBack = new ModelRenderer(this, 0, 0);
		this.SeatBaseBack.setRotationPoint(-3.1F, -3.2F, -6.9F);
		this.SeatBaseBack.addBox(0.0F, 0.0F, 0.0F, 1, 4, 14, 0.0F);
		this.TopShellMiddle = new ModelRenderer(this, 189, 18);
		this.TopShellMiddle.setRotationPoint(-5.07F, 0.45F, -7.5F);
		this.TopShellMiddle.addBox(0.0F, 0.0F, 0.0F, 12, 1, 15, 0.0F);
		this.SeatExtraBack = new ModelRenderer(this, 113, 45);
		this.SeatExtraBack.setRotationPoint(-2.7F, -1.7F, -6.9F);
		this.SeatExtraBack.addBox(0.0F, 0.0F, 0.0F, 1, 2, 14, 0.0F);
		this.LegArmorFrontRightLeg = new ModelRenderer(this, 9, 50);
		this.LegArmorFrontRightLeg.setRotationPoint(1.0F, 3.0F, -0.6F);
		this.LegArmorFrontRightLeg.addBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F);
		this.TurtleShellLowerRightSide = new ModelRenderer(this, 39, 82);
		this.TurtleShellLowerRightSide.setRotationPoint(-16.4F, 9.05F, 11.0F);
		this.TurtleShellLowerRightSide.addBox(0.0F, 0.0F, 0.0F, 33, 1, 5, 0.0F);
		this.setRotateAngle(TurtleShellLowerRightSide, -1.4693926972540259F, 0.0F, 0.0F);
		this.TurtleShellTopBack = new ModelRenderer(this, 178, 67);
		this.TurtleShellTopBack.setRotationPoint(-15.5F, 6.0F, -10.5F);
		this.TurtleShellTopBack.addBox(0.0F, 0.0F, 0.0F, 1, 5, 21, 0.0F);
		this.setRotateAngle(TurtleShellTopBack, 0.0F, 0.0F, 3.141592653589793F);
		this.TurtleShellTopFront = new ModelRenderer(this, 101, 70);
		this.TurtleShellTopFront.setRotationPoint(16.75F, 7.0F, -10.5F);
		this.TurtleShellTopFront.addBox(0.0F, 0.0F, 0.0F, 1, 5, 21, 0.0F);
		this.setRotateAngle(TurtleShellTopFront, 0.0F, 0.0F, 3.141592653589793F);
		this.TopShellFrontCorner = new ModelRenderer(this, 151, 22);
		this.TopShellFrontCorner.setRotationPoint(16.7F, 2.8F, -7.5F);
		this.TopShellFrontCorner.addBox(0.0F, 0.0F, 0.0F, 10, 1, 15, 0.0F);
		this.setRotateAngle(TopShellFrontCorner, 0.0F, 0.0F, -3.0049333731586367F);
		this.SeatBaseBackRightCorner_4 = new ModelRenderer(this, 71, 21);
		this.SeatBaseBackRightCorner_4.setRotationPoint(-15.0F, 14.1F, -4.9F);
		this.SeatBaseBackRightCorner_4.addBox(0.0F, 0.0F, -0.1F, 30, 2, 10, 0.0F);
		this.rotationDerpFixer = new ModelRenderer(this, 0, 0);
		this.rotationDerpFixer.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rotationDerpFixer.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.setRotateAngle(rotationDerpFixer, 0.0F, 1.5707963267948966F, 0.0F);
		this.SeatBaseBackRightCornerProp = new ModelRenderer(this, 188, 27);
		this.SeatBaseBackRightCornerProp.setRotationPoint(-15.8F, -1.6F, 7.3F);
		this.SeatBaseBackRightCornerProp.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.SeatBaseBackRightCorner_2 = new ModelRenderer(this, 54, 16);
		this.SeatBaseBackRightCorner_2.setRotationPoint(-15.99F, 14.1F, -4.9F);
		this.SeatBaseBackRightCorner_2.addBox(0.0F, 0.0F, -0.1F, 2, 1, 10, 0.0F);
		this.setRotateAngle(SeatBaseBackRightCorner_2, 0.0F, 0.0F, 0.6511823439190844F);
		this.TurtleHeadCenter = new ModelRenderer(this, 8, 20);
		this.TurtleHeadCenter.setRotationPoint(16.65F, 7.41F, -3.5F);
		this.TurtleHeadCenter.addBox(0.0F, 0.0F, 0.0F, 8, 5, 7, 0.0F);
		this.LampLight = new ModelRenderer(this, 148, 18);
		this.LampLight.setRotationPoint(6.8F, -0.74F, -21.5F);
		this.LampLight.addBox(0.0F, 0.0F, 0.0F, 4, 5, 4, -1.0F);
		this.setRotateAngle(LampLight, -0.18203784098300857F, 0.0F, 0.0F);
		this.SeatBase = new ModelRenderer(this, 85, 51);
		this.SeatBase.setRotationPoint(-2.1F, -0.3F, -6.9F);
		this.SeatBase.addBox(0.0F, 0.0F, 0.0F, 5, 1, 14, 0.0F);
		this.FrontRightLeg = new ModelRenderer(this, 12, 102);
		this.FrontRightLeg.setRotationPoint(-11.1F, 13.0F, -13.9F);
		this.FrontRightLeg.addBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F);
		this.SeatBaseRightHandle = new ModelRenderer(this, 77, 35);
		this.SeatBaseRightHandle.setRotationPoint(-16.3F, 2.0F, 7.0F);
		this.SeatBaseRightHandle.addBox(0.0F, 0.0F, 0.0F, 33, 4, 2, 0.0F);
		this.setRotateAngle(SeatBaseRightHandle, 1.2747884856566583F, 0.0F, 0.0F);
		this.LampBottom = new ModelRenderer(this, 152, 28);
		this.LampBottom.setRotationPoint(18.63F, 3.36F, 7.3F);
		this.LampBottom.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.setRotateAngle(LampBottom, 0.0F, 0.0F, -0.18203784098300857F);
		this.LampMainHandle = new ModelRenderer(this, 163, 18);
		this.LampMainHandle.setRotationPoint(15.9F, -0.1F, 8.3F);
		this.LampMainHandle.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.setRotateAngle(LampMainHandle, 0.0F, 0.0F, -0.5009094953223726F);
		this.InnerTurtleShell = new ModelRenderer(this, 143, 96);
		this.InnerTurtleShell.setRotationPoint(-16.5F, 6.0F, -11.0F);
		this.InnerTurtleShell.addBox(0.0F, 0.0F, 0.0F, 33, 8, 22, 0.0F);
		this.MantleProp = new ModelRenderer(this, 117, 100);
		this.MantleProp.setRotationPoint(-6.1F, -2.3F, -6.4F);
		this.MantleProp.addBox(0.0F, 0.0F, 0.0F, 3, 3, 13, 0.0F);
		this.BackLeftLeg = new ModelRenderer(this, 12, 102);
		this.BackLeftLeg.setRotationPoint(-11.1F, 13.0F, 9.0F);
		this.BackLeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F);
		this.SeatBaseFrontLeftCornerProp = new ModelRenderer(this, 188, 27);
		this.SeatBaseFrontLeftCornerProp.setRotationPoint(13.2F, -1.6F, -10.0F);
		this.SeatBaseFrontLeftCornerProp.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.SeatBaseFrontRightCorner = new ModelRenderer(this, 9, 5);
		this.SeatBaseFrontRightCorner.setRotationPoint(12.7F, -1.1F, 6.8F);
		this.SeatBaseFrontRightCorner.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
		this.TurtleHeadTop = new ModelRenderer(this, 30, 2);
		this.TurtleHeadTop.setRotationPoint(16.32F, 5.52F, -3.5F);
		this.TurtleHeadTop.addBox(0.0F, 0.0F, 0.0F, 6, 2, 7, 0.0F);
		this.SeatExtra = new ModelRenderer(this, 125, 73);
		this.SeatExtra.setRotationPoint(-2.1F, -0.6F, -6.9F);
		this.SeatExtra.addBox(0.0F, 0.0F, 0.0F, 2, 1, 14, 0.0F);
		this.TurtleShellLowerLeftSide = new ModelRenderer(this, 39, 82);
		this.TurtleShellLowerLeftSide.setRotationPoint(-16.4F, 14.0F, -11.5F);
		this.TurtleShellLowerLeftSide.addBox(0.0F, 0.0F, 0.0F, 33, 1, 5, 0.0F);
		this.setRotateAngle(TurtleShellLowerLeftSide, 1.4570008595648662F, 0.0F, 0.0F);
		this.SeatBaseBackHandle = new ModelRenderer(this, 28, 16);
		this.SeatBaseBackHandle.setRotationPoint(-13.3F, 0.0F, -10.5F);
		this.SeatBaseBackHandle.addBox(0.0F, 0.0F, 0.0F, 2, 4, 21, 0.0F);
		this.setRotateAngle(SeatBaseBackHandle, 0.0F, 0.0F, 1.2747884856566583F);
		this.TopShellBackCorner = new ModelRenderer(this, 151, 22);
		this.TopShellBackCorner.setRotationPoint(-4.93F, 1.44F, -7.5F);
		this.TopShellBackCorner.addBox(0.0F, 0.0F, 0.0F, 10, 1, 15, 0.0F);
		this.setRotateAngle(TopShellBackCorner, 0.0F, 0.0F, 3.0049333731586367F);
		this.SeatBaseBackTop = new ModelRenderer(this, 152, 69);
		this.SeatBaseBackTop.setRotationPoint(-3.1F, -5.2F, -6.4F);
		this.SeatBaseBackTop.addBox(0.0F, 0.0F, 0.0F, 1, 2, 13, 0.0F);
		this.SeatBaseFrontHandle = new ModelRenderer(this, 28, 16);
		this.SeatBaseFrontHandle.setRotationPoint(12.8F, 2.2F, -10.5F);
		this.SeatBaseFrontHandle.addBox(0.0F, 0.0F, 0.0F, 2, 4, 21, 0.0F);
		this.setRotateAngle(SeatBaseFrontHandle, 0.0F, 0.0F, -1.2747884856566583F);
		this.SeatBaseBackLeftCorner = new ModelRenderer(this, 9, 5);
		this.SeatBaseBackLeftCorner.setRotationPoint(-16.3F, -1.1F, -10.5F);
		this.SeatBaseBackLeftCorner.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
		this.SeatBaseFrontLeftCorner = new ModelRenderer(this, 9, 5);
		this.SeatBaseFrontLeftCorner.setRotationPoint(12.7F, -1.1F, -10.5F);
		this.SeatBaseFrontLeftCorner.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
		this.TurtleShellBase = new ModelRenderer(this, 134, 42);
		this.TurtleShellBase.setRotationPoint(-17.0F, 14.0F, -11.5F);
		this.TurtleShellBase.addBox(0.0F, 0.0F, 0.0F, 34, 1, 23, 0.0F);
		this.SeatBaseBackLeftCornerProp = new ModelRenderer(this, 188, 27);
		this.SeatBaseBackLeftCornerProp.setRotationPoint(-15.8F, -1.6F, -10.0F);
		this.SeatBaseBackLeftCornerProp.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.SeatBaseBackRightCorner_1 = new ModelRenderer(this, 85, 15);
		this.SeatBaseBackRightCorner_1.setRotationPoint(-15.0F, 14.16F, -5.9F);
		this.SeatBaseBackRightCorner_1.addBox(0.0F, 0.0F, -0.1F, 30, 1, 2, 0.0F);
		this.setRotateAngle(SeatBaseBackRightCorner_1, -0.6511823439190844F, 0.0F, 0.0F);
		this.LeftEye = new ModelRenderer(this, 4, 4);
		this.LeftEye.setRotationPoint(20.05F, 7.9F, -4.0F);
		this.LeftEye.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.TurtleShellTopLeftSide = new ModelRenderer(this, 39, 73);
		this.TurtleShellTopLeftSide.setRotationPoint(-16.4F, 6.0F, -11.0F);
		this.TurtleShellTopLeftSide.addBox(0.0F, 0.0F, 0.0F, 33, 1, 5, 0.0F);
		this.setRotateAngle(TurtleShellTopLeftSide, 1.4570008595648662F, 0.0F, 0.0F);
		this.TurtleHeadBottom = new ModelRenderer(this, 91, 2);
		this.TurtleHeadBottom.setRotationPoint(15.8F, 11.36F, -3.5F);
		this.TurtleHeadBottom.addBox(0.0F, 0.0F, 0.0F, 6, 2, 7, 0.0F);
		this.SeatBaseBackRightCorner_3 = new ModelRenderer(this, 54, 16);
		this.SeatBaseBackRightCorner_3.setRotationPoint(14.39F, 15.31F, -4.9F);
		this.SeatBaseBackRightCorner_3.addBox(0.0F, 0.0F, -0.1F, 2, 1, 10, 0.0F);
		this.setRotateAngle(SeatBaseBackRightCorner_3, 0.0F, 0.0F, -0.6511823439190844F);
		this.SeatBaseFrontRightCornerProp = new ModelRenderer(this, 188, 27);
		this.SeatBaseFrontRightCornerProp.setRotationPoint(13.2F, -1.6F, 7.3F);
		this.SeatBaseFrontRightCornerProp.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.TurtleHeadBottomCorner = new ModelRenderer(this, 61, 2);
		this.TurtleHeadBottomCorner.setRotationPoint(20.85F, 10.52F, -3.5F);
		this.TurtleHeadBottomCorner.addBox(0.0F, 0.0F, 0.0F, 3, 3, 7, 0.0F);
		this.setRotateAngle(TurtleHeadBottomCorner, 0.0F, 0.0F, -0.3239331091701475F);
		this.RightEye = new ModelRenderer(this, 4, 4);
		this.RightEye.setRotationPoint(20.05F, 7.9F, 2.0F);
		this.RightEye.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.InnerTurtleShellTop = new ModelRenderer(this, 28, 100);
		this.InnerTurtleShellTop.setRotationPoint(16.7F, 7.0F, -10.5F);
		this.InnerTurtleShellTop.addBox(0.0F, 0.0F, 0.0F, 33, 5, 21, 0.0F);
		this.setRotateAngle(InnerTurtleShellTop, 0.0F, 0.0F, 3.141592653589793F);
		this.FrontLeftLeg = new ModelRenderer(this, 12, 102);
		this.FrontLeftLeg.setRotationPoint(5.0F, 13.0F, -13.9F);
		this.FrontLeftLeg.addBox(0.0F, 0.0F, 0.0F, 6, 11, 6, 0.0F);
		this.SeatBaseBackRightCorner = new ModelRenderer(this, 80, 15);
		this.SeatBaseBackRightCorner.setRotationPoint(-15.0F, 15.25F, 4.47F);
		this.SeatBaseBackRightCorner.addBox(0.0F, 0.0F, -0.1F, 30, 1, 2, 0.0F);
		this.setRotateAngle(SeatBaseBackRightCorner, 0.6511823439190844F, 0.0F, 0.0F);
		this.LegArmorFrontLeftLeg = new ModelRenderer(this, 9, 50);
		this.LegArmorFrontLeftLeg.setRotationPoint(1.0F, 3.0F, -0.6F);
		this.LegArmorFrontLeftLeg.addBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F);
		this.LegArmorBackRightLeg = new ModelRenderer(this, 9, 50);
		this.LegArmorBackRightLeg.setRotationPoint(1.0F, 3.0F, -0.6F);
		this.LegArmorBackRightLeg.addBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F);
		this.TurtleShellTopRightSide = new ModelRenderer(this, 39, 73);
		this.TurtleShellTopRightSide.setRotationPoint(-16.4F, 1.03F, 10.52F);
		this.TurtleShellTopRightSide.addBox(0.0F, 0.0F, 0.0F, 33, 1, 5, 0.0F);
		this.setRotateAngle(TurtleShellTopRightSide, -1.4744541520848098F, 0.0F, 0.0F);
		this.TurtleShellFrontCenter = new ModelRenderer(this, 3, 40);
		this.TurtleShellFrontCenter.setRotationPoint(15.75F, 6.0F, -11.0F);
		this.TurtleShellFrontCenter.addBox(0.0F, 0.0F, 0.0F, 1, 5, 22, 0.0F);
		this.TurtleHeadTopCorner = new ModelRenderer(this, 123, 2);
		this.TurtleHeadTopCorner.setRotationPoint(22.32F, 5.5202F, -3.5F);
		this.TurtleHeadTopCorner.addBox(0.0F, 0.0F, 0.0F, 3, 3, 7, 0.0F);
		this.setRotateAngle(TurtleHeadTopCorner, 0.0F, 0.0F, 0.6813765399785863F);
		this.TurtleShellLowerFront = new ModelRenderer(this, 4, 73);
		this.TurtleShellLowerFront.setRotationPoint(16.0F, 14.2F, -11.0F);
		this.TurtleShellLowerFront.addBox(0.0F, 0.0F, 0.0F, 5, 1, 22, 0.0F);
		this.setRotateAngle(TurtleShellLowerFront, 0.0F, 0.0F, -1.6390387005478748F);
		this.SeatBaseBackRightCorner_5 = new ModelRenderer(this, 9, 5);
		this.SeatBaseBackRightCorner_5.setRotationPoint(-16.3F, -1.1F, 6.8F);
		this.SeatBaseBackRightCorner_5.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
		this.TurtleShellLowerBack = new ModelRenderer(this, 51, 47);
		this.TurtleShellLowerBack.setRotationPoint(-17.0F, 14.0F, -11.0F);
		this.TurtleShellLowerBack.addBox(0.0F, 0.0F, 0.0F, 5, 1, 22, 0.0F);
		this.setRotateAngle(TurtleShellLowerBack, 0.0F, 0.0F, -1.4570008595648662F);
		this.LegArmorBackLeftLeg = new ModelRenderer(this, 9, 50);
		this.LegArmorBackLeftLeg.setRotationPoint(1.0F, 3.0F, -0.6F);
		this.LegArmorBackLeftLeg.addBox(0.0F, 0.0F, 0.0F, 4, 6, 1, 0.0F);
		this.LampLowerHandle = new ModelRenderer(this, 163, 13);
		this.LampLowerHandle.setRotationPoint(18.53F, -1.54F, 8.3F);
		this.LampLowerHandle.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(LampLowerHandle, 0.0F, 0.0F, -0.22759093446006054F);
		this.SeatBaseLeftHandle = new ModelRenderer(this, 77, 35);
		this.SeatBaseLeftHandle.setRotationPoint(-16.3F, 0.0F, -7.4F);
		this.SeatBaseLeftHandle.addBox(0.0F, 0.0F, 0.0F, 33, 4, 2, 0.0F);
		this.setRotateAngle(SeatBaseLeftHandle, -1.2747884856566583F, 0.0F, 0.0F);
		this.BackRightLeg = new ModelRenderer(this, 12, 102);
		this.BackRightLeg.setRotationPoint(5.0F, 13.0F, 9.0F);
		this.BackRightLeg.addBox(0.0F, 0.0F, -0.1F, 6, 11, 6, 0.0F);
		this.rotationDerpFixer.addChild(this.LampTop);
		this.rotationDerpFixer.addChild(this.SeatBaseBack);
		this.rotationDerpFixer.addChild(this.TopShellMiddle);
		this.rotationDerpFixer.addChild(this.SeatExtraBack);
		this.FrontLeftLeg.addChild(this.LegArmorFrontRightLeg);
		this.rotationDerpFixer.addChild(this.TurtleShellLowerRightSide);
		this.rotationDerpFixer.addChild(this.TurtleShellTopBack);
		this.rotationDerpFixer.addChild(this.TurtleShellTopFront);
		this.rotationDerpFixer.addChild(this.TopShellFrontCorner);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCorner_4);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCornerProp);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCorner_2);
		this.rotationDerpFixer.addChild(this.TurtleHeadCenter);
		this.rotationDerpFixer.addChild(this.SeatBase);
		this.rotationDerpFixer.addChild(this.SeatBaseRightHandle);
		this.rotationDerpFixer.addChild(this.LampBottom);
		this.rotationDerpFixer.addChild(this.LampMainHandle);
		this.rotationDerpFixer.addChild(this.InnerTurtleShell);
		this.rotationDerpFixer.addChild(this.MantleProp);
		this.rotationDerpFixer.addChild(this.SeatBaseFrontLeftCornerProp);
		this.rotationDerpFixer.addChild(this.SeatBaseFrontRightCorner);
		this.rotationDerpFixer.addChild(this.TurtleHeadTop);
		this.rotationDerpFixer.addChild(this.SeatExtra);
		this.rotationDerpFixer.addChild(this.TurtleShellLowerLeftSide);
		this.rotationDerpFixer.addChild(this.SeatBaseBackHandle);
		this.rotationDerpFixer.addChild(this.TopShellBackCorner);
		this.rotationDerpFixer.addChild(this.SeatBaseBackTop);
		this.rotationDerpFixer.addChild(this.SeatBaseFrontHandle);
		this.rotationDerpFixer.addChild(this.SeatBaseBackLeftCorner);
		this.rotationDerpFixer.addChild(this.SeatBaseFrontLeftCorner);
		this.rotationDerpFixer.addChild(this.TurtleShellBase);
		this.rotationDerpFixer.addChild(this.SeatBaseBackLeftCornerProp);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCorner_1);
		this.rotationDerpFixer.addChild(this.LeftEye);
		this.rotationDerpFixer.addChild(this.TurtleShellTopLeftSide);
		this.rotationDerpFixer.addChild(this.TurtleHeadBottom);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCorner_3);
		this.rotationDerpFixer.addChild(this.SeatBaseFrontRightCornerProp);
		this.rotationDerpFixer.addChild(this.TurtleHeadBottomCorner);
		this.rotationDerpFixer.addChild(this.RightEye);
		this.rotationDerpFixer.addChild(this.InnerTurtleShellTop);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCorner);
		this.FrontRightLeg.addChild(this.LegArmorFrontLeftLeg);
		this.BackLeftLeg.addChild(this.LegArmorBackRightLeg);
		this.rotationDerpFixer.addChild(this.TurtleShellTopRightSide);
		this.rotationDerpFixer.addChild(this.TurtleShellFrontCenter);
		this.rotationDerpFixer.addChild(this.TurtleHeadTopCorner);
		this.rotationDerpFixer.addChild(this.TurtleShellLowerFront);
		this.rotationDerpFixer.addChild(this.SeatBaseBackRightCorner_5);
		this.rotationDerpFixer.addChild(this.TurtleShellLowerBack);
		this.BackRightLeg.addChild(this.LegArmorBackLeftLeg);
		this.rotationDerpFixer.addChild(this.LampLowerHandle);
		this.rotationDerpFixer.addChild(this.SeatBaseLeftHandle);
	}
	
	@Override public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.rotationDerpFixer.render(f5);
		this.LampLight.render(f5);
		this.FrontRightLeg.render(f5);
		this.BackLeftLeg.render(f5);
		this.FrontLeftLeg.render(f5);
		this.BackRightLeg.render(f5);
	}
	
	/** This is a helper function from Tabula to set the rotation of model parts */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
		this.FrontLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
		this.BackLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.FrontRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.BackRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
	}
}