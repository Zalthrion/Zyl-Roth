package com.zalthrion.zylroth.block;

import com.zalthrion.zylroth.lib.ModTabs;

import net.minecraft.block.material.Material;

public class AshBlock extends BlockBase {
	
	private String name = "ashBlock";
	
	public AshBlock() {
		super(Material.sand);
		this.setNames(name);
		this.setHardness(0.5F);
		this.setStepSound(soundTypeSand);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
}