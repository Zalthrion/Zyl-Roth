package com.zalthrion.zylroth.block.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

public class IridisLeafBlock extends BlockLeaves {
	public static final String[] leaf_types = new String[] {"autumnTree"};
	
	public IridisLeafBlock() {
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override
	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(IBlockState state) {
		return 16777215;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.iridisSaplingBlock);
	}
	
	@Override
	public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
		return 16777215;
	}
	
	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        IBlockState state = world.getBlockState(pos);
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(state))));
	}

	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
	
	@Override protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
	}
	
	@Override public boolean isOpaqueCube() {
		return Blocks.leaves.isOpaqueCube();
	}
	
	@Override @SideOnly(Side.CLIENT) public EnumWorldBlockLayer getBlockLayer() {
		return Blocks.leaves.getBlockLayer();
	}
}