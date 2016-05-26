package com.zalthrion.zylroth.gui.inventory;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.container.ContainerInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiInfuser extends GuiContainer {
	private static final ResourceLocation infuserGuiTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/gui/InfuserGui.png");
	private final InventoryPlayer playerInventory;
	private TileEntityInfuser tileInfuser;
	private final int guiWidth = 176;
	private final int guiHeight = 181;
	
	public GuiInfuser(InventoryPlayer playerInv, TileEntityInfuser infuserInv) {
		super(new ContainerInfuser(playerInv, infuserInv));
		this.playerInventory = playerInv;
		this.tileInfuser = infuserInv;
	}
	
	@Override protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.tileInfuser.getInventoryName();
		this.fontRendererObj.drawString(s, (this.xSize - this.fontRendererObj.getStringWidth(s)) - 6, 0, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.playerInventory.getInventoryName()), 8, this.ySize - 85, 4210752);
	}
	
	@Override public void drawGuiContainerBackgroundLayer(float ticks, int x, int y) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(infuserGuiTexture);
		int guiX = (this.width - this.guiWidth) / 2;
		int guiY = (this.height - this.guiHeight) / 2;
		this.drawTexturedModalRect(guiX, guiY, 0, 0, this.guiWidth, this.guiHeight);
		
		if (this.tileInfuser.isBurning()) {
			int i1 = this.tileInfuser.getBurnTimeRemainingScaled(14);
			this.drawTexturedModalRect(guiX + 17, guiY + 66 - i1, 176, 7 + (14 - i1), 14, i1 + 1);
			i1 = this.tileInfuser.getCookProgressScaled(24);
			this.drawTexturedModalRect(guiX + 75, guiY + 46, 177, 0, i1, 7);
		}
	}
}