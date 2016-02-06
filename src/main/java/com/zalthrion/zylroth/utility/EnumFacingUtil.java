package com.zalthrion.zylroth.utility;

import net.minecraft.util.EnumFacing;

public class EnumFacingUtil {
	public static EnumFacing getOpposite(EnumFacing origin) {
		if (origin == EnumFacing.DOWN) return EnumFacing.UP;
		if (origin == EnumFacing.UP) return EnumFacing.DOWN;
		if (origin == EnumFacing.SOUTH) return EnumFacing.NORTH;
		if (origin == EnumFacing.NORTH) return EnumFacing.SOUTH;
		if (origin == EnumFacing.WEST) return EnumFacing.EAST;
		if (origin == EnumFacing.EAST) return EnumFacing.WEST;
		return null;
	}
	
	public static EnumFacing forPlacing(int facing) {
		if (facing == 2) return EnumFacing.NORTH;
		if (facing == 3) return EnumFacing.EAST;
		if (facing == 4) return EnumFacing.SOUTH;
		if (facing == 5) return EnumFacing.WEST;
		return null;
	}
	
	public static int toInt(EnumFacing origin) {
		if (origin == EnumFacing.DOWN) return 0;
		if (origin == EnumFacing.UP) return 1;
		if (origin == EnumFacing.SOUTH) return 2;
		if (origin == EnumFacing.NORTH) return 3;
		if (origin == EnumFacing.WEST) return 4;
		if (origin == EnumFacing.EAST) return 5;
		return 0;
	}
	
	public static EnumFacing fromInt(short short1) {
		if (short1 == 0) return EnumFacing.DOWN;
		if (short1 == 1) return EnumFacing.UP;
		if (short1 == 2) return EnumFacing.SOUTH;
		if (short1 == 3) return EnumFacing.NORTH;
		if (short1 == 4) return EnumFacing.WEST;
		if (short1 == 5) return EnumFacing.EAST;
		return null;
	}
	
	public static EnumFacing rotateAround(EnumFacing origin, Axis axis) {
		switch (axis) {
			case X:
				if (origin != EnumFacing.WEST && origin != EnumFacing.EAST) {
					return rotateX(origin);
				}
			case Y:
				if (origin != EnumFacing.UP && origin != EnumFacing.DOWN) {
					return rotateY(origin);
				}
			case Z:
				if (origin != EnumFacing.NORTH && origin != EnumFacing.SOUTH) {
					return rotateZ(origin);
				}
		}
		return origin;
	}

	@SuppressWarnings("incomplete-switch") public static EnumFacing rotateY(EnumFacing origin) {
		switch (origin) {
			case NORTH:
				return EnumFacing.EAST;
			case EAST:
				return EnumFacing.SOUTH;
			case SOUTH:
				return EnumFacing.WEST;
			case WEST:
				return EnumFacing.NORTH;
		}
		return origin;
	}
	
	@SuppressWarnings("incomplete-switch") private static EnumFacing rotateX(EnumFacing origin) {
		switch (origin) {
			case NORTH:
				return EnumFacing.DOWN;
			case SOUTH:
				return EnumFacing.UP;
			case UP:
				return EnumFacing.NORTH;
			case DOWN:
				return EnumFacing.SOUTH;
		}
		return origin;
	}
	
	@SuppressWarnings("incomplete-switch") private static EnumFacing rotateZ(EnumFacing origin) {
		switch (origin) {
			case EAST:
				return EnumFacing.DOWN;
			case WEST:
				return EnumFacing.UP;
			case UP:
				return EnumFacing.EAST;
			case DOWN:
				return EnumFacing.WEST;
		}
		return origin;
	}
	
	public static enum Axis {
		X("x"),
		Y("y"),
		Z("z");
		
		private final String name;
		
		private Axis(String name) {
			this.name = name;
		}
		
		@Override public String toString() {
			return this.name;
		}
	}
}