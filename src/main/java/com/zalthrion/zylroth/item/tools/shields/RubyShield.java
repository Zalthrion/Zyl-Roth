package com.zalthrion.zylroth.item.tools.shields;

import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.ShieldBase;
import com.zalthrion.zylroth.item.tools.ZylrothTool;

public class RubyShield extends ShieldBase implements ZylrothTool {
	public RubyShield() {
		super();
		this.setCreativeTab();
		this.setNames("rubyShield");
	}
	
	@Override public boolean isBroken(ItemStack stack) {
		return false;
	}
}