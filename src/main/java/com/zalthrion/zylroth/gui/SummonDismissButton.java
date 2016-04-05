package com.zalthrion.zylroth.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.text.translation.I18n;

import com.zalthrion.zylroth.packet.SummonedMountMessage;

//TODO Check all mappings, reorganize methods, etc.
public class SummonDismissButton extends GuiButton {
	private String summonText = "gui.zylroth:summon";
	private String dismountText = "gui.zylroth:dismiss";
	private int track = 0;
	
	public void setTrack(int track) { this.track = track; }
	
	public SummonDismissButton(int buttonId, int x, int y, int widthIn, int heightIn, String initialString) {
		super(buttonId, x, y, widthIn, heightIn, initialString);
	}
	
	@Override public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (SummonedMountMessage.summonedMountStatic == track && track > -1) {
			this.displayString = I18n.translateToLocal(dismountText);
		} else {
			this.displayString = I18n.translateToLocal(summonText);
		}
		super.drawButton(mc, mouseX, mouseY);
	}
}