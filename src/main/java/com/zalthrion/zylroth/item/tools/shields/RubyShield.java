package com.zalthrion.zylroth.item.tools.shields;

import com.zalthrion.zylroth.item.tools.ZylrothTool;

import net.minecraft.item.ItemStack;

public class RubyShield extends ShieldBase implements ZylrothTool {

	@Override
	public boolean isBroken(ItemStack stack) {
		return false;
	}
}
