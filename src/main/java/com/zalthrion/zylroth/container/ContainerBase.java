package com.zalthrion.zylroth.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBase extends Container {
	@Override public boolean canInteractWith(EntityPlayer entityPlayer) {
		return true;
	}
}