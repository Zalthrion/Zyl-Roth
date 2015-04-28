package com.zalthrion.zylroth.model.entity;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRainbowPig extends ModelQuadruped {
	
	public ModelRainbowPig() {
		this(0.0F);
	}
	
	public ModelRainbowPig(float p_i1151_1_) {
		super(6, p_i1151_1_);
		this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, p_i1151_1_);
		this.childYOffset = 4.0F;
	}
}