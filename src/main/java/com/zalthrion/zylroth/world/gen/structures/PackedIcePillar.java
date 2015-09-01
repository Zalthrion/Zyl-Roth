package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class PackedIcePillar extends WorldGenerator {
	
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {Blocks.packed_ice, Blocks.ice};
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
	
	public PackedIcePillar() {}
	
	private void setIce(World world, BlockPos pos) {
		world.setBlockState(pos, Blocks.packed_ice.getDefaultState());
	}
	
	private void setIce(World world, BlockPos[] pos) {
		for (BlockPos aPos : pos) {
			setIce(world, aPos);
		}
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		// check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, pos) 
				|| !locationIsValidSpawn(world, pos.east()) 
				|| !locationIsValidSpawn(world, pos.south().east()) 
				|| !locationIsValidSpawn(world, pos.south()) 
				|| !locationIsValidSpawn(world, pos.west()) 
				|| !locationIsValidSpawn(world, pos.north().west()) 
				|| !locationIsValidSpawn(world, pos.north()) 
				|| !locationIsValidSpawn(world, pos.north().east()) 
				|| !locationIsValidSpawn(world, pos.south().west())
				|| !locationIsValidSpawn(world, pos.up().east(2))
		        || !locationIsValidSpawn(world, pos.up().west(2))
		        || !locationIsValidSpawn(world, pos.up().south(2))
		        || !locationIsValidSpawn(world, pos.up().north().east())
		        || !locationIsValidSpawn(world, pos.up().south().west())
		        || !locationIsValidSpawn(world, pos.up().north(2))
		        || !locationIsValidSpawn(world, pos.up().north(2).east())
		        || !locationIsValidSpawn(world, pos.up().north(2).west()))
				{ return false; }
		
		/* z = z - 10; x = x - 10; */
		
		setIce(world, new BlockPos[] {
				pos.up(),
				pos.up().east(),
				pos.up().south(),
				pos.up().west(),
				pos.up().north(),
				pos.up().north().west(),
				pos.up().south().east(),
				pos.up().east(2),
				pos.up().west(2),
				pos.up().south(2),
				pos.up().north().east(),
				pos.up().south().west(),
				pos.up().north(2),
				pos.up().north(2).east(),
				pos.up().north(2).west(),
				pos.up(2),
				pos.up(2).east(),
				pos.up(2).east(2),
				pos.up(2).west(),
				pos.up(2).west(2),
				pos.up(2).south(),
				pos.up(2).south(2),
				pos.up(2).south().east(),
				pos.up(2).south().west(),
				pos.up(2).north(),
				pos.up(2).north().east(),
				pos.up(2).north().west(),
				pos.up(2).north(2),
				pos.up(3),
				pos.up(3).east(),
				pos.up(3).west(),
				pos.up(3).west(2),
				pos.up(3).south(),
				pos.up(3).south().east(),
				pos.up(3).south().west(),
				pos.up(3).south(2),
				pos.up(3).north(),
				pos.up(3).north().west(),
				pos.up(4),
				pos.up(4).east(),
				pos.up(4).west(),
				pos.up(4).north(),
				pos.up(4).south(),
				pos.up(5),
				pos.up(5).east(),
				pos.up(5).west(),
				pos.up(5).south(),
				pos.up(6),
				pos.up(6).west(),
				pos.up(7),
				pos.up(8)
		});
				
		return true;
	}
}