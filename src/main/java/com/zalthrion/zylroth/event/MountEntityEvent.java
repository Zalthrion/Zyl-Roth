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
			if (event.entityBeingMounted instanceof MountBase || event.entityBeingMounted instanceof MountBaseHorse) {
				event.entityBeingMounted.setDead();
				if (event.entityMounting instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.entityMounting;
					MountData data = MountData.get(player);
					if (data.ownsMount()) {
						data.disownMount();
					}
				}
			}
		}
	}
}