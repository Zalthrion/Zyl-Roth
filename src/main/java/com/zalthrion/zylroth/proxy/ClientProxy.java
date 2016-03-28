package com.zalthrion.zylroth.proxy;

import net.minecraft.client.renderer.block.statemap.StateMap;

import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlock;
import com.zalthrion.zylroth.item.block.RainbowLeafItemBlock;
import com.zalthrion.zylroth.item.block.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.utility.ModelHelper;

public class ClientProxy extends CommonProxy {
	@Override public void preInit() {
		super.preInit();
		this.registerEntityRenderers();
	}
	
	@Override public void init() {
		super.init();
		this.registerItemModels();
	}
	
	@Override public void postInit() {
		super.postInit();
	}
	
	public void registerEntityRenderers() {
		
	}
	
	public void registerItemModels() {
		/* Blocks */
		ModelHelper.registerBlock(BlockInit.tenebraeOre);
		ModelHelper.registerBlock(BlockInit.tenebraeBlock);
		ModelHelper.registerBlock(BlockInit.tenebraeCore);
		ModelHelper.registerBlock(BlockInit.chiseledTenebrae);
		ModelHelper.registerBlock(BlockInit.infusedTenebrae);
		ModelHelper.registerBlock(BlockInit.infuser);
		ModelHelper.registerBlock(BlockInit.infuserIdle);
		ModelHelper.registerBlock(BlockInit.oreInfuser);
		ModelHelper.registerBlock(BlockInit.oreInfuserIdle);
		ModelHelper.registerBlock(BlockInit.ashBlock);
		ModelHelper.registerBlock(BlockInit.empoweredTenebraeCore);
		ModelHelper.registerBlock(BlockInit.voidiumOre);
		ModelHelper.registerBlock(BlockInit.inferniumOre);
		ModelHelper.registerBlock(BlockInit.endiriteOre);
		ModelHelper.registerBlock(BlockInit.rainbowSaplingBlock, (new StateMap.Builder()).withName(RainbowSaplingBlock.COLOR).withSuffix("_sapling").ignore(RainbowSaplingBlock.STAGE).build(), RainbowSaplingItemBlock.getVariants(), new int[] {0, 1, 2, 3, 4, 5});
		ModelHelper.registerBlock(BlockInit.rainbowLeafBlock, (new StateMap.Builder()).withName(RainbowLeafBlock.COLOR).withSuffix("_leaves").ignore(RainbowLeafBlock.CHECK_DECAY).ignore(RainbowLeafBlock.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(0), new int[] {0, 1, 2, 3});
		ModelHelper.registerBlock(BlockInit.rainbowLeafBlock2, (new StateMap.Builder()).withName(RainbowLeafBlock2.COLOR).withSuffix("_leaves").ignore(RainbowLeafBlock2.CHECK_DECAY).ignore(RainbowLeafBlock2.DECAYABLE).build(), RainbowLeafItemBlock.getVariants(1), new int[] {4, 5});
	}
}