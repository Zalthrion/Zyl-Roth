package com.zalthrion.zylroth.block.tree;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

public class RainbowSaplingBlock extends BlockBush implements IGrowable {
	public static final PropertyEnum<TreeColor> TYPE = PropertyEnum.<TreeColor>create("type", TreeColor.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	public RainbowSaplingBlock() {
		super();
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setStepSound(soundTypeGrass);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, random);
			
			if (worldIn.getLight(pos.add(0, 1, 0)) >= 9 && random.nextInt(7) == 0) {
				this.grow(worldIn, random, pos, state);
			}
		}
	}
	
	@Override public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		int l = worldIn.getBlockState(pos).getBlock().getMetaFromState(state);
		
		if ((l & 8) == 0) {
			worldIn.setBlockState(pos, state.getBlock().getStateFromMeta(l | 8), 4);
		}
		else {
			this.generateTree(worldIn, pos, rand);
		}
	}
	
	public void generateTree(World world, BlockPos pos, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, pos))
			return;
		int l = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos)) & 7;
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		IBlockState leafState = Blocks.air.getDefaultState();
		switch (l) {
			case 0:
				leafState = ModBlocks.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.TYPE, TreeColor.RED);
				break;
			case 1:
				leafState = ModBlocks.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.TYPE, TreeColor.ORANGE);
				break;
			case 2:
				leafState = ModBlocks.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.TYPE, TreeColor.YELLOW);
				break;
			case 3:
				leafState = ModBlocks.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.TYPE, TreeColor.GREEN);
				break;
			case 4:
				leafState = ModBlocks.rainbowLeafBlock2.getDefaultState().withProperty(RainbowLeafBlock2.TYPE, TreeColor.BLUE);
				break;
			case 5:
				leafState = ModBlocks.rainbowLeafBlock2.getDefaultState().withProperty(RainbowLeafBlock2.TYPE, TreeColor.PURPLE);
				break;
		}
		Object object = new WorldGenTrees(true, 4, Blocks.log.getDefaultState(), leafState, false);
		
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
	
	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return this.getMetaFromState(state);
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		for (TreeColor color : TreeColor.values()) {
			list.add(new ItemStack(item, 1, color.getMeta()));
		}
	}
	
	@Override public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, TreeColor.get(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((TreeColor) state.getValue(TYPE)).getMeta();
        i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
	@Override protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {TYPE, STAGE});
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}