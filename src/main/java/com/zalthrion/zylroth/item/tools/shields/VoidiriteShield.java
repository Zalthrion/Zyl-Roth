package com.zalthrion.zylroth.item.tools.shields;

import com.zalthrion.zylroth.item.tools.ZylrothTool;

import net.minecraft.item.ItemStack;

public class VoidiriteShield extends ShieldBase implements ZylrothTool {

	private String name = "voidiriteShield";
	
	public VoidiriteShield() {
		super();
		this.setNames(name);
	}

	@Override
	public boolean isBroken(ItemStack stack) {
		return false;
	}
}
