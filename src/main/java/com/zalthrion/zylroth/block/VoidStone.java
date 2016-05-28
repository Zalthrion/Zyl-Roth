package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.base.BlockBase;

public class VoidStone extends BlockBase {
	private String name = "voidStone";
	
	public VoidStone() {
		super(Material.ROCK);
		this.setCreativeTab();
		this.setNames(name);
		this.setHardness(1.5F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.STONE);
	}
}