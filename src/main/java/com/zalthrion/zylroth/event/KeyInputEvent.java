package com.zalthrion.zylroth.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.handler.KeyHandler;
import com.zalthrion.zylroth.packet.KeyPressMessage;
import com.zalthrion.zylroth.packet.PacketHandler;

public class KeyInputEvent {
	@SubscribeEvent public void keyPressed(InputEvent.KeyInputEvent event) {
		if (KeyHandler.openSummonGui.isPressed()) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			KeyPressMessage message = new KeyPressMessage();
			PacketHandler.network.sendToServer(message);
			player.openGui(Zylroth.instance, 2, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
	}
}