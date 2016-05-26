package com.zalthrion.zylroth.render.tile;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.tile.ModelInfuser;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityInfuser extends TileEntitySpecialRenderer {
	private static final ResourceLocation infuserTexture = new ResourceLocation("zylroth:textures/blocks/infuserMachine.png");
	private static final ResourceLocation infuserActiveTexture = new ResourceLocation("zylroth:textures/blocks/infuserMachineActive.png");
	private static final ResourceLocation oreInfuserTexture = new ResourceLocation("zylroth:textures/blocks/oreInfuserMachine.png");
	private static final ResourceLocation oreInfuserActiveTexture = new ResourceLocation("zylroth:textures/blocks/oreInfuserMachineActive.png");
	
	private final ModelInfuser model;
	
	public RenderTileEntityInfuser() {
		this.model = new ModelInfuser();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
		if (!(te instanceof TileEntityInfuser)) return;
		TileEntityInfuser tei = (TileEntityInfuser) te;
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		if (tei.getFacing() == EnumFacing.SOUTH) GL11.glRotatef(180F, 0, 1, 0);
		if (tei.getFacing() == EnumFacing.EAST) GL11.glRotatef(-90F, 0, 1, 0);
		if (tei.getFacing() == EnumFacing.WEST) GL11.glRotatef(90F, 0, 1, 0);
		GL11.glRotatef(180F, 0, 0, 1);
		ResourceLocation textureBind = infuserTexture;
		boolean burning = tei.isBurning();
		boolean normal = tei.getType().isNormal();
		if (!burning) {
			if (!normal) textureBind = oreInfuserTexture;
		} else {
			if (normal) textureBind = infuserActiveTexture;
			if (!normal) textureBind = oreInfuserActiveTexture;
		}
		this.bindTexture(textureBind);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}