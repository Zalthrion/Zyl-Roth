package com.zalthrion.zylroth.block.tree;

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

public class RainbowLeafBlock extends BlockLeafBase {
	public static final PropertyEnum<TreeColor> COLOR = PropertyEnum.<TreeColor>create("type", TreeColor.class, new Predicate<TreeColor>() {
		@Override public boolean apply(TreeColor input) {
			return input.getMetadata() < 4;
		}
	});
	
	public RainbowLeafBlock() {
		super();
		this.setCreativeTab();
		this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, TreeColor.RED).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setItemDropped(Item.getItemFromBlock(BlockInit.RAINBOW_SAPLING_BLOCK));
		this.setMetaRange(0, 3);
		this.setNames("rainbowLeafBlock");
	}
	
	/* Custom Methods */
	
	public TreeColor getTreeColor(int meta) {
		return TreeColor.byMetadata((meta & 3) % 4);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COLOR, CHECK_DECAY, DECAYABLE });
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeColor) state.getValue(COLOR)).getMetadata();
	}
	
	@Override protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		if (worldIn.rand.nextInt(chance) == 0) spawnAsEntity(worldIn, pos, new ItemStack(Items.GOLDEN_APPLE));
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeColor) state.getValue(COLOR)).getMetadata();
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(COLOR, this.getTreeColor(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
}