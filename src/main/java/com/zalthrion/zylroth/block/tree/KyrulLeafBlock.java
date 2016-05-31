package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.BlockLeafBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class KyrulLeafBlock extends BlockLeafBase {
	public static final PropertyEnum<KyrulTreeType> TYPE = PropertyEnum.<KyrulTreeType>create("type", KyrulTreeType.class);
	
	public KyrulLeafBlock() {
		super();
		this.setCreativeTab();
		this.setItemDropped(Item.getItemFromBlock(BlockInit.KYRUL_SAPLING_BLOCK));
		this.setNames("kyrulLeaves");
	}
	
	/* Custom Methods */
	
	public KyrulTreeType getTreeType(int meta) {
		return KyrulTreeType.byMetadata(meta);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE, CHECK_DECAY, DECAYABLE });
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((KyrulTreeType) state.getValue(TYPE)).getMetadata();
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((KyrulTreeType) state.getValue(TYPE)).getMetadata();
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, this.getTreeType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
}