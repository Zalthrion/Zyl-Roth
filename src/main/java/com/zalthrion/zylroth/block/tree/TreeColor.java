package com.zalthrion.zylroth.block.tree;

import net.minecraft.util.IStringSerializable;

public enum TreeColor implements IStringSerializable {
	RED(0, "red"),
	ORANGE(1, "orange"),
	YELLOW(2, "yellow"),
	GREEN(3, "green"),
	BLUE(4, "blue"),
	// Sorry indigo, you're not important.
	PURPLE(5, "purple");
	
	private String name;
	private int meta;
	
	private TreeColor(int meta, String name) {
		this.name = name;
		this.meta = meta;
	}
	
	@Override public String getName() {
		return this.name;
	}
	
	public int getMeta() {
		return this.meta;
	}

	public static TreeColor get(int meta2) {
		for (TreeColor color : values()) {
			if (color.getMeta() == meta2) return color;
		}
		return RED;
	}
}