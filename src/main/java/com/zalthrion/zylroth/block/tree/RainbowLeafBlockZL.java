package com.zalthrion.zylroth.block.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

public class RainbowLeafBlockZL extends BlockLeaves {
	public static final PropertyEnum<TreeColor> TYPE = PropertyEnum.<TreeColor>create("type", TreeColor.class, new Predicate<TreeColor>() {
		@Override public boolean apply(TreeColor param_apply) {
			return param_apply.getMeta() < 4;
		}
	});
	
	public RainbowLeafBlockZL() {
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, TreeColor.RED).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, TreeColor.get((meta % 4))).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeColor) state.getValue(TYPE)).getMeta();
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		
		return i;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"}) @Override public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < 4; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override @SideOnly(Side.CLIENT) public int getRenderColor(IBlockState state) {
		return 16777215;
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.rainbowSaplingBlockZL);
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeColor) state.getValue(TYPE)).getMeta();
	}
	
	@Override public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
		return 16777215;
	}
	
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
	
	@Override protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {TYPE, CHECK_DECAY, DECAYABLE});
	}
	
	@Override public boolean isOpaqueCube() {
		return Blocks.leaves.isOpaqueCube();
	}
	
	@Override @SideOnly(Side.CLIENT) public EnumWorldBlockLayer getBlockLayer() {
		return Blocks.leaves.getBlockLayer();
	}
}