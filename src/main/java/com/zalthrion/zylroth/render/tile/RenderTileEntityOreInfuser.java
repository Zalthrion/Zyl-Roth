package com.zalthrion.zylroth.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.model.tile.ModelInfuser;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

public class RenderTileEntityOreInfuser extends TileEntitySpecialRenderer {
	private static final ResourceLocation oreInfuserTexture = new ResourceLocation(Reference.MOD_ID + ":" + "/textures/blocks/oreInfuserMachine.png");
	private static final ResourceLocation oreInfuserActiveTexture = new ResourceLocation(Reference.MOD_ID + ":" + "/textures/blocks/oreInfuserMachineActive.png");
	
	private final ModelInfuser model;
	
	public RenderTileEntityOreInfuser() {
		this.model = new ModelInfuser();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		if (te instanceof TileEntityOreInfuser) {
			TileEntityOreInfuser tei = (TileEntityOreInfuser) te;
			int facing = tei.getFacing();
			
			GL11.glPushMatrix();
			
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			
			if (tei.isBurning()) {
				this.bindTexture(oreInfuserActiveTexture);
			}
			
			else this.bindTexture(oreInfuserTexture);
			
			if (facing == 2)
				GL11.glRotatef(-90F, 0F, 1F, 0F);
			if (facing == 3 || facing == 0)
				GL11.glRotatef(180F, 0F, 1F, 0F);
			if (facing == 4)
				GL11.glRotatef(90F, 0F, 1F, 0F);
			
			GL11.glRotated(180, 0, 0, 1);
			
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}
}