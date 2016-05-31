package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.BlockLeafBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class IridisLeafBlock extends BlockLeafBase {
	public static final PropertyEnum<IridisTreeType> LEAF_TYPE = PropertyEnum.<IridisTreeType>create("type", IridisTreeType.class);
	
	public IridisLeafBlock() {
		super();
		this.setCreativeTab();
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEAF_TYPE, IridisTreeType.AUTUMN).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setItemDropped(Item.getItemFromBlock(BlockInit.IRIDIS_SAPLING_BLOCK));
		this.setMetaRange(0, 1);
		this.setNames("iridisLeafBlock");
	}
	
	/* Custom Methods */
	
	public IridisTreeType getLeafType(int meta) {
		return IridisTreeType.byMetadata((meta & 3) % 4);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LEAF_TYPE, CHECK_DECAY, DECAYABLE });
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((IridisTreeType) state.getValue(LEAF_TYPE)).getMetadata();
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(LEAF_TYPE, this.getLeafType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
}