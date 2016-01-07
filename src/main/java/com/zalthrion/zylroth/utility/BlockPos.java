package com.zalthrion.zylroth.utility;

import net.minecraft.util.EnumFacing;

public class BlockPos extends Vec3i {
	public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);
	
	public BlockPos(int x, int y, int z) {
		super(x, y, z);
	}
	
	public BlockPos add(int x, int y, int z) {
		return x == 0 && y == 0 && z == 0 ? this : new BlockPos(this.getX() + x, this.getY() + y, this.getZ() + z);
	}
	
	public BlockPos up() {
		return this.up(1);
	}
	
	public BlockPos up(int n) {
		return this.offset(EnumFacing.UP, n);
	}
	
	public BlockPos down() {
		return this.down(1);
	}
	
	public BlockPos down(int n) {
		return this.offset(EnumFacing.DOWN, n);
	}
	
	public BlockPos north() {
		return this.north(1);
	}
	
	public BlockPos north(int n) {
		return this.offset(EnumFacing.NORTH, n);
	}
	
	public BlockPos south() {
		return this.south(1);
	}
	
	public BlockPos south(int n) {
		return this.offset(EnumFacing.SOUTH, n);
	}
	
	public BlockPos west() {
		return this.west(1);
	}
	
	public BlockPos west(int n) {
		return this.offset(EnumFacing.WEST, n);
	}
	
	public BlockPos east() {
		return this.east(1);
	}
	
	public BlockPos east(int n) {
		return this.offset(EnumFacing.EAST, n);
	}
	
	public BlockPos offset(EnumFacing facing) {
		return this.offset(facing, 1);
	}
	
	public BlockPos offset(EnumFacing facing, int n) {
		return n == 0 ? this : new BlockPos(this.getX() + facing.getFrontOffsetX() * n, this.getY() + facing.getFrontOffsetY() * n, this.getZ() + facing.getFrontOffsetZ() * n);
	}
}