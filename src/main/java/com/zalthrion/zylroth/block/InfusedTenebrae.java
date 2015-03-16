package com.zalthrion.zylroth.block;

import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class InfusedTenebrae extends BlockBase {
	
	private String name = "infusedTenebrae";
	
	public InfusedTenebrae() {
		super();
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		GameRegistry.registerBlock(this, TenebraeItemBlock.class, name);
	}
}