package com.zalthrion.zylroth.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBase extends Container {
	@Override public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
}