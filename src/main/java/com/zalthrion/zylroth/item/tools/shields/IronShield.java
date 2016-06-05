package com.zalthrion.zylroth.item.tools.shields;

import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.ShieldBase;
import com.zalthrion.zylroth.item.tools.ZylrothTool;

public class IronShield extends ShieldBase implements ZylrothTool {
	public IronShield() {
		super();
		this.setCreativeTab();
		this.setNames("ironShield");
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return false;
	}
}