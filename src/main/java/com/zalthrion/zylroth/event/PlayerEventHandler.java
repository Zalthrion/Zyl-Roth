package com.zalthrion.zylroth.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.zalthrion.zylroth.handler.MountData;

public class PlayerEventHandler {
	@SubscribeEvent public void onEntityConstruct(EntityConstructing event) {
		if (event.getEntity() instanceof EntityPlayer && MountData.get((EntityPlayer) event.getEntity()) == null) MountData.register((EntityPlayer) event.getEntity());
	}
	
	@SubscribeEvent public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		/* EntityPlayer player = event.player;
		NBTTagCompound persistentData = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		LogHelper.warn(persistentData.hasKey("ownsMount"));
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