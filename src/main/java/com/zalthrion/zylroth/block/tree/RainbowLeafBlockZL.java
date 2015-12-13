package com.zalthrion.zylroth.block.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

public class RainbowLeafBlockZL extends BlockLeaves {
	public static final String[][] leaf_names = new String[][] { {"rainbowBlueLeaves", "rainbowRedLeaves", "rainbowPurpleLeaves", "rainbowYellowLeaves", "rainbowGreenLeaves"}, {"rainbowBlueLeaves_opaque", "rainbowRedLeaves_opaque", "rainbowPurpleLeaves_opaque", "rainbowYellowLeaves_opaque", "rainbowGreenLeaves"}};
	public static final String[] leaf_types = new String[] {"rainbowBlue", "rainbowRed", "rainbowPurple", "rainbowYellow", "rainbowGreen"};
	
	public RainbowLeafBlockZL() {
		this.setTickRandomly(true);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"}) @Override public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < leaf_types.length; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override public boolean isOpaqueCube() {
		return false;
	}
	
	@Override @SideOnly(Side.CLIENT) public int getRenderColor(IBlockState state) {
		return 16777215;
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.rainbowSaplingBlockZL);
	}
	
	@Override public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
		return 16777215;
	}
	
	@Override protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		if (worldIn.rand.nextInt(chance) == 0) {
			spawnAsEntity(worldIn, pos, new ItemStack(Items.apple, 1, 0));
		}
	}

	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        IBlockState state = world.getBlockState(pos);
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(state))));
	}

	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
}