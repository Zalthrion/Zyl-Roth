package com.zalthrion.zylroth.block;

import com.zalthrion.zylroth.lib.ModTabs;

import net.minecraft.block.material.Material;

public class VoidStone extends BlockBase {
	
	private String name = "voidStone";
	
	public VoidStone() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
}