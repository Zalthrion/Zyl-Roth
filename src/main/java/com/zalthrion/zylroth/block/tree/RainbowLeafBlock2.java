package com.zalthrion.zylroth.block.tree;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.google.common.base.Predicate;
import com.zalthrion.zylroth.base.BlockLeafBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

public class RainbowLeafBlock2 extends BlockLeafBase {
	public static final PropertyEnum<TreeVariantRainbow> VARIANT = PropertyEnum.<TreeVariantRainbow>create("variant", TreeVariantRainbow.class, new Predicate<TreeVariantRainbow>() {
		@Override public boolean apply(@Nullable TreeVariantRainbow input) {
			return input.getMetadata() >= 4;
		}
	});
	
	public RainbowLeafBlock2() {
		super();
		this.setCreativeTab();
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, TreeVariantRainbow.BLUE).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setMetaRange(0, 1);
		this.setNames("rainbowLeafBlock2");
	}
	
	/* Custom Methods */
	
	public TreeVariantRainbow getTreeColor(int meta) {
		return TreeVariantRainbow.byMetadata((meta & 3) + 4);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, CHECK_DECAY, DECAYABLE });
	}
	
	@Override public ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1, ((TreeVariantRainbow) state.getValue(VARIANT)).getMetadata() - 4);
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeVariantRainbow) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		if (worldIn.rand.nextInt(chance) == 0) spawnAsEntity(worldIn, pos, new ItemStack(Items.GOLDEN_APPLE));
	}
	
	@Override @Nullable public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockInit.RAINBOW_SAPLING_BLOCK);
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeVariantRainbow) state.getValue(VARIANT)).getMetadata() - 4;
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, this.getTreeColor(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
}