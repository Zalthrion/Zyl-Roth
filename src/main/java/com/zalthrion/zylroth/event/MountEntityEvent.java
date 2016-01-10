package com.zalthrion.zylroth.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.zalthrion.zylroth.entity.mount.MountBase;
import com.zalthrion.zylroth.entity.mount.MountBaseHorse;

public class MountEntityEvent {
	@SubscribeEvent public void onEntityMount(EntityMountEvent event) {
		if (!event.isMounting()) {
			if (event.entityBeingMounted instanceof MountBase || event.entityBeingMounted instanceof MountBaseHorse) {
				event.entityBeingMounted.setDead();
				if (event.entityMounting instanceof EntityPlayer) {
					EntityPlayer player = (EntityPlayer) event.entityMounting;
					NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
					if (persistentData.hasKey("ownsMount")) {
						persistentData.removeTag("ownsMount");
						persistentData.removeTag("ownedMountId");
						persistentData.removeTag("ownsMountSavageBadger");
						persistentData.removeTag("ownsMountPlaguedHorse");
						persistentData.removeTag("ownsMountDeathcharger");
						persistentData.removeTag("ownsMountSwiftUnicorn");
						persistentData.removeTag("ownsMountWarTortoise");
						player.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, persistentData);
					}
				}
			}
		}
	}
}