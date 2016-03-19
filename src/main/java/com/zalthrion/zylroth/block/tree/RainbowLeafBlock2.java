package com.zalthrion.zylroth.block.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

public class RainbowLeafBlock2 extends BlockLeaves {
	public static final PropertyEnum<TreeColor> TYPE = PropertyEnum.<TreeColor>create("type", TreeColor.class, new Predicate<TreeColor>() {
		@Override public boolean apply(TreeColor param_apply) {
			return (param_apply.getMeta() > 3) && (param_apply.getMeta() < 6);
		}
	});
	
	public RainbowLeafBlock2() {
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setSoundType(SoundType.PLANT);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, TreeColor.BLUE).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, (state.getBlock().getMetaFromState(state) & 3) + 4);
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, TreeColor.get((meta % 4) + 4)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeColor) state.getValue(TYPE)).getMeta() - 4;
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@Override public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
		for (int i = 4; i < 6; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
/*	@Override @SideOnly(Side.CLIENT) public int getRenderColor(IBlockState state) {
		return 16777215;
	}*/ // TODO Colors
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.rainbowSaplingBlock);
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeColor) state.getValue(TYPE)).getMeta();
	}
	
/*	@Override public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
		return 16777215;
	}*/ // TODO Colors
	
	@Override protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		if (worldIn.rand.nextInt(chance) == 0) {
			spawnAsEntity(worldIn, pos, new ItemStack(Items.golden_apple, 1, 0));
		}
	}

	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        IBlockState state = world.getBlockState(pos);
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(state))));
	}

	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE, CHECK_DECAY, DECAYABLE});
	}
	
	@Override public boolean isOpaqueCube(IBlockState state) {
		return Blocks.leaves.isOpaqueCube(Blocks.leaves.getDefaultState());
	}
	
	@Override @SideOnly(Side.CLIENT) public BlockRenderLayer getBlockLayer() {
		return Blocks.leaves.getBlockLayer();
	}
}