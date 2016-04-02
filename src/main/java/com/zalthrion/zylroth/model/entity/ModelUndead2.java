package com.zalthrion.zylroth.model.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;

@SideOnly(Side.CLIENT)
public class ModelUndead2 extends ModelBiped {
	public ModelUndead2() {
		this(0.0F, false);
	}
	
	public ModelUndead2(float par1, boolean par2) {
		super(par1, 0.0F, 64, par2 ? 32 : 64);
	}
}
