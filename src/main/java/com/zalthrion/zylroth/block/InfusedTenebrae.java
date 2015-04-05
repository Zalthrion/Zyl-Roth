package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.lib.ModTabs;

import cpw.mods.fml.common.registry.GameRegistry;

public class InfusedTenebrae extends BlockBase {
	
	private String name = "infusedTenebrae";
	
	public InfusedTenebrae() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.ZylRoth);
		GameRegistry.registerBlock(this, TenebraeItemBlock.class, name);
	}
}