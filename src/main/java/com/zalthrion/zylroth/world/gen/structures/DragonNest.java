package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.zalthrion.zylroth.lib.ModBlocks;

public class DragonNest extends WorldGenerator implements IWorldGenerator {
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {Blocks.grass};
	}
	
	public boolean locationIsValidSpawn(World world, BlockPos pos) {
		int distanceToAir = 0;
		Block check = world.getBlockState(pos).getBlock();
		
		while (check != Blocks.air) {
			if (distanceToAir > 3) { return false; }
			
			distanceToAir ++;
			check = world.getBlockState(pos.up(distanceToAir)).getBlock();
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
	
	public DragonNest() {}
	
	/*
	 * For compatibility until I can be asked
	 */
	@Deprecated
	public void setBlock(World world, int x, int y, int z, Block block, int metadata) {
		setBlock(world, new BlockPos(x, y, z), block.getDefaultState(), metadata);
	}
	
	@Override
	public void setBlock(World world, BlockPos pos, Block block, int metadata) {
		setBlock(world, pos, block.getDefaultState(), metadata);
	}
	
	public void setBlock(World world, BlockPos pos, IBlockState state, int metadata) {
		Block b1 = world.getBlockState(pos).getBlock();
		
		if (b1.isAir(world, pos) || b1.isLeaves(world, pos)) {
			world.setBlockState(pos, state);
		}
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		// check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, pos) || !locationIsValidSpawn(world, pos.east(6)) || !locationIsValidSpawn(world, pos.east(6).south(6)) || !locationIsValidSpawn(world, pos.south(6))) { return false; }
		
		pos = pos.north(10).west(10);
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		/*
		 * +X - East
		 * -X - West
		 * +Z - South
		 * -Z - North
		 */
		this.setBlock(world, pos, Blocks.air, 0);
		this.setBlock(world, pos.south(), Blocks.cobblestone, 0);
		this.setBlock(world, pos.south(2), Blocks.stone, 0);
		this.setBlock(world, pos.south(3), Blocks.stone, 0);
		this.setBlock(world, pos.south(4), Blocks.stone, 0);
		this.setBlock(world, pos.south(5), Blocks.stone, 0);
		this.setBlock(world, pos.south(6), Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 0, j + 2, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 0, k + 6, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 1, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 1, j + 1, k + 4, Blocks.cobblestone, 0);
		this.setBlock(world, i + 1, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 1, j + 2, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 0, k + 0, Blocks.cobblestone, 0);
		this.setBlock(world, i + 2, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 0, k + 6, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 1, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 2, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 2, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 2, j + 2, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 2, j + 2, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 0, k + 6, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 1, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 1, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 1, k + 3, Blocks.cobblestone, 0);
		this.setBlock(world, i + 3, j + 1, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 1, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 2, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 2, k + 3, ModBlocks.Spawner_VoidDragon, 0);
		this.setBlock(world, i + 3, j + 2, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 3, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 3, j + 2, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 0, k + 6, Blocks.cobblestone, 0);
		this.setBlock(world, i + 4, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 1, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 1, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 1, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 1, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 1, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 2, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 2, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 4, j + 2, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 4, j + 2, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 0, k + 0, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 0, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 0, k + 6, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 2, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 1, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 1, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 5, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 5, j + 2, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 0, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 0, k + 1, Blocks.stone, 0);
		this.setBlock(world, i + 6, j + 0, k + 2, Blocks.cobblestone, 0);
		this.setBlock(world, i + 6, j + 0, k + 3, Blocks.stone, 0);
		this.setBlock(world, i + 6, j + 0, k + 4, Blocks.stone, 0);
		this.setBlock(world, i + 6, j + 0, k + 5, Blocks.stone, 0);
		this.setBlock(world, i + 6, j + 0, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 1, k + 6, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 0, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 1, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 2, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 3, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 4, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 5, Blocks.air, 0);
		this.setBlock(world, i + 6, j + 2, k + 6, Blocks.air, 0);
		
		return true;
	}

	@Override public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {}
}