package com.zalthrion.zylroth.item.tools.shields;

import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.ShieldBase;
import com.zalthrion.zylroth.item.tools.ZylrothTool;

public class RubyShield extends ShieldBase implements ZylrothTool {

	@Override
	public boolean isBroken(ItemStack stack) {
		return false;
	}
}