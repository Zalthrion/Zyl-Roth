package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.tile.ModelGoldBag;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;

public class RenderTileEntityGoldBag extends TileEntitySpecialRenderer {
	private static final ResourceLocation goldBag = new ResourceLocation(Reference.RESOURCE_PREFIX + "textures/blocks/goldBag.png");
	private final ModelGoldBag model;
	
	public RenderTileEntityGoldBag() {
		this.model = new ModelGoldBag();
	}
	
	@Override public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
		if (!(te instanceof TileEntityGoldBag)) return;
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180F, 0, 0, 1);
		this.bindTexture(goldBag);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}