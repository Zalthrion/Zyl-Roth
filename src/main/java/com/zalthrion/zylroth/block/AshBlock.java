package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class AshBlock extends BlockBase {
	
	private String name = "ashBlock";
	
	public AshBlock() {
		super(Material.sand);
		this.setNames(name);
		this.setHardness(0.5F);
		this.setStepSound(soundTypeSand);
	}
	
}