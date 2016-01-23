package com.zalthrion.zylroth.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.packet.KeyPressMessage;
import com.zalthrion.zylroth.packet.PacketHandler;
import com.zalthrion.zylroth.reference.GuiIDs;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEvent {
	@SubscribeEvent
	public void keyPressed(InputEvent.KeyInputEvent event) {
		if (KeyHandler.openSummonGui.isPressed()) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			KeyPressMessage message = new KeyPressMessage();
			PacketHandler.network.sendToServer(message);
			player.openGui(Zylroth.instance, GuiIDs.SUMMON, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
	}
}