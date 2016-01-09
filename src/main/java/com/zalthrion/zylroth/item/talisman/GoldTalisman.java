package com.zalthrion.zylroth.item.talisman;

import com.zalthrion.zylroth.item.ItemBase;

public class GoldTalisman extends ItemBase {
	private String name = "goldTalisman";
	
	public GoldTalisman() {
		super();
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
}