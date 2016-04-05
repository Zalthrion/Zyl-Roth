package com.zalthrion.zylroth.block.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;

public class IridisLeafBlock extends BlockLeaves {
	public static final PropertyEnum<IridisTreeType> LEAF_TYPE = PropertyEnum.<IridisTreeType>create("type", IridisTreeType.class);
	
	public IridisLeafBlock() {
		super();
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEAF_TYPE, IridisTreeType.AUTUMN).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setRegistryName("iridisLeafBlock");
		this.setUnlocalizedName("iridisLeafBlock");
	}
	
	/* Custom Methods */
	
	public IridisTreeType getLeafType(int meta) {
		return IridisTreeType.byMetadata((meta & 3) % 4);
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LEAF_TYPE, CHECK_DECAY, DECAYABLE });
	}
	
	// TODO Check mappings
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state) & 3);
	}
	
	@Override @SideOnly(Side.CLIENT) public BlockRenderLayer getBlockLayer() {
		return Blocks.leaves.getBlockLayer();
	}
	
	// TODO Check mappings
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockInit.iridisSaplingBlock);
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
	
	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
	
	@Override public boolean isOpaqueCube(IBlockState state) {
		return Blocks.leaves.isOpaqueCube(Blocks.leaves.getDefaultState());
	}
	
	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        IBlockState state = world.getBlockState(pos);
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(state))));
	}
}