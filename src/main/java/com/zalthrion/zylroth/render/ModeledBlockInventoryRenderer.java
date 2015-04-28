package com.zalthrion.zylroth.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.utility.LogHelper;

public class ModeledBlockInventoryRenderer extends TileEntityItemStackRenderer {
	private TileEntityInfuser tei = new TileEntityInfuser();
	private TileEntityItemStackRenderer superInstance;
	
	public ModeledBlockInventoryRenderer() {
		
	}
	
	public ModeledBlockInventoryRenderer(TileEntityItemStackRenderer chainTo) {
		this.superInstance = chainTo;
	}
	
	
	@Override public void renderByItem(ItemStack itemStack) {
		LogHelper.warn("TEST");
		Block block = Block.getBlockFromItem(itemStack.getItem());
		if (block == ModBlocks.infuser || block == ModBlocks.infuser_Idle) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tei, 0, 0, 0, 0F);
		} else {
			if (superInstance != null) {
				superInstance.renderByItem(itemStack);
			} else {
				super.renderByItem(itemStack);
			}
		}
	}
}