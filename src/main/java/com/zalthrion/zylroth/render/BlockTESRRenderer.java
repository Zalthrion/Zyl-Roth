package com.zalthrion.zylroth.render;

import org.lwjgl.opengl.GL11;

import com.zalthrion.zylroth.block.machine.InfuserType;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.tile.TileEntityBenzenn;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class BlockTESRRenderer implements ISimpleBlockRenderingHandler {
	private TileEntityInfuser infuser;
	private TileEntityInfuser oreInfuser;
	private TileEntityGoldBag goldBag;
	private TileEntityBenzenn benzenn;
	private TileEntityBenzenn benzennStatue;
	private int renderID;
	
	public BlockTESRRenderer(int renderID) {
		this.infuser = new TileEntityInfuser();
		this.oreInfuser = new TileEntityInfuser(InfuserType.ORE);
		this.goldBag = new TileEntityGoldBag();
		this.benzenn = new TileEntityBenzenn();
		this.benzennStatue = new TileEntityBenzenn();
		this.infuser.setFacing(EnumFacing.SOUTH);
		this.oreInfuser.setFacing(EnumFacing.SOUTH);
		this.goldBag.setFacing(EnumFacing.SOUTH);
		this.renderID = renderID;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		if (block == ModBlocks.infuser || block == ModBlocks.infuser_Idle) {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.infuser, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		} else if (block == ModBlocks.oreInfuser || block == ModBlocks.oreInfuser_Idle){
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.oreInfuser, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		} else if (block == ModBlocks.goldBag){
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.7F, -0.95F);
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.goldBag, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		} else if (block == ModBlocks.benzenn){
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.7F, -0.95F);
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.benzenn, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		} else if (block == ModBlocks.benzennStatue){
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.7F, -0.95F);
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.benzennStatue, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		} else {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.goldBag, 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glEnable(32826);
		}
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer) {
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int i) {
		return true;
	}
	
	@Override
	public int getRenderId() {
		return this.renderID;
	}
}