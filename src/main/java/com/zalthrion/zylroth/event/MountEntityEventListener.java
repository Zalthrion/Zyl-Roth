package com.zalthrion.zylroth.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.entity.mount.MountBase;
import com.zalthrion.zylroth.entity.mount.MountBaseHorse;
import com.zalthrion.zylroth.handler.MountCapability.MountData;

public class MountEntityEventListener {
	@SubscribeEvent public void onEntityMount(EntityMountEvent event) {
		if (!event.isMounting()) {
			if (event.getEntityBeingMounted() instanceof MountBase || event.getEntityBeingMounted() instanceof MountBaseHorse) {
				event.getEntityBeingMounted().setDead();
				if (event.getEntityMounting() instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.getEntityMounting();
					MountData data = player.getCapability(Zylroth.MOUNT_CAP, null);
					if (data.ownsMount()) {
						data.disownMount();
					}
				}
			}
		}
	}
}