package com.zalthrion.zylroth.block.tree;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.zalthrion.zylroth.base.BlockLeafBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class IridisLeafBlock extends BlockLeafBase {
	public static final PropertyEnum<TreeVariantIridis> VARIANT = PropertyEnum.<TreeVariantIridis>create("variant", TreeVariantIridis.class);
	
	public IridisLeafBlock() {
		super();
		this.setCreativeTab();
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, TreeVariantIridis.AUTUMN).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setMetaRange(0, 1);
		this.setNames("iridisLeafBlock");
	}
	
	/* Custom Methods */
	
	public TreeVariantIridis getLeafType(int meta) {
		return TreeVariantIridis.byMetadata((meta & 3) % 4);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, CHECK_DECAY, DECAYABLE });
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeVariantIridis) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override @Nullable public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockInit.IRIDIS_SAPLING_BLOCK);
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeVariantIridis) state.getValue(VARIANT)).getMetadata();
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, this.getLeafType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
}