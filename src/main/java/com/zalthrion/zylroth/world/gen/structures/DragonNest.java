package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.zalthrion.zylroth.lib.ModBlocks;

public class DragonNest extends WorldGenerator {
	public DragonNest() {}
	
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {Blocks.grass};
	}
	
	public boolean locationIsValidSpawn(World world, BlockPos pos) {
		int distanceToAir = 0;
		Block check = world.getBlockState(pos).getBlock();
		
		while (check != Blocks.air) {
			if (distanceToAir > 3) return false;
			distanceToAir ++;
			check = world.getBlockState(pos).getBlock();
		}
		
		pos = pos.up(distanceToAir - 1);
		
		Block block = world.getBlockState(pos).getBlock();
		Block blockAbove = world.getBlockState(pos.up()).getBlock();
		Block blockBelow = world.getBlockState(pos.down()).getBlock();
		
		for (Block x : getValidSpawnBlocks()) {
			if (blockAbove != Blocks.air) { return false; }
			if (block == x) {
				return true;
			} else if (block == Blocks.snow && blockBelow == x) { return true; }
		}
		
		return false;
	}
	
	public boolean locationsAreValid(World world, BlockPos corner1, BlockPos corner2) {
		int x1 = corner1.getX();
		int y1 = corner1.getY();
		int z1 = corner1.getZ();
		int x2 = corner2.getX();
		int y2 = corner2.getY();
		int z2 = corner2.getZ();
		
		for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x ++) {
			for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y ++) {
				for (int z = Math.min(z1, z2); z <= Math.max(z1, z2); z ++) {
					if (!locationIsValidSpawn(world, new BlockPos(x, y, z))) return false;
				}
			}
		}
		return true;
	}
	
	private void setBlocks(World world, IBlockState blockState, BlockPos[] pos) {
		for (BlockPos aPos : pos) {
			world.setBlockState(aPos, blockState);
		}
	}
	
	@Override public boolean generate(World world, Random rand, BlockPos pos) {
		if (!locationsAreValid(world, pos.add(-3, 1, -3), pos.add(3, 1, 3)) && world.isAirBlock(pos.add(0, 4, 0))) { return false; }
		
		/* z = z - 10; x = x - 10; */
		
		setBlocks(world, Blocks.stone.getDefaultState(), new BlockPos[] {
			pos.up().north().west(3),
			pos.up().west(3),
			pos.up().south().west(3),
			pos.up().south(2).west(2),
			pos.up().north(3).west(2),
			pos.up().north(2).west(2),
			pos.up().north().west(2),
			pos.up().west(2),
			pos.up().south().west(2),
			pos.up().south(2).west(2),
			pos.up().south(3).west(2),
			pos.up().north(2).west(),
			pos.up().north().west(),
			pos.up().west(),
			pos.up().south().west(),
			pos.up().south(2).west(),
			pos.up().south(3).west(),
			pos.up().north(3),
			pos.up().north(2),
			pos.up().north(),
			pos.up(), // Central Block
			pos.up().south(),
			pos.up().south(2),
			pos.up().south(3),
			pos.up().north(3).east(),
			pos.up().north(2).east(),
			pos.up().north().east(),
			pos.up().east(),
			pos.up().south().east(),
			pos.up().south(2).east(),
			pos.up().north(3).east(2),
			pos.up().north(2).east(2),
			pos.up().north().east(2),
			pos.up().east(2),
			pos.up().south().east(2),
			pos.up().south(2).east(2),
			pos.up().south(3).east(2),
			pos.up().north(2).east(3),
			pos.up().east(2),
			pos.up().south().east(3),
			pos.up().south(2).east(3),
			pos.up(2).north().east(2),
			pos.up(2).east(2),
			pos.up(2).north(2).east(),
			pos.up(2).south().west(),
			pos.up(2).west(),
			pos.up(2).south().west(),
			pos.up(2).south(2).west(),
			pos.up(2).north(2),
			pos.up(2).north(),
			pos.up(2).south(),
			pos.up(2).south(2),
			pos.up(2).north(2).east(),
			pos.up(2).north().east(),
			pos.up(2).east(),
			pos.up(2).south().east(),
			pos.up(2).south(2).east(),
			pos.up(2).north().east(2),
			pos.up(2).east(2),
			pos.up(2).south().east(2),
			pos.up(3).west(),
			pos.up(3).north(),
			pos.up(3).south(),
			pos.up(3).east()
		});
		
		setBlocks(world, Blocks.cobblestone.getDefaultState(), new BlockPos[] {
			pos.up().north(2).west(3),
			pos.up().north(3).west(),
			pos.up().south(3).east(),
			pos.up().north().east(3),
			pos.up(2).south().east(2),
			pos.up(2)
		});
		
		world.setBlockState(pos.up(3), ModBlocks.spawner_VoidDragon.getDefaultState());
		world.setBlockState(pos.up(4), Blocks.gravel.getDefaultState()); // Top Block
		
		return true;
	}
}