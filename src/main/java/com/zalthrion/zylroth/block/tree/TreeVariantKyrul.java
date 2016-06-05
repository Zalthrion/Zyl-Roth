package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum TreeVariantKyrul implements IStringSerializable {
	VOID(0, "void", MapColor.PURPLE);
	
	private static final TreeVariantKyrul[] META_LOOKUP = new TreeVariantKyrul[values().length];
	private int meta;
	private String name;
	private final MapColor mapColor;
	
	private TreeVariantKyrul(int meta, String name, MapColor mapColor) {
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
	
	public static TreeVariantKyrul byMetadata(int meta) {
		if (meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}
		
		return META_LOOKUP[meta];
	}
	
	@Override public String getName() {
		return this.name;
	}
	
	static {
		for (TreeVariantKyrul treecolor : values()) {
			META_LOOKUP[treecolor.getMetadata()] = treecolor;
		}
	}
}