package com.zalthrion.zylroth.proxy;

public interface IProxy {
	public abstract void init();
	public abstract void bindTileEntitySpecialRenderers();
	public abstract void registerRenderers();
	public abstract void registerRenderInformation();
	public abstract void registerItemRenderers();
}