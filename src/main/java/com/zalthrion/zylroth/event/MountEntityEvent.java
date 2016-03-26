package com.zalthrion.zylroth.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.zylroth.entity.mount.MountBase;
import com.zalthrion.zylroth.entity.mount.MountBaseHorse;
import com.zalthrion.zylroth.handler.MountData;

public class MountEntityEvent {
	@SubscribeEvent public void onEntityMount(EntityMountEvent event) {
		if (!event.isMounting()) {
			if (event.getEntityBeingMounted() instanceof MountBase || event.getEntityBeingMounted() instanceof MountBaseHorse) {
				event.getEntityBeingMounted().setDead();
				if (event.getEntityMounting() instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.getEntityMounting();
					MountData data = MountData.get(player);
					if (data.ownsMount()) {
						data.disownMount();
					}
				}
			}
		}
	}
}