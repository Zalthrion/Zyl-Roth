package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import com.zalthrion.zylroth.lib.ModTabs;

public class AshBlock extends BlockBase {
	
	private String name = "ashBlock";
	
	public AshBlock() {
		super(Material.sand);
		this.setUnlocalizedName(name);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.SAND);
		this.setCreativeTab(ModTabs.zylRoth);
	}
}