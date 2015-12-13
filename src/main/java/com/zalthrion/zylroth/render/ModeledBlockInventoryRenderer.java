package com.zalthrion.zylroth.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTools;
import com.zalthrion.zylroth.tile.TileEntityCrossbow;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class ModeledBlockInventoryRenderer extends TileEntityItemStackRenderer {
	private TileEntityInfuser tei = new TileEntityInfuser();
	private TileEntityCrossbow tec = new TileEntityCrossbow();
	private TileEntityItemStackRenderer superInstance;
	
	public ModeledBlockInventoryRenderer() {
		
	}
	
	public ModeledBlockInventoryRenderer(TileEntityItemStackRenderer chainTo) {
		this.superInstance = chainTo;
	}
	
	
	@Override public void renderByItem(ItemStack itemStack) {
		Block block = Block.getBlockFromItem(itemStack.getItem());
		if (block == ModBlocks.infuser || block == ModBlocks.infuserIdle) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tei, 0, 0, 0, 0F);
		} else {
			if (itemStack.getItem() == ModTools.woodenCrossbow) {
				TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tec, 0, 0, 0, 0F);
			} else {
				if (superInstance != null) {
					superInstance.renderByItem(itemStack);
				} else {
					super.renderByItem(itemStack);
				}
			}
		}
	}
}