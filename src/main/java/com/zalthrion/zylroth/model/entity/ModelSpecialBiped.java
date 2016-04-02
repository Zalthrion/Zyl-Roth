package com.zalthrion.zylroth.model.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;

//Because apparently he's so special he needs a whole model to properly work
@SideOnly(Side.CLIENT)
public class ModelSpecialBiped extends ModelBiped {
	public ModelSpecialBiped() {
		this(0.0F, false);
	}
	
	public ModelSpecialBiped(float par1, boolean par2) {
		super(par1, 0.0F, 64, par2 ? 32 : 64);
	}
}
