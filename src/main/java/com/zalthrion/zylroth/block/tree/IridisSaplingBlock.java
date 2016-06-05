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
	public static final PropertyEnum<TreeVariantIridis> VARIANT = PropertyEnum.<TreeVariantIridis>create("variant", TreeVariantIridis.class);
	
	public IridisSaplingBlock() {
		super();
		this.setCreativeTab();
		this.setNames("iridisSapling");
		this.setNumSubBlocks(TreeVariantIridis.values().length);
		this.setSoundType(SoundType.PLANT);
		/* Special */
		this.addTreeGrowth(0, Blocks.LOG.getDefaultState(), BlockInit.IRIDIS_LEAF_BLOCK.getDefaultState());
		this.addTreeGrowth(1, Blocks.LOG.getDefaultState(), BlockInit.IRIDIS_LEAF_BLOCK.getDefaultState().withProperty(IridisLeafBlock.VARIANT, TreeVariantIridis.SAKURA));
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, STAGE });
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeVariantIridis) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((TreeVariantIridis) state.getValue(VARIANT)).getMetadata();
        i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, TreeVariantIridis.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
}