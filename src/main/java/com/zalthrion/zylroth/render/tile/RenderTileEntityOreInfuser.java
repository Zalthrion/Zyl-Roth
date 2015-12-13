package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.model.tile.ModelInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

public class RenderTileEntityOreInfuser extends TileEntitySpecialRenderer<TileEntityOreInfuser> {
	private static final ResourceLocation oreInfuserTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/textures/blocks/oreInfuserMachine.png");
	private static final ResourceLocation oreInfuserActiveTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/textures/blocks/oreInfuserMachineActive.png");
	private final ModelInfuser model;
	
	public RenderTileEntityOreInfuser() {
		this.model = new ModelInfuser();
	}
	
	@Override public void renderTileEntityAt(TileEntityOreInfuser te, double x, double y, double z, float scale, int destroyStage) {
		if (te instanceof TileEntityOreInfuser) {
			TileEntityOreInfuser tei = (TileEntityOreInfuser) te;
			int facing = tei.getFacing();
			GlStateManager.pushMatrix();
			GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			this.bindTexture(tei.isBurning() ? oreInfuserActiveTexture : oreInfuserTexture);
			
			if (facing == 2) GlStateManager.rotate(-90F, 0F, 1F, 0F);
			if (facing == 3 || facing == 0) GlStateManager.rotate(180F, 0F, 1F, 0F);
			if (facing == 4) GlStateManager.rotate(90F, 0F, 1F, 0F);
			
			GlStateManager.rotate(180, 0, 0, 1);
			
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GlStateManager.popMatrix();
		}
	}
}