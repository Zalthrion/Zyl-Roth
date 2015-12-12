package com.zalthrion.zylroth.item.mount;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import com.zalthrion.zylroth.item.ItemBase;

public class SummoningCrystalBase extends ItemBase {
	public String baseName = "Summoning-Crystal";
	private EntityPlayer player;
	
	public boolean isEntity(Entity entity) {
		if (entity instanceof EntityPlayer) {
			entity = this.player;
		}
		return this.isEntity(entity);
	}
}