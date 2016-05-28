package com.zalthrion.zylroth.block.tree;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class IridisSaplingBlock extends BlockBush implements IGrowable {
	public static final PropertyEnum<IridisTreeType> SAPLING_TYPE = PropertyEnum.<IridisTreeType>create("type", IridisTreeType.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	
	public IridisSaplingBlock() {
		super();
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setRegistryName("iridisSapling");
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName("iridisSapling");
	}
	
	/* Custom Methods */
	
	// TODO Go over this more strictly
	public void generateTree(World world, BlockPos pos, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, pos)) return;
		int l = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) & 7;
		Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		switch (l) {
			case 0:
				object = new WorldGenTrees(true, 4, Blocks.LOG.getDefaultState(), BlockInit.iridisLeafBlock.getDefaultState(), false);
				break;
			case 1:
				object = new WorldGenTrees(true, 4, Blocks.LOG.getDefaultState(), BlockInit.iridisLeafBlock.getDefaultState().withProperty(IridisLeafBlock.LEAF_TYPE, IridisTreeType.SAKURA), false);
				break;
			default:
				break;
		}
		
		if (flag) {
			world.setBlockToAir(pos.add(i1, 0, j1));
			world.setBlockToAir(pos.add(i1 + 1, 0, j1));
			world.setBlockToAir(pos.add(i1, 0, j1 + 1));
			world.setBlockToAir(pos.add(i1 + 1, 0, j1 + 1));
		} else {
			world.setBlockToAir(pos);
		}
		
		if (!((WorldGenerator) object).generate(world, rand, pos.add(i1, 0, j1))) {
			if (flag) {
				world.setBlockState(pos.add(i1, 0, j1), this.getStateFromMeta(l), 4);
				world.setBlockState(pos.add(i1 + 1, 0, j1), this.getStateFromMeta(l), 4);
				world.setBlockState(pos.add(i1, 0, j1 + 1), this.getStateFromMeta(l), 4);
				world.setBlockState(pos.add(i1 + 1, 0, j1 + 1), this.getStateFromMeta(l), 4);
			} else {
				world.setBlockState(pos, this.getStateFromMeta(l), 4);
			}
		}
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int l = worldIn.getBlockState(pos).getBlock().getMetaFromState(state);
		
		if ((l & 8) == 0) {
			worldIn.setBlockState(pos, state.getBlock().getStateFromMeta(l | 8), 4);
		} else {
			this.generateTree(worldIn, pos, rand);
		}
	}
	
	/* Overridden */
	
	// TODO Check mappings
	@Override public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
	// TODO Check mappings
	@Override public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return worldIn.rand.nextFloat() < 0.45F;
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { SAPLING_TYPE, STAGE });
	}
	
	// TODO Check mappings
	@Override public int damageDropped(IBlockState state) {
		return ((IridisTreeType) state.getValue(SAPLING_TYPE)).getMetadata();
	}
	
	@Override public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}
	
	@Override public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((IridisTreeType) state.getValue(SAPLING_TYPE)).getMetadata();
        i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(SAPLING_TYPE, IridisTreeType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		for (int i = 0; i < IridisTreeType.values().length; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	// TODO Check mappings
	@Override public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, random);
			
			if (worldIn.getLight(pos.add(0, 1, 0)) >= 9 && random.nextInt(7) == 0) {
				this.grow(worldIn, pos, state, random);
			}
		}
	}

	@Override public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state, rand);
	}
}