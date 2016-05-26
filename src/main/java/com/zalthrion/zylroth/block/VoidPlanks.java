package com.zalthrion.zylroth.block;

import com.zalthrion.zylroth.lib.ModTabs;

import net.minecraft.block.material.Material;

public class VoidPlanks extends BlockBase {
	
	private String name = "voidPlanks";
	
	public VoidPlanks() {
		super(Material.wood);
		this.setNames(name);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
}