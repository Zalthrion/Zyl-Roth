package com.zalthrion.zylroth.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

public class ModeledBlockInventoryRenderer extends TileEntityItemStackRenderer {
	private TileEntityInfuser tei = new TileEntityInfuser();
	private TileEntityOreInfuser teoi = new TileEntityOreInfuser();
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
		} else if (block == ModBlocks.oreInfuser || block == ModBlocks.oreInfuserIdle) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.teoi, 0, 0, 0, 0F);
		} else {
			if (superInstance != null) {
				superInstance.renderByItem(itemStack);
			} else {
				super.renderByItem(itemStack);
			}
		}
	}
}