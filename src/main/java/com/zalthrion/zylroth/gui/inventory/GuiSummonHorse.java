package com.zalthrion.zylroth.gui.inventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.reference.Reference;

public class GuiSummonHorse extends GuiScreen {
	
	GuiButton summonButton;
	GuiButton unsummonButton;
	
	public boolean isSummonedButtonActive = false;
	
	int guiWidth = 176;
	int guiHeight = 181;
	
	@SuppressWarnings("unused")
	@Override
	public void drawScreen(int x, int y, float ticks) {
		
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) - 36;
		
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/InfuserGui.png"));
		
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		buttonList.clear();
		buttonList.add(summonButton = new GuiButton(1, guiX + 10, guiY + 1, 20, 20, "s"));
		
		buttonList.add(unsummonButton = new GuiButton(2, guiX + 30, guiY + 1, 20, 20, "u"));
		
		super.initGui();
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		
		switch (button.id) {
		
			case 1:
				button.width = 55;
				button.enabled = false;
				// button.visible = false;
				this.isSummonedButtonActive = true;
				
			case 2:
				button.width = 55;
				
		}
		super.actionPerformed(button);
	}
	
}