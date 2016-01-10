package com.zalthrion.zylroth.event;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerEventHandler {
	@SubscribeEvent
	public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
/*		EntityPlayer player = event.player;
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		
		if (persistentData.hasKey("ownsMount")) {
			UUID ownedMount = UUID.fromString(persistentData.getString("ownsMount"));
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				Iterator<Entity> iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Entity entity = iterator.next();
					if (entity.getUniqueID().equals(ownedMount)) entity.setDead();
				}
			}
			
			persistentData.removeTag("ownsMount");
			persistentData.removeTag("ownedMountId");
			persistentData.removeTag("ownsMountSavageBadger");
			persistentData.removeTag("ownsMountPlaguedHorse");
			persistentData.removeTag("ownsMountDeathcharger");
			persistentData.removeTag("ownsMountSwiftUnicorn");
			persistentData.removeTag("ownsMountWarTortoise");
		}*/
		
/*		if (persistentData.hasKey("ownsMountDeathcharger")) {
			UUID ownedMount = UUID.fromString(persistentData.getString("ownsMountDeathcharger"));
			persistentData.removeTag("ownsMountDeathcharger");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				Iterator<Entity> iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountDeathcharger) {
						MountDeathcharger mdc = (MountDeathcharger) obj;
						if (mdc.getUniqueID().equals(ownedMount)) mdc.setDead();
					}
				}
			}
		}
		
		if (persistentData.hasKey("ownsMountPlaguedHorse")) {
			UUID ownedMount = UUID.fromString(persistentData.getString("ownsMountPlaguedHorse"));
			persistentData.removeTag("ownsMountPlaguedHorse");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				Iterator<Entity> iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountPlaguedHorse) {
						MountPlaguedHorse mph = (MountPlaguedHorse) obj;
						if (mph.getUniqueID().equals(ownedMount)) mph.setDead();
					}
				}
			}
		}
		
		if (persistentData.hasKey("ownsMountWarTortoise")) {
			UUID ownedMount = UUID.fromString(persistentData.getString("ownsMountWarTortoise"));
			persistentData.removeTag("ownsMountWarTortoise");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				Iterator<Entity> iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountPlaguedHorse) {
						MountPlaguedHorse mph = (MountPlaguedHorse) obj;
						if (mph.getUniqueID().equals(ownedMount)) mph.setDead();
					}
				}
			}
		}
		
		if (persistentData.hasKey("ownsMountSavageBadger")) {
			UUID ownedMount = UUID.fromString(persistentData.getString("ownsMountSavageBadger"));
			persistentData.removeTag("ownsMountSavageBadger");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				Iterator<Entity> iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountSavageBadger) {
						MountSavageBadger mdc = (MountSavageBadger) obj;
						if (mdc.getUniqueID().equals(ownedMount)) mdc.setDead();
					}
				}
			}
		}
		
		if (persistentData.hasKey("ownsMountSwiftUnicorn")) {
			UUID ownedMount = UUID.fromString(persistentData.getString("ownsMountSwiftUnicorn"));
			persistentData.removeTag("ownsMountSwiftUnicorn");
			WorldServer[] worlds = FMLCommonHandler.instance().getMinecraftServerInstance().worldServers;
			for (WorldServer world : worlds) {
				Iterator<Entity> iterator = world.loadedEntityList.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					if (obj instanceof MountSwiftUnicorn) {
						MountSwiftUnicorn mph = (MountSwiftUnicorn) obj;
						if (mph.getUniqueID().equals(ownedMount)) mph.setDead();
					}
				}
			}
		}*/
	}
}