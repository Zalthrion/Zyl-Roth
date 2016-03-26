package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.base.BlockBase;

public class TenebraeBlock extends BlockBase {
	public TenebraeBlock() {
		super(Material.rock);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName("tenebraeBlock");
	}
	
	@Override public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}