package com.zalthrion.zylroth.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.container.ContainerInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

// TODO Check all mappings, reorganize methods, etc.
public class GuiInfuser extends GuiContainer {
	private static final ResourceLocation infuserGuiTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/gui/InfuserGui.png");
	private final InventoryPlayer playerInventory;
	private IInventory tileInfuser;
	private final int guiWidth = 176;
	private final int guiHeight = 181;
	
	public GuiInfuser(InventoryPlayer playerInv, TileEntityInfuser infuserInv) {
		super(new ContainerInfuser(playerInv, infuserInv));
		this.playerInventory = playerInv;
		this.tileInfuser = infuserInv;
	}
	
	@Override protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.tileInfuser.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString(s, (this.xSize - this.fontRendererObj.getStringWidth(s)) - 6, 0, 4210752);
		this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 85, 4210752);
	}
	
	@Override public void drawGuiContainerBackgroundLayer(float ticks, int x, int y) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(infuserGuiTexture);
		int guiX = (this.width - this.guiWidth) / 2;
		int guiY = (this.height - this.guiHeight) / 2;
		this.drawTexturedModalRect(guiX, guiY, 0, 0, this.guiWidth, this.guiHeight);
		if (TileEntityInfuser.isBurning(this.tileInfuser)) {
			int k = this.getBurnLeftScaled(14);
			this.drawTexturedModalRect(guiX + 17, guiY + 66 - k, 176, 7 + (14 - k), 14, k + 1);
		}
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(guiX + 75, guiY + 47, 177, 0, l, 7);
	}
	
	private int getCookProgressScaled(int pixels) {
		int i = this.tileInfuser.getField(2);
		int j = this.tileInfuser.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
	
	private int getBurnLeftScaled(int pixels) {
		int i = this.tileInfuser.getField(1);
		if (i == 0) return 0;
		return this.tileInfuser.getField(0) * pixels / i;
	}
}