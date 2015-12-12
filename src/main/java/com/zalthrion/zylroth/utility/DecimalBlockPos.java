package com.zalthrion.zylroth.utility;

import net.minecraft.util.BlockPos;

public class DecimalBlockPos {
	
	private BlockPos original;
	private double xOff;
	private double yOff;
	private double zOff;
	
	public DecimalBlockPos(BlockPos pos, double x, double y, double z) {
		this.original = pos;
		this.xOff = x;
		this.yOff = y;
		this.zOff = z;
	}
	
	public BlockPos getOriginal() {
		return this.original;
	}
	
	public double getX() {
		return this.original.getX() + this.xOff;
	}
	
	public double getY() {
		return this.original.getY() + this.yOff;
	}
	
	public double getZ() {
		return this.original.getZ() + this.zOff;
	}
	
	public DecimalBlockPos add(double x, double y, double z) {
		return new DecimalBlockPos(this.original, this.xOff + x, this.yOff + y, this.zOff + z);
	}
	
	public static DecimalBlockPos fromBlockPos(BlockPos pos) {
		return new DecimalBlockPos(pos, 0, 0, 0);
	}
}