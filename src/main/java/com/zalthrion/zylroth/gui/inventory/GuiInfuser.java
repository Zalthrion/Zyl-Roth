package com.zalthrion.zylroth.gui.inventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
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
	
	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
	 */
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 90 + 2, 4210752);
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float ticks, int x, int y) {
		
		int guiX = (width - guiWidth) / 2;
		int guiY = (height - guiHeight) / 2;
		int i1;
		
		GL11.glColor4f(1, 1, 1, 1);
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + "textures/gui/InfuserGui.png"));
		drawTexturedModalRect(guiX, guiY, 0, 0, guiWidth, guiHeight);
		
		i1 = tile.getCookProgressScaled(tile.getCookProgressScaled(28));
		this.drawTexturedModalRect(guiX + 75, guiY + 47, 177, 1, i1, 7);
		
		fontRendererObj.drawString("Infuser", guiX + 16, guiY + +12, 0x4210752);
		
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
	public void actionPerformed(GuiButton button) {
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