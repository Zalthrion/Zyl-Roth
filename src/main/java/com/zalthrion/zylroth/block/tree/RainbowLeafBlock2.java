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
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class RainbowLeafBlock2 extends BlockLeaves {
	public static final PropertyEnum<TreeColor> COLOR = PropertyEnum.<TreeColor>create("type", TreeColor.class, new Predicate<TreeColor>() {
		@Override public boolean apply(TreeColor input) {
			return (input.getMetadata() > 3) && (input.getMetadata() < 6);
		}
	});
	
	public RainbowLeafBlock2() {
		super();
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, TreeColor.BLUE).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setRegistryName("rainbowLeafBlock2");
		this.setUnlocalizedName("rainbowLeafBlock2");
	}
	
	/* Custom Methods */
	
	public TreeColor getTreeColor(int meta) {
		return TreeColor.byMetadata((meta & 3) + 4);
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	/* Overridden */
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COLOR, CHECK_DECAY, DECAYABLE });
	}
	
	// TODO Check mappings
	@Override public ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(this, 1, (state.getBlock().getMetaFromState(state) - 4)); // TODO Check this.
	}
	
	// TODO Check mappings
	@Override public int damageDropped(IBlockState state) {
		return ((TreeColor) state.getValue(COLOR)).getMetadata();
	}
	
	// TODO Check mappings
	@Override protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		if (worldIn.rand.nextInt(chance) == 0) spawnAsEntity(worldIn, pos, new ItemStack(Items.golden_apple));
	}
	
	@Override @SideOnly(Side.CLIENT) public BlockRenderLayer getBlockLayer() {
		return Blocks.leaves.getBlockLayer();
	}
	
	// TODO Check mappings
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlockInit.rainbowSaplingBlock);
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TreeColor) state.getValue(COLOR)).getMetadata() - 4;
		
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
	
	// TODO Check mappings
	@Override @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
		for (int i = 4; i < 6; i ++) list.add(new ItemStack(item, 1, i));
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	// TODO Check mappings
	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
	
	// TODO Check mappings
	@Override public boolean isOpaqueCube(IBlockState state) {
		return Blocks.leaves.isOpaqueCube(Blocks.leaves.getDefaultState());
	}
	
	// TODO Check mappings
	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)))));
	}
}