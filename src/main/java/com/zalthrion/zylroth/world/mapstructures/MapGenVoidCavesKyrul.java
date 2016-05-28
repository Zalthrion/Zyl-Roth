package com.zalthrion.zylroth.world.mapstructures;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.MapGenCaves;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class MapGenVoidCavesKyrul extends MapGenCaves {
	@Override protected boolean canReplaceBlock(IBlockState p_175793_1_, IBlockState p_175793_2_) {
		return p_175793_1_.getBlock() == BlockInit.voidStone ? true : (p_175793_1_.getBlock() == Blocks.DIRT ? true : (p_175793_1_.getBlock() == Blocks.GRASS ? true : (p_175793_1_.getBlock() == Blocks.HARDENED_CLAY ? true : (p_175793_1_.getBlock() == Blocks.STAINED_HARDENED_CLAY ? true : (p_175793_1_.getBlock() == Blocks.SANDSTONE ? true : (p_175793_1_.getBlock() == Blocks.RED_SANDSTONE ? true : (p_175793_1_.getBlock() == Blocks.MYCELIUM ? true : (p_175793_1_.getBlock() == Blocks.SNOW_LAYER ? true : (p_175793_1_.getBlock() == Blocks.SAND || p_175793_1_.getBlock() == Blocks.GRAVEL) && p_175793_2_.getMaterial() != Material.WATER))))))));
	}
}