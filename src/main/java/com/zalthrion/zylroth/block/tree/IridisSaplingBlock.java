package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import com.zalthrion.zylroth.base.BlockSaplingBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class IridisSaplingBlock extends BlockSaplingBase {
	public static final PropertyEnum<IridisTreeType> SAPLING_TYPE = PropertyEnum.<IridisTreeType>create("type", IridisTreeType.class);
	
	public IridisSaplingBlock() {
		super();
		this.setCreativeTab();
		this.setNames("iridisSapling");
		this.setNumSubBlocks(IridisTreeType.values().length);
		this.setSoundType(SoundType.PLANT);
		/* Special */
		this.addTreeGrowth(0, Blocks.LOG.getDefaultState(), BlockInit.IRIDIS_LEAF_BLOCK.getDefaultState());
		this.addTreeGrowth(1, Blocks.LOG.getDefaultState(), BlockInit.IRIDIS_LEAF_BLOCK.getDefaultState().withProperty(IridisLeafBlock.LEAF_TYPE, IridisTreeType.SAKURA));
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { SAPLING_TYPE, STAGE });
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((IridisTreeType) state.getValue(SAPLING_TYPE)).getMetadata();
	}
	
	@Override public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((IridisTreeType) state.getValue(SAPLING_TYPE)).getMetadata();
        i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(SAPLING_TYPE, IridisTreeType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
}