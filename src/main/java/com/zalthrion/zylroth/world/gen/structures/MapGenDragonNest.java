package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.zalthrion.zylroth.utility.LogHelper;

public class MapGenDragonNest extends WorldGenerator implements IWorldGenerator {
	
	public MapGenDragonNest() {}
	
	 // For compatibility until I can be asked
	 
	@Deprecated
	public void setBlock(World world, int x, int y, int z, Block block, int metadata) {
		setBlock(world, new BlockPos(x, y, z), block.getDefaultState(), metadata);
	}
	
	@Override public void setBlock(World world, BlockPos pos, Block block, int metadata) {
		setBlock(world, pos, block.getDefaultState(), metadata);
	}
	
	public void setBlock(World world, BlockPos pos, IBlockState state, int metadata) {
		Block b1 = world.getBlockState(pos).getBlock();
		
		if (b1.isAir(world, pos) || b1.isLeaves(world, pos)) {
			world.setBlockState(pos, state);
		}
	}
	
	@Override public boolean generate(World world, Random rand, BlockPos pos) {
		return false;
	}
	
	public boolean generate(World world, Random rand, BlockPos pos, ChunkPrimer primer) {
		if (rand.nextInt(10) != 0) return false;
		int highestPoint = 0;
		for (int x = 0; x < 16; x ++) {
			zLoop: for (int z = 0; z < 16; z ++) {
				for (int y = 255; y > highestPoint; y --) {
					if (primer.getBlockState(x, y, z) != Blocks.air.getDefaultState() && primer.getBlockState(x, y, z).getBlock().isFullCube()) {
						highestPoint = y;
						continue zLoop;
					}
				}
			}
		}
		
		for (int x = 0; x < 16; x ++) {
			zLoop: for (int z = 0; z < 16; z ++) {
				for (int y = highestPoint; y > 0; y --) {
					if (primer.getBlockState(x, y, z) != Blocks.air.getDefaultState() && primer.getBlockState(x, y, z).getBlock().isFullCube()) {
						continue zLoop;
					} else {
						primer.setBlockState(x, y, z, rand.nextBoolean() ? Blocks.cobblestone.getDefaultState() : Blocks.mossy_cobblestone.getDefaultState());
					}
				}
			}
		}
		
		LogHelper.warn(pos.getX() + ", " + highestPoint + ", " + pos.getZ());
		primer.setBlockState(0, highestPoint, 0, Blocks.gold_block.getDefaultState());
		
/*		pos = pos.north(10).west(10);
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();*/
		
		
		 // * +X - East
		 // * -X - West
		 // * +Z - South
		 // * -Z - North
		
/*		IBlockState AIR = Blocks.air.getDefaultState();
		IBlockState COBBLESTONE = Blocks.cobblestone.getDefaultState();
		IBlockState STONE = Blocks.stone.getDefaultState();
		primer.setBlockState(i, j, k, Blocks.air.getDefaultState());
		primer.setBlockState(i, j - 1, k, COBBLESTONE);
		primer.setBlockState(i, j - 2, k, STONE);
		primer.setBlockState(i, j - 3, k, STONE);
		primer.setBlockState(i, j - 4, k, STONE);
		primer.setBlockState(i, j - 5, k, STONE);
		primer.setBlockState(i, j - 6, k, AIR);*/
/*		this.setBlock(world, i + 0, j + 1, k + 0, Blocks.air, 0);
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
		this.setBlock(world, i + 3, j + 2, k + 3, ModBlocks.spawner_VoidDragon, 0);
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
		this.setBlock(world, i + 6, j + 2, k + 6, Blocks.air, 0);*/
		
		return true;
	}
	
	@Override public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {}
}