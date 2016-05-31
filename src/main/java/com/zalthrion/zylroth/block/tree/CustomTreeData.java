package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.state.IBlockState;

public class CustomTreeData {
	private IBlockState logState;
	private IBlockState leavesState;
	private int minimumHeight;
	private boolean hasVines;
	
	public CustomTreeData(IBlockState logState, IBlockState leavesState) {
		this.logState = logState;
		this.leavesState = leavesState;
	}
	
	public boolean getHasVines() {
		return this.hasVines;
	}
	
	public IBlockState getLogState() {
		return this.logState;
	}
	
	public IBlockState getLeavesState() {
		return this.leavesState;
	}
	
	public int getMinimumHeight() {
		return this.minimumHeight;
	}
	
	public CustomTreeData setMinimumHeight(int minimumHeight) {
		this.minimumHeight = minimumHeight;
		return this;
	}
	
	public CustomTreeData setHasVines(boolean hasVines) {
		this.hasVines = hasVines;
		return this;
	}
}