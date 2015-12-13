package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.model.item.ModelCrossbow;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityCrossbow;

public class RenderTileEntityCrossbow extends TileEntitySpecialRenderer<TileEntityCrossbow> {
private ModelCrossbow model;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public RenderTileEntityCrossbow() { 
		model = new ModelCrossbow();
	}
	
	@Override public void renderTileEntityAt(TileEntityCrossbow te, double x, double y, double z, float partialTicks, int destroyStage) {
		GlStateManager.pushMatrix();
		GlStateManager.scale(1.5F, 1.5F, 1.5F);
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/items/" + "woodenCrossbow.png"));
		GlStateManager.rotate(0F, 1.0F, 0.0F, 0.0F); // rotate 0 ° on X axis
		GlStateManager.rotate(0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(180F, 0.0F, 0.0F, 1.0F);
		GlStateManager.translate(0.4F, 0.2F, -0.4F);
		model.render(0.0625F);
		GlStateManager.popMatrix();
	}
}