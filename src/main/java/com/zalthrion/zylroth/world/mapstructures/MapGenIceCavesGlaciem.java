package com.zalthrion.zylroth.world.mapstructures;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.MapGenCaves;

public class MapGenIceCavesGlaciem extends MapGenCaves {
	@Override protected boolean canReplaceBlock(IBlockState blockState1, IBlockState blockState2) {
		return blockState1.getBlock() == Blocks.PACKED_ICE ? true : (blockState1.getBlock() == Blocks.DIRT ? true : (blockState1.getBlock() == Blocks.GRASS ? true : (blockState1.getBlock() == Blocks.HARDENED_CLAY ? true : (blockState1.getBlock() == Blocks.STAINED_HARDENED_CLAY ? true : (blockState1.getBlock() == Blocks.SANDSTONE ? true : (blockState1.getBlock() == Blocks.RED_SANDSTONE ? true : (blockState1.getBlock() == Blocks.MYCELIUM ? true : (blockState1.getBlock() == Blocks.SNOW_LAYER ? true : (blockState1.getBlock() == Blocks.SAND || blockState1.getBlock() == Blocks.GRAVEL) && blockState2.getMaterial() != Material.WATER))))))));
	}
}