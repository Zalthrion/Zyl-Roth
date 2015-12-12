package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.lib.ModTabs;

public class InfusedTenebrae extends BlockBase {
	
	private String name = "infusedTenebrae";
	
	public InfusedTenebrae() {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.zylRoth);
	}
}