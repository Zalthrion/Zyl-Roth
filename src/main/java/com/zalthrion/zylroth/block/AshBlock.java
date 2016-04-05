package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.base.BlockBase;

public class AshBlock extends BlockBase {
	public AshBlock() {
		super(Material.sand);
		this.setCreativeTab();
		this.setHardness(0.5F);
		this.setNames("ashBlock");
		this.setSoundType(SoundType.SAND);
	}
}