package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.lib.ModTabs;

public class TenebraeBlock extends BlockBase {
	
	private String name = "tenebraeBlock";
	
	public TenebraeBlock() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
}