package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum TreeVariantIridis implements IStringSerializable {
	AUTUMN(0, "autumn", MapColor.RED),
	SAKURA(1, "sakura", MapColor.ADOBE); // TODO Check this
	
	private static final TreeVariantIridis[] META_LOOKUP = new TreeVariantIridis[values().length];
	private int meta;
	private String name;
	private final MapColor mapColor;
	
	private TreeVariantIridis(int meta, String name, MapColor mapColor) {
		this.name = name;
		this.meta = meta;
		this.mapColor = mapColor;
	}
	
	public int getMetadata() {
		return this.meta;
	}

	public MapColor getMapColor() {
		return this.mapColor;
	}
	
	@Override public String toString() {
		return this.name;
	}
	
	public static TreeVariantIridis byMetadata(int meta) {
		if (meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}
		
		return META_LOOKUP[meta];
	}
	
	@Override public String getName() {
		return this.name;
	}
	
	static {
		for (TreeVariantIridis treecolor : values()) {
			META_LOOKUP[treecolor.getMetadata()] = treecolor;
		}
	}
}