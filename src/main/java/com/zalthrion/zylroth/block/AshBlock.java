package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.base.BlockBase;

public class AshBlock extends BlockBase {
	
	/* Constructors */
	
	public AshBlock() {
		super(Material.SAND);
		this.setCreativeTab();
		this.setHardness(0.5F);
		this.setNames("ashBlock");
		this.setSoundType(SoundType.SAND);
	}
}