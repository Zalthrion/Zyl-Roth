package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.zalthrion.zylroth.base.BlockSaplingBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class RainbowSaplingBlock extends BlockSaplingBase {
	public static final PropertyEnum<TreeVariantRainbow> VARIANT = PropertyEnum.<TreeVariantRainbow>create("variant", TreeVariantRainbow.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	public RainbowSaplingBlock() {
		super();
		this.setCreativeTab();
		this.setNames("rainbowSapling");
		this.setNumSubBlocks(TreeVariantRainbow.values().length);
		this.setSoundType(SoundType.PLANT);
		/* Special */
		this.addTreeGrowth(0, Blocks.LOG.getDefaultState(), BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.RED));
		this.addTreeGrowth(1, Blocks.LOG.getDefaultState(), BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.ORANGE));
		this.addTreeGrowth(2, Blocks.LOG.getDefaultState(), BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.YELLOW));
		this.addTreeGrowth(3, Blocks.LOG.getDefaultState(), BlockInit.RAINBOW_LEAF_BLOCK.getDefaultState().withProperty(RainbowLeafBlock.VARIANT, TreeVariantRainbow.GREEN));
		this.addTreeGrowth(4, Blocks.LOG.getDefaultState(), BlockInit.RAINBOW_LEAF_BLOCK_2.getDefaultState().withProperty(RainbowLeafBlock2.VARIANT, TreeVariantRainbow.BLUE));
		this.addTreeGrowth(5, Blocks.LOG.getDefaultState(), BlockInit.RAINBOW_LEAF_BLOCK_2.getDefaultState().withProperty(RainbowLeafBlock2.VARIANT, TreeVariantRainbow.PURPLE));
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, STAGE });
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeVariantRainbow) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((TreeVariantRainbow) state.getValue(VARIANT)).getMetadata();
        i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, TreeVariantRainbow.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
}