package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum KyrulTreeType implements IStringSerializable {
	VOID(0, "void", MapColor.PURPLE);
	
	private static final KyrulTreeType[] META_LOOKUP = new KyrulTreeType[values().length];
	private int meta;
	private String name;
	private final MapColor mapColor;
	
	private KyrulTreeType(int meta, String name, MapColor mapColor) {
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
	
	public static KyrulTreeType byMetadata(int meta) {
		if (meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}
		
		return META_LOOKUP[meta];
	}
	
	@Override public String getName() {
		return this.name;
	}
	
	static {
		for (KyrulTreeType treecolor : values()) {
			META_LOOKUP[treecolor.getMetadata()] = treecolor;
		}
	}
}