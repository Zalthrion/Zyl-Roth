package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import com.zalthrion.zylroth.model.tile.ModelInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class RenderTileEntityInfuser extends TileEntitySpecialRenderer<TileEntityInfuser> {
	private static final ResourceLocation infuserTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/textures/blocks/infuserMachine.png");
	private static final ResourceLocation infuserActiveTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/textures/blocks/infuserMachineActive.png");
	private static final ResourceLocation oreInfuserTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/textures/blocks/oreInfuserMachine.png");
	private static final ResourceLocation oreInfuserActiveTexture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/textures/blocks/oreInfuserMachineActive.png");
	private final ModelInfuser model;
	
	public RenderTileEntityInfuser() {
		this.model = new ModelInfuser();
	}
	
	@Override
	public void renderTileEntityAt(TileEntityInfuser te, double x, double y, double z, float partialTicks, int destroyStage) {
		TileEntityInfuser tei = (TileEntityInfuser) te;
		
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		if (tei.getFacing() == EnumFacing.SOUTH) GlStateManager.rotate(180F, 0, 1, 0);
		if (tei.getFacing() == EnumFacing.EAST) GlStateManager.rotate(-90F, 0, 1, 0);
		if (tei.getFacing() == EnumFacing.WEST) GlStateManager.rotate(90F, 0, 1, 0);
		GlStateManager.rotate(180F, 0, 0, 1);
		ResourceLocation textureBind = infuserTexture;
		boolean burning = TileEntityInfuser.isBurning(tei);
		boolean normal = te.getType().isNormal();
		if (!burning) {
			if (!normal) textureBind = oreInfuserTexture;
		} else {
			if (normal) textureBind = infuserActiveTexture;
			if (!normal) textureBind = oreInfuserActiveTexture;
		}
		this.bindTexture(textureBind);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GlStateManager.popMatrix();
	}
}