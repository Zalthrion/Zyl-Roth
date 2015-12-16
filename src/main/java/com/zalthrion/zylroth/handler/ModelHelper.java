package com.zalthrion.zylroth.handler;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.itemblock.RainbowLeafItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowSaplingItemBlock;

@SideOnly(Side.CLIENT) public class ModelHelper {
	public static void registerItem(Item item, int... metadata) {
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		if (item instanceof RainbowSaplingItemBlock) {
			for (int i : metadata) {
				mesher.register(item, i, new ModelResourceLocation(RainbowSaplingItemBlock.getVariants()[i], "inventory"));
			}
		} else if (item instanceof RainbowLeafItemBlock) {
			for (int i : metadata) {
				mesher.register(item, i, new ModelResourceLocation(RainbowLeafItemBlock.getVariants()[i], "inventory"));
			}
		} else {
			for (int i : metadata) {
				mesher.register(item, i, new ModelResourceLocation(item.getUnlocalizedName().substring(5), "inventory"));
			}
		}
	}
	
	public static void registerBlock(Block block, IStateMapper mapper, int... metadata) {
		registerItem(Item.getItemFromBlock(block), metadata);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBlockWithStateMapper(block, mapper);
	}
	
	public static void registerBlock(Block block, int meta) {
		registerBlock(block, null, meta);
	}
	
	public static void registerBlock(Block block, IStateMapper mapper) {
		registerBlock(block, mapper);
	}
	
	public static void registerBlock(Block block) {
		registerBlock(block, null, 0);
	}
	
	public static void registerItem(Item item) {
		registerItem(item, 0);
	}
	
	public static void removeblockstate(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(block);
	}
}