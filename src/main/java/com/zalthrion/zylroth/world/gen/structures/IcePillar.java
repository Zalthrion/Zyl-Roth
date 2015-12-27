package com.zalthrion.zylroth.world.gen.structures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class IcePillar extends WorldGenerator {
	boolean isPacked = false;
	BlockPos mainPos;
	ArrayList<BlockPos> blockPositions;
	
	public IcePillar(int direction, BlockPos mainPos) {
		this.mainPos = mainPos;
		this.blockPositions = new ArrayList<BlockPos>();
		if (direction == 0) this.faceNorth();
		if (direction == 1) this.faceEast();
		if (direction == 2) this.faceSouth();
		if (direction == 3) this.faceWest();
	}
	
	public IcePillar setPacked() {
		this.isPacked = true;
		return this;
	}
	
	/* No matter which direction the pillar is facing, there is a block in this location. */
	void addCommonBlockLocations() {
		/* Layer 1 */
		this.blockPositions.add(this.mainPos);
		this.blockPositions.add(this.mainPos.north());
		this.blockPositions.add(this.mainPos.east());
		this.blockPositions.add(this.mainPos.west());
		this.blockPositions.add(this.mainPos.south());
		this.blockPositions.add(this.mainPos.north(2));
		this.blockPositions.add(this.mainPos.east(2));
		this.blockPositions.add(this.mainPos.west(2));
		this.blockPositions.add(this.mainPos.south(2));
		this.blockPositions.add(this.mainPos.north().west());
		this.blockPositions.add(this.mainPos.north().east());
		this.blockPositions.add(this.mainPos.south().west());
		this.blockPositions.add(this.mainPos.south().east());
		/* Layer 2 */
		this.blockPositions.add(this.mainPos.up());
		this.blockPositions.add(this.mainPos.up().north());
		this.blockPositions.add(this.mainPos.up().east());
		this.blockPositions.add(this.mainPos.up().south());
		this.blockPositions.add(this.mainPos.up().west());
		this.blockPositions.add(this.mainPos.up().north(2));
		this.blockPositions.add(this.mainPos.up().east(2));
		this.blockPositions.add(this.mainPos.up().south(2));
		this.blockPositions.add(this.mainPos.up().west(2));
		this.blockPositions.add(this.mainPos.up().north().west());
		this.blockPositions.add(this.mainPos.up().north().east());
		this.blockPositions.add(this.mainPos.up().south().west());
		this.blockPositions.add(this.mainPos.up().south().east());
		/* Layer 3 */
		this.blockPositions.add(this.mainPos.up(2));
		this.blockPositions.add(this.mainPos.up(2).north());
		this.blockPositions.add(this.mainPos.up(2).east());
		this.blockPositions.add(this.mainPos.up(2).south());
		this.blockPositions.add(this.mainPos.up(2).west());
		/* Layer 4 */
		this.blockPositions.add(this.mainPos.up(3));
		this.blockPositions.add(this.mainPos.up(3).north());
		this.blockPositions.add(this.mainPos.up(3).east());
		this.blockPositions.add(this.mainPos.up(3).south());
		this.blockPositions.add(this.mainPos.up(3).west());
		/* Layer 5 */
		this.blockPositions.add(this.mainPos.up(4));
		/* Layer 6 */
		this.blockPositions.add(this.mainPos.up(5));
		/* Layer 7 */
		this.blockPositions.add(this.mainPos.up(6));
		/* Layer 8 */
		this.blockPositions.add(this.mainPos.up(7));
	}
	
	void faceNorth() {
		this.blockPositions.clear();
		this.addCommonBlockLocations();
		/* Layer 1 */
		this.blockPositions.add(this.mainPos.north(2).west());
		this.blockPositions.add(this.mainPos.north(2).east());
		/* Layer 3 */
		this.blockPositions.add(this.mainPos.up(2).north().west());
		this.blockPositions.add(this.mainPos.up(2).west(2));
		this.blockPositions.add(this.mainPos.up(2).south().west());
		this.blockPositions.add(this.mainPos.up(2).south().east());
		this.blockPositions.add(this.mainPos.up(2).south(2));
		/* Layer 5 */
		this.blockPositions.add(this.mainPos.up(4).west());
		this.blockPositions.add(this.mainPos.up(4).east());
		this.blockPositions.add(this.mainPos.up(4).south());
		/* Layer 6 */
		this.blockPositions.add(this.mainPos.up(5).west());
	}
	
	void faceEast() {
		this.blockPositions.clear();
		this.addCommonBlockLocations();
		/* Layer 1 */
		this.blockPositions.add(this.mainPos.east(2).north());
		this.blockPositions.add(this.mainPos.east(2).south());
		/* Layer 3 */
		this.blockPositions.add(this.mainPos.up(2).east().north());
		this.blockPositions.add(this.mainPos.up(2).north(2));
		this.blockPositions.add(this.mainPos.up(2).west().north());
		this.blockPositions.add(this.mainPos.up(2).west().south());
		this.blockPositions.add(this.mainPos.up(2).west(2));
		/* Layer 5 */
		this.blockPositions.add(this.mainPos.up(4).north());
		this.blockPositions.add(this.mainPos.up(4).south());
		this.blockPositions.add(this.mainPos.up(4).west());
		/* Layer 6 */
		this.blockPositions.add(this.mainPos.up(5).north());
	}
	
	void faceSouth() {
		this.blockPositions.clear();
		this.addCommonBlockLocations();
		/* Layer 1 */
		this.blockPositions.add(this.mainPos.south(2).east());
		this.blockPositions.add(this.mainPos.south(2).west());
		/* Layer 3 */
		this.blockPositions.add(this.mainPos.up(2).south().east());
		this.blockPositions.add(this.mainPos.up(2).east(2));
		this.blockPositions.add(this.mainPos.up(2).north().east());
		this.blockPositions.add(this.mainPos.up(2).north().west());
		this.blockPositions.add(this.mainPos.up(2).north(2));
		/* Layer 5 */
		this.blockPositions.add(this.mainPos.up(4).east());
		this.blockPositions.add(this.mainPos.up(4).west());
		this.blockPositions.add(this.mainPos.up(4).north());
		/* Layer 6 */
		this.blockPositions.add(this.mainPos.up(5).east());
	}
	
	void faceWest() {
		this.blockPositions.clear();
		this.addCommonBlockLocations();
		/* Layer 1 */
		this.blockPositions.add(this.mainPos.west(2).south());
		this.blockPositions.add(this.mainPos.west(2).north());
		/* Layer 3 */
		this.blockPositions.add(this.mainPos.up(2).west().south());
		this.blockPositions.add(this.mainPos.up(2).south(2));
		this.blockPositions.add(this.mainPos.up(2).east().south());
		this.blockPositions.add(this.mainPos.up(2).east().north());
		this.blockPositions.add(this.mainPos.up(2).east(2));
		/* Layer 5 */
		this.blockPositions.add(this.mainPos.up(4).south());
		this.blockPositions.add(this.mainPos.up(4).north());
		this.blockPositions.add(this.mainPos.up(4).east());
		/* Layer 6 */
		this.blockPositions.add(this.mainPos.up(5).south());
	}
	
	boolean locationIsValidSpawn(World world, int floorPos, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if(!(block == Blocks.air) || !(block.isReplaceable(world, pos))) return false;
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
	
	void setIce(World world, BlockPos[] pos) {
		for (BlockPos aPos : pos) {
			world.setBlockState(aPos, this.isPacked ? Blocks.packed_ice.getDefaultState() : Blocks.ice.getDefaultState());
		}
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		if (!locationIsValidSpawn(world, pos.add(-2, 0, -2), pos.add(2, 7, 2))) return false;
		setIce(world, this.blockPositions.toArray(new BlockPos[]{}));
		return true;
	}
}