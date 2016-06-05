package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

import com.zalthrion.zylroth.base.BlockSaplingBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class KyrulSaplingBlock extends BlockSaplingBase {
	public static final PropertyEnum<TreeVariantKyrul> VARIANT = PropertyEnum.<TreeVariantKyrul> create("variant", TreeVariantKyrul.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	public KyrulSaplingBlock() {
		super();
		this.setCreativeTab();
		this.setNames("kyrulSapling");
		this.setNumSubBlocks(TreeVariantKyrul.values().length);
		this.setSoundType(SoundType.PLANT);
		/* Special */
		this.addTreeGrowth(0, BlockInit.KYRUL_LOG_BLOCK.getDefaultState(), BlockInit.KYRUL_LEAF_BLOCK.getDefaultState());
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeVariantKyrul) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeVariantKyrul) state.getValue(VARIANT)).getMetadata();
		i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, TreeVariantKyrul.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
}