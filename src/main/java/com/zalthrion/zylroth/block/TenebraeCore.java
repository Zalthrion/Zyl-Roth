package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.lib.ModTabs;

public class TenebraeCore extends BlockBase {
	
	private String name = "tenebraeCoreBlock";
	
	public TenebraeCore() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
}
