package com.zalthrion.zylroth.block.machine;

public enum InfuserType {
	NORMAL,
	ORE;
	
	public boolean isNormal() {
		return this.equals(NORMAL);
	}
}