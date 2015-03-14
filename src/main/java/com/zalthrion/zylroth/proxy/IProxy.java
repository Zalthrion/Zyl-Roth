package com.zalthrion.zylroth.proxy;

public interface IProxy {
	public abstract void init();
	
	public abstract void registerRenderers();
	
	public abstract void registerItems();
	
	public abstract void registerBlocks();
}