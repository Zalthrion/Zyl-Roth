package com.zalthrion.zylroth.render.tile;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.tile.ModelBenzennStatue;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityBenzennStatue;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityBenzennStatue extends TileEntitySpecialRenderer {
	private static final ResourceLocation benzenn = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/blocks/benzenn.png");
	private final ModelBenzennStatue model;
	
	public RenderTileEntityBenzennStatue() {
		this.model = new ModelBenzennStatue();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
		if (!(te instanceof TileEntityBenzennStatue)) return;
		TileEntityBenzennStatue tegb = (TileEntityBenzennStatue) te;
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		if (tegb.getFacing() == EnumFacing.SOUTH) GL11.glRotatef(180F, 0, 1, 0);
		if (tegb.getFacing() == EnumFacing.EAST) GL11.glRotatef(-90F, 0, 1, 0);
		if (tegb.getFacing() == EnumFacing.WEST) GL11.glRotatef(90F, 0, 1, 0);
		GL11.glRotatef(180F, 0, 0, 1);
		this.bindTexture(benzenn);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}