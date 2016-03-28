package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum TreeColor implements IStringSerializable {
	RED(0, "red", MapColor.redColor),
	ORANGE(1, "orange", MapColor.adobeColor),
	YELLOW(2, "yellow", MapColor.yellowColor),
	GREEN(3, "green", MapColor.greenColor),
	BLUE(4, "blue", MapColor.blueColor),
	PURPLE(5, "purple", MapColor.purpleColor);
	
	private static final TreeColor[] META_LOOKUP = new TreeColor[values().length];
	private int meta;
	private String name;
	private final MapColor mapColor;
	
	private TreeColor(int meta, String name, MapColor mapColor) {
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
	
	public static TreeColor byMetadata(int meta) {
		if (meta < 0 || meta >= META_LOOKUP.length) {
			meta = 0;
		}
		
		return META_LOOKUP[meta];
	}
	
	@Override public String getName() {
		return this.name;
	}
	
	static {
		for (TreeColor treecolor : values()) {
			META_LOOKUP[treecolor.getMetadata()] = treecolor;
		}
	}
}