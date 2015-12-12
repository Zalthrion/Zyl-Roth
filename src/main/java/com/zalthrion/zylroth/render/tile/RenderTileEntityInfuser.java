package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.model.tile.ModelInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class RenderTileEntityInfuser extends TileEntitySpecialRenderer<TileEntityInfuser> {
	private static final ResourceLocation infuserTexture = new ResourceLocation(Reference.MOD_ID + ":" + "/textures/blocks/infuserMachine.png");
	private final ModelInfuser model;
	
	public RenderTileEntityInfuser() {
		this.model = new ModelInfuser();
	}
	
	@Override
	public void renderTileEntityAt(TileEntityInfuser te, double x, double y, double z, float partialTicks, int destroyStage) {
		TileEntityInfuser tei = (TileEntityInfuser) te;
		int facing = tei.getFacing();
		
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
		if (facing == 2) GlStateManager.rotate(-90F, 0, 1, 0);
		if (facing == 3 || facing == 0) GlStateManager.rotate(180F, 0, 1, 0);
		if (facing == 4) GlStateManager.rotate(90F, 0, 1, 0);
		this.bindTexture(infuserTexture);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GlStateManager.popMatrix();
	}
}