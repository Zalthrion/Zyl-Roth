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
	
	boolean locationIsValidSpawn(World world, int floorPos, BlockPos pos) { 
		Block block = world.getBlockState(pos).getBlock();
		if (!(block == Blocks.air) || !(block.isReplaceable(world, pos))) return false;
		if (pos.getY() == floorPos) {
			Block blockUnder = world.getBlockState(pos.down()).getBlock();
			if (blockUnder == Blocks.air) return false;
		}
		return true;
	}
	
	boolean locationIsValidSpawn(World world, BlockPos corner1, BlockPos corner2) {
		int x1 = corner1.getX();
		int y1 = corner1.getY();
		int z1 = corner1.getZ();
		int x2 = corner2.getX();
		int y2 = corner2.getY();
		int z2 = corner2.getZ();
		
		for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x ++) {
			for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y ++) {
				for (int z = Math.min(z1, z2); z <= Math.max(z1, z2); z ++) {
					if (!locationIsValidSpawn(world, y1, new BlockPos(x, y, z))) return false;
				}
			}
		}
		return true;
	}
	
	void setBlocksRandomly(World world, Random rand, IBlockState[] possibleStates, BlockPos[] positions) {
		for (BlockPos aPos : positions) {
			world.setBlockState(aPos, possibleStates[rand.nextInt(possibleStates.length)]);
		}
	}
	
	@Override public boolean generate(World world, Random rand, BlockPos pos) {
		if (!locationIsValidSpawn(world, pos.add(-3, 0, -3), pos.add(3, 4, 3))) return false;
		
		setBlocksRandomly(world, rand, new IBlockState[] {
				Blocks.stone.getDefaultState(),
				Blocks.cobblestone.getDefaultState()
		}, new BlockPos[] {
				/* Layer 1 */
				pos.north(3).west(2),
				pos.north(3).west(),
				pos.north(3),
				pos.north(3).east(),
				pos.north(3).east(2),
				pos.north(2).west(3),
				pos.north(2).west(2),
				pos.north(2).west(),
				pos.north(2),
				pos.north(2).east(),
				pos.north(2).east(2),
				pos.north(2).east(3),
				pos.north().west(3),
				pos.north().west(2),
				pos.north().west(),
				pos.north(),
				pos.north().east(),
				pos.north().east(2),
				pos.north().east(3),
				pos.west(3),
				pos.west(2),
				pos.west(),
				pos,
				pos.east(),
				pos.east(2),
				pos.east(3),
				pos.south().west(3),
				pos.south().west(2),
				pos.south().west(),
				pos.south(),
				pos.south().east(),
				pos.south().east(2),
				pos.south().east(3),
				pos.south(2).west(3),
				pos.south(2).west(2),
				pos.south(2).west(),
				pos.south(2),
				pos.south(2).east(),
				pos.south(2).east(2),
				pos.south(2).east(3),
				pos.south(3).west(2),
				pos.south(3).west(),
				pos.south(3),
				pos.south(3).east(),
				pos.south(3).east(2),
				/* Layer 2 */
				pos.north(2).west().up(),
				pos.north(2).up(),
				pos.north(2).east().up(),
				pos.north().west(2).up(),
				pos.north().west().up(),
				pos.north().up(),
				pos.north().east().up(),
				pos.north().east(2).up(),
				pos.west(2).up(),
				pos.west().up(),
				pos.up(),
				pos.east().up(),
				pos.east(2).up(),
				pos.south().west(2).up(),
				pos.south().west().up(),
				pos.south().up(),
				pos.south().east().up(),
				pos.south().east(2).up(),
				pos.south(2).west().up(),
				pos.south(2).up(),
				pos.south(2).east().up(),
				/* Layer 3 */
				pos.north().up(2),
				pos.west().up(2),
				pos.east().up(2),
				pos.south().up(2)
		});
		
		world.setBlockState(pos.up(2), ModBlocks.spawner_VoidDragon.getDefaultState());
		world.setBlockState(pos.up(3), Blocks.gravel.getDefaultState());
		
		return true;
	}
}