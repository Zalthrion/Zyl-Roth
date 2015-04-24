package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.tile.ModelInfuser;
import com.zalthrion.zylroth.reference.Reference;

public class RenderTileEntityInfuser extends TileEntitySpecialRenderer {
	private static final ResourceLocation Infuser = new ResourceLocation(Reference.MOD_ID + ":" + "/textures/blocks/infuserMachine.png");
	private final ModelInfuser model;
	
	public RenderTileEntityInfuser() {
		this.model = new ModelInfuser();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		
		this.bindTexture(Infuser);
		
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		
		GL11.glPopMatrix();
		
	}
	
	//TODO Rotations
	
}