package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.base.BlockBase;

public class VoidPlanks extends BlockBase {
	
	/* Constructors */
	
	public VoidPlanks() {
		super(Material.WOOD);
		this.setCreativeTab();
		this.setHardness(2.0F);
		this.setNames("voidPlanks");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);
	}
}