package com.zalthrion.zylroth.item.tools.shields;

import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.ShieldBase;
import com.zalthrion.zylroth.item.tools.ZylrothTool;

public class VoidiriteShield extends ShieldBase implements ZylrothTool {
	public VoidiriteShield() {
		super();
		this.setCreativeTab();
		this.setNames("voidiriteShield");
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return false;
	}
}