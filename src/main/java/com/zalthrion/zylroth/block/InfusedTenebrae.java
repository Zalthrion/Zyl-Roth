package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.base.BlockBase;

public class InfusedTenebrae extends BlockBase {
	public InfusedTenebrae() {
		super(Material.rock);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName("infusedTenebrae");
	}
}