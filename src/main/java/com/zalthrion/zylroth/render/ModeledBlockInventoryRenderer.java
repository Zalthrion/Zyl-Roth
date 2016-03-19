package com.zalthrion.zylroth.render;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

import com.zalthrion.zylroth.block.machine.InfuserType;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class ModeledBlockInventoryRenderer extends TileEntityItemStackRenderer {
	private TileEntityInfuser tei = new TileEntityInfuser(InfuserType.NORMAL);
	private TileEntityInfuser teoi = new TileEntityInfuser(InfuserType.ORE);
	private TileEntityItemStackRenderer superInstance;
	
	public ModeledBlockInventoryRenderer() {
		
	}
	
	public ModeledBlockInventoryRenderer(TileEntityItemStackRenderer chainTo) {
		this.superInstance = chainTo;
		tei.setFacing(EnumFacing.SOUTH);
		teoi.setFacing(EnumFacing.SOUTH);
	}
	
	
	@Override public void renderByItem(ItemStack itemStack) {
/*		Block block = Block.getBlockFromItem(itemStack.getItem());
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
		}*/ // FIXME
		superInstance.renderByItem(itemStack);
	}
}