package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.lib.ModTabs;

public class TenebraeBlock extends BlockBase {
	
	private String name = "tenebraeBlock";
	
	public TenebraeBlock() {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.zylRoth);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}