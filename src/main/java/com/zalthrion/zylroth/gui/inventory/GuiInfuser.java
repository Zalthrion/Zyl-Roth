package com.zalthrion.zylroth.gui.inventory;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.container.ContainerInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class GuiInfuser extends GuiContainer {
	
	// GuiButton startButton;
	
	int guiWidth = 176;
	int guiHeight = 181;
	
	private final TileEntityInfuser tile;
	
	public boolean craftEnable = false;
	public boolean buttonActive = false;
	
	public GuiInfuser(InventoryPlayer inventory, TileEntityInfuser tile) {
		super(new ContainerInfuser(inventory, tile));
		
		this.tile = tile;
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float ticks, int x, int y) {
		
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) - 36;
		int i1;
		
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/gui/InfuserGui.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		// fontRendererObj.drawString("Infuser", guiX + 16, guiY + +12,
		// 0x000000);
		
		i1 = tile.getCookProgressScaled(tile.getCookProgressScaled(28));
		this.drawTexturedModalRect(guiX + 75, guiY + 47, 176, 1, i1 + 1, 7);
		
		super.drawGuiContainerForegroundLayer(x, y);
	}
	
	@Override
	public void initGui() {
		
		/* int guiX = (width - guiWidth) / 2; int guiY = (height - guiHeight) /
		 * 2; buttonList.clear(); buttonList.add(startButton = new GuiButton(1,
		 * guiX + 10, guiY + 1, 20, 20, "C")); */
		
		super.initGui();
	}
	
	@Override
	public void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		
			case 1:
				button.displayString = "Infusing..";
				button.width = 55;
				button.enabled = false;
				// button.visible = false;
				this.craftEnable = true;
				this.buttonActive = button.enabled = false;
				tile.infuseItem();
		}
		super.actionPerformed(button);
	}
}