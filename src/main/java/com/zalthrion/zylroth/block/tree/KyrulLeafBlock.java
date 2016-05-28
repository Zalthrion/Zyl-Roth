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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class KyrulLeafBlock extends BlockLeaves {
	public static final PropertyEnum<KyrulTreeType> TYPE = PropertyEnum.<KyrulTreeType>create("type", KyrulTreeType.class);
	
	public KyrulLeafBlock() {
		super();
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "kyrulLeaves"));
		this.setUnlocalizedName("kyrulLeaves");
	}
	
	/* Custom Methods */
	
	public KyrulTreeType getTreeType(int meta) {
		return KyrulTreeType.byMetadata(meta);
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
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
	
	@Override @SideOnly(Side.CLIENT) public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockInit.kyrulSaplingBlock);
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
	
	@Override @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
		for (int i = 0; i < 4; i ++) list.add(new ItemStack(item, 1, i));
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
	
	@Override public boolean isOpaqueCube(IBlockState state) {
		return Blocks.LEAVES.isOpaqueCube(Blocks.LEAVES.getDefaultState());
	}
	
	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)))));
	}
}