package com.zalthrion.zylroth.utility;

import net.minecraft.util.MathHelper;

import com.google.common.base.Objects;

public class Vec3i implements Comparable<Vec3i> {
	private final int x;
	private final int y;
	private final int z;
	
	public Vec3i(int xIn, int yIn, int zIn) {
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
	}
	
	public Vec3i(double xIn, double yIn, double zIn) {
		this(MathHelper.floor_double(xIn), MathHelper.floor_double(yIn), MathHelper.floor_double(zIn));
	}
	
	@Override public boolean equals(Object p_equals_1_) {
		if (this == p_equals_1_) {
			return true;
		} else if (!(p_equals_1_ instanceof Vec3i)) {
			return false;
		} else {
			Vec3i vec3i = (Vec3i) p_equals_1_;
			return this.getX() != vec3i.getX() ? false : (this.getY() != vec3i.getY() ? false : this.getZ() == vec3i.getZ());
		}
	}
	
	@Override public int hashCode() {
		return (this.getY() + this.getZ() * 31) * 31 + this.getX();
	}
	
	@Override public int compareTo(Vec3i p_compareTo_1_) {
		return this.getY() == p_compareTo_1_.getY() ? (this.getZ() == p_compareTo_1_.getZ() ? this.getX() - p_compareTo_1_.getX() : this.getZ() - p_compareTo_1_.getZ()) : this.getY() - p_compareTo_1_.getY();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getZ() {
		return this.z;
	}
	
	@Override public String toString() {
		return Objects.toStringHelper(this).add("x", this.getX()).add("y", this.getY()).add("z", this.getZ()).toString();
	}
}