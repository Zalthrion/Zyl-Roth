package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.model.tile.ModelGoldBag;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;

public class RenderTileEntityGoldBag extends TileEntitySpecialRenderer<TileEntityGoldBag> {
	private static final ResourceLocation goldBag = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/blocks/goldBag.png");
	private final ModelGoldBag model;
	
	public RenderTileEntityGoldBag() {
		this.model = new ModelGoldBag();
	}
	
	@Override public void renderTileEntityAt(TileEntityGoldBag te, double x, double y, double z, float partialTicks, int destroyStage) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		if (te.getFacing() == EnumFacing.SOUTH) GlStateManager.rotate(180F, 0, 1, 0);
		if (te.getFacing() == EnumFacing.EAST) GlStateManager.rotate(-90F, 0, 1, 0);
		if (te.getFacing() == EnumFacing.WEST) GlStateManager.rotate(90F, 0, 1, 0);
		GlStateManager.rotate(180F, 0, 0, 1);
		this.bindTexture(goldBag);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GlStateManager.popMatrix();
	}
}