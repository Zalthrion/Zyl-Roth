package com.zalthrion.zylroth.world.mapstructures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DesertHouse extends WorldGenerator {
	@Override public boolean generate(World world, Random rand, BlockPos pos) {
		this.generate(world, rand, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Deprecated private void setBlock(World world, int i, int j, int k, Block block, int meta) {
		world.setBlockState(new BlockPos(i, j, k), block.getStateFromMeta(meta));
	}
	
	@Deprecated
	public boolean generate(World world, Random rand, int i, int j, int k) {
		this.setBlock(world, i + 0, j + 0, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 0, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 0, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 0, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 0, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 0, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 0, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 0, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 1, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 1, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 1, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 1, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 1, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 1, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 1, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 2, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 2, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 2, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 2, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 2, k + 4, Blocks.GLASS_PANE, 0);
		this.setBlock(world, i + 0, j + 2, k + 5, Blocks.GLASS_PANE, 0);
		this.setBlock(world, i + 0, j + 2, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 2, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 3, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 3, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 3, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 3, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 3, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 3, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 3, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 0, j + 3, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 4, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 4, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 4, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 4, k + 3, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 4, k + 4, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 0, j + 4, k + 5, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 0, j + 4, k + 6, Blocks.AIR, 0);
		this.setBlock(world, i + 0, j + 4, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 0, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 1, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 1, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, Blocks.FURNACE, 5);
		this.setBlock(world, i + 1, j + 1, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 1, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 1, k + 6, Blocks.CRAFTING_TABLE, 0);
		this.setBlock(world, i + 1, j + 1, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 2, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 2, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 2, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 2, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 2, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 2, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 3, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 3, k + 1, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 1, j + 3, k + 2, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 1, j + 3, k + 3, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 1, j + 3, k + 4, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 1, j + 3, k + 5, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 1, j + 3, k + 6, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 1, j + 3, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 4, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 4, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 4, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 1, j + 4, k + 3, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 1, j + 4, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 4, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 1, j + 4, k + 6, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 1, j + 4, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.SANDSTONE_STAIRS, 2);
		this.setBlock(world, i + 2, j + 0, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 0, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 0, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 0, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 1, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 1, k + 3, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 1, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 1, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 1, k + 6, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 1, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 2, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 2, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 2, k + 3, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 2, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 2, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 2, k + 6, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 2, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 3, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 3, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 3, k + 2, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 2, j + 3, k + 3, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 2, j + 3, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 3, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 3, k + 6, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 2, j + 3, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 4, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 4, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 2, j + 4, k + 2, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 2, j + 4, k + 3, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 2, j + 4, k + 4, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 2, j + 4, k + 5, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 2, j + 4, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 2, j + 4, k + 7, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 3, j + 0, k + 0, Blocks.SANDSTONE_STAIRS, 2);
		this.setBlock(world, i + 3, j + 0, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 0, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 0, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 0, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 1, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 1, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 1, k + 6, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 1, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 2, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 2, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 2, k + 3, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 2, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 2, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 2, k + 6, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 2, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 3, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 3, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 3, k + 2, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 3, j + 3, k + 3, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 3, j + 3, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 3, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 3, k + 6, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 3, j + 3, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 4, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 4, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 3, j + 4, k + 2, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 3, j + 4, k + 3, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 3, j + 4, k + 4, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 3, j + 4, k + 5, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 3, j + 4, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 3, j + 4, k + 7, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 0, k + 0, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 0, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 1, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 1, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 1, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 1, k + 3, Blocks.CHEST, 3);
		this.setBlock(world, i + 4, j + 1, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 1, k + 5, Blocks.BED, 0);
		this.setBlock(world, i + 4, j + 1, k + 6, Blocks.BED, 8);
		this.setBlock(world, i + 4, j + 1, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 2, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 2, k + 1, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 2, k + 2, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 2, k + 4, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 2, k + 5, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 2, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 3, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 3, k + 1, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 3, k + 2, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 3, k + 3, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 3, k + 4, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 4, j + 3, k + 5, Blocks.STONE_SLAB, 9);
		this.setBlock(world, i + 4, j + 3, k + 6, Blocks.DOUBLE_STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 3, k + 7, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 4, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 4, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 4, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 4, j + 4, k + 3, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 4, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 4, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 4, j + 4, k + 6, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 4, j + 4, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 0, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 0, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 0, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 0, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 0, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 0, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 0, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 0, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 1, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 1, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 1, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 1, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 1, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 1, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 1, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 1, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 2, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 2, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 2, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 2, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 2, k + 4, Blocks.GLASS_PANE, 0);
		this.setBlock(world, i + 5, j + 2, k + 5, Blocks.GLASS_PANE, 0);
		this.setBlock(world, i + 5, j + 2, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 2, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 3, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 3, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 3, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 3, k + 3, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 3, k + 4, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 3, k + 5, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 3, k + 6, Blocks.SANDSTONE, 0);
		this.setBlock(world, i + 5, j + 3, k + 7, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 4, k + 0, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 4, k + 1, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 4, k + 2, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 4, k + 3, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 4, k + 4, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 5, j + 4, k + 5, Blocks.STONE_SLAB, 1);
		this.setBlock(world, i + 5, j + 4, k + 6, Blocks.AIR, 0);
		this.setBlock(world, i + 5, j + 4, k + 7, Blocks.AIR, 0);
/*		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 3, 3, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 6, 4, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 1, 7, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 1, 8, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 1, 7, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 1, 9, 2);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 3, 3, 2);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 6, 4, 2);*/

		return true;
	}
}