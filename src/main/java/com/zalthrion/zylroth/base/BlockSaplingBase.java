package com.zalthrion.zylroth.base;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.block.tree.CustomTreeData;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;
import com.zalthrion.zylroth.reference.Reference;

public class BlockSaplingBase extends BlockBush implements IGrowable {
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	protected HashMap<Integer, CustomTreeData> treeGrowth = new HashMap<Integer, CustomTreeData>();
	
	private int numSubBlocks = 1;
	
	/* Constructors */
	
	public BlockSaplingBase() {
		super();
	}
	
	/* Custom Methods */
	
	public BlockSaplingBase addTreeGrowth(int meta, IBlockState log, IBlockState leaves) {
		return this.addTreeGrowth(meta, log, leaves, 4, false);
	}
	
	public BlockSaplingBase addTreeGrowth(int meta, IBlockState log, IBlockState leaves, int minimumHeight) {
		return this.addTreeGrowth(meta, log, leaves, minimumHeight, false);
	}
	
	public BlockSaplingBase addTreeGrowth(int meta, IBlockState log, IBlockState leaves, boolean hasVines) {
		return this.addTreeGrowth(meta, log, leaves, 4, hasVines);
	}
	
	public BlockSaplingBase addTreeGrowth(int meta, IBlockState log, IBlockState leaves, int minimumHeight, boolean hasVines) {
		this.treeGrowth.put(meta, new CustomTreeData(log, leaves).setMinimumHeight(minimumHeight).setHasVines(hasVines));
		return this;
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public void generateTree(World world, BlockPos pos, Random rand) {
		if (!TerrainGen.saplingGrowTree(world, rand, pos)) return;
		int blockMeta = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) & 7;
		int i1 = 0;
		int j1 = 0;
		WorldGenTrees worldGenTrees = new WorldGenTrees(true);
		
		for (Integer treeGrowthMeta : this.treeGrowth.keySet()) {
			if (blockMeta == treeGrowthMeta) {
				CustomTreeData data = this.treeGrowth.get(treeGrowthMeta);
				worldGenTrees = new WorldGenTrees(true, data.getMinimumHeight(), data.getLogState(), data.getLeavesState(), data.getHasVines());
			}
		}
		
		world.setBlockToAir(pos);
		
		if (!worldGenTrees.generate(world, rand, pos.add(i1, 0, j1))) {
			world.setBlockState(pos, this.getStateFromMeta(blockMeta), 4);
		}
	}
	
	public BlockSaplingBase setCreativeTab() {
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		return this;
	}
	
	public BlockSaplingBase setNames(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(ModRegistry.createRegistryNameFor(name));
		return this;
	}
	
	public BlockSaplingBase setNumSubBlocks(int num) {
		this.numSubBlocks = num;
		return this;
	}
	
	/* Overridden */
	
	@Override public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
	@Override public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return worldIn.rand.nextFloat() < 0.45F;
	}
	
	@Override public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}
	
	@Override @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		for (int i = 0; i < this.numSubBlocks; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		int l = worldIn.getBlockState(pos).getBlock().getMetaFromState(state);
		
		if ((l & 8) == 0) {
			worldIn.setBlockState(pos, state.getBlock().getStateFromMeta(l | 8), 4);
		} else {
			this.generateTree(worldIn, pos, rand);
		}
	}
	
	@Override public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, random);
			
			if (worldIn.getLight(pos.add(0, 1, 0)) >= 9 && random.nextInt(7) == 0) {
				this.grow(worldIn, random, pos, state);
			}
		}
	}
}