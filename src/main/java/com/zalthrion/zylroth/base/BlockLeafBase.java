package com.zalthrion.zylroth.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.reference.Reference;

public class BlockLeafBase extends BlockLeaves {
	private int startMeta;
	private int endMeta;
	
	/* Constructors */
	
	public BlockLeafBase() {
		super();
	}
	
	/* Custom Methods */
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public BlockLeafBase setCreativeTab() {
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		return this;
	}
	
	public BlockLeafBase setMetaRange(int startMeta, int endMeta) {
		this.startMeta = startMeta;
		this.endMeta = endMeta;
		return this;
	}
	
	public BlockLeafBase setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(ModRegistry.createRegistryNameFor(name));
		return this;
	}
	
	/* Overridden */
	
	@Override @SideOnly(Side.CLIENT) public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}
	
	@Override @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
		for (int i = this.startMeta; i <= this.endMeta; i ++) list.add(new ItemStack(item, 1, i));
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, this.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}
	
	@Override public boolean isOpaqueCube(IBlockState state) {
		return Blocks.LEAVES.isOpaqueCube(Blocks.LEAVES.getDefaultState());
	}
	
	@Override public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        IBlockState state = world.getBlockState(pos);
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this, 1, this.getMetaFromState(state))));
	}
}