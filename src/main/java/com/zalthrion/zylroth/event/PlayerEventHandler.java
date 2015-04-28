package com.zalthrion.zylroth.event;

import java.util.Iterator;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;

public class PlayerEventHandler {
	@SubscribeEvent public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		if (persistentData.hasKey("ownsMountDeathcharger")) {
			UUID ownedHorse = UUID.fromString(persistentData.getString("ownsMountDeathcharger"));
			persistentData.removeTag("ownsMountDeathcharger");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				@SuppressWarnings("rawtypes")
				Iterator iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountDeathcharger) {
						MountDeathcharger mdc = (MountDeathcharger) obj;
						if (mdc.getUniqueID().equals(ownedHorse)) mdc.setDead();
					}
				}
			}
		}
		
		if (persistentData.hasKey("ownsMountPlaguedHorse")) {
			UUID ownedHorse = UUID.fromString(persistentData.getString("ownsMountPlaguedHorse"));
			persistentData.removeTag("ownsMountPlaguedHorse");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				@SuppressWarnings("rawtypes")
				Iterator iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountPlaguedHorse) {
						MountPlaguedHorse mph = (MountPlaguedHorse) obj;
						if (mph.getUniqueID().equals(ownedHorse)) mph.setDead();
					}
				}
			}
		}
	}
}