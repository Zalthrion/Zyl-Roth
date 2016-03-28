package com.zalthrion.zylroth.block.tile;

import net.minecraft.util.IStringSerializable;

public enum InfuserType implements IStringSerializable {
	NORMAL,
	ORE;

	public boolean isNormal() {
		return this.equals(NORMAL);
	}

	@Override public String getName() {
		return this.name().toLowerCase();
	}
}