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
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.reference.Reference;

public class RainbowSaplingBlock extends BlockBush implements IGrowable {
	public static final PropertyEnum<TreeColor> COLOR = PropertyEnum.<TreeColor>create("type", TreeColor.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	
	public RainbowSaplingBlock() {
		super();
		this.setCreativeTab(ZylrothTab.zylRoth);
		this.setRegistryName("rainbowSapling");
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName("rainbowSapling");
	}
	
	/* Custom Methods */
	
	// TODO Go over this more strictly
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos))
			return;
		int l = worldIn.getBlockState(pos).getBlock().getMetaFromState(worldIn.getBlockState(pos)) & 7;
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		
		IBlockState leafState = Blocks.air.getDefaultState();
		switch (l) {
			case 0:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.RED);
				break;
			case 1:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.ORANGE);
				break;
			case 2:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.YELLOW);
				break;
			case 3:
				leafState = BlockInit.rainbowLeafBlock.getDefaultState().withProperty(RainbowLeafBlock.COLOR, TreeColor.GREEN);
				break;
			case 4:
				leafState = BlockInit.rainbowLeafBlock2.getDefaultState().withProperty(RainbowLeafBlock2.COLOR, TreeColor.BLUE);
				break;
			case 5:
				leafState = BlockInit.rainbowLeafBlock2.getDefaultState().withProperty(RainbowLeafBlock2.COLOR, TreeColor.PURPLE);
				break;
		}
		Object object = new WorldGenTrees(true, 4, Blocks.log.getDefaultState(), leafState, false);
		
		if (flag) {
			worldIn.setBlockToAir(pos.add(i1, 0, j1));
			worldIn.setBlockToAir(pos.add(i1 + 1, 0, j1));
			worldIn.setBlockToAir(pos.add(i1, 0, j1 + 1));
			worldIn.setBlockToAir(pos.add(i1 + 1, 0, j1 + 1));
		} else {
			worldIn.setBlockToAir(pos);
		}
		
		if (!((WorldGenerator) object).generate(worldIn, rand, pos.add(i1, 0, j1))) {
			if (flag) {
				worldIn.setBlockState(pos.add(i1, 0, j1), this.getStateFromMeta(l), 4);
				worldIn.setBlockState(pos.add(i1 + 1, 0, j1), this.getStateFromMeta(l), 4);
				worldIn.setBlockState(pos.add(i1, 0, j1 + 1), this.getStateFromMeta(l), 4);
				worldIn.setBlockState(pos.add(i1 + 1, 0, j1 + 1), this.getStateFromMeta(l), 4);
			} else {
				worldIn.setBlockState(pos, this.getStateFromMeta(l), 4);
			}
		}
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (((Integer) state.getValue(STAGE)).intValue() == 0) {
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		} else {
			this.generateTree(worldIn, pos, state, rand);
		}
	}
	
	/* Overridden */
	
	@Override public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
	@Override public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COLOR, STAGE });
	}
	
	@Override public int damageDropped(IBlockState state) {
		return ((TreeColor) state.getValue(COLOR)).getMetadata();
	}
	
	// TODO Check mappings
	@Override public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}
	
	@Override public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((TreeColor) state.getValue(COLOR)).getMetadata();
        i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
        return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(COLOR, TreeColor.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	//TODO Check mappings
	@Override @SideOnly(Side.CLIENT) public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		for (TreeColor color : TreeColor.values()) list.add(new ItemStack(item, 1, color.getMetadata()));
	}
	
	@Override public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	@Override public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state, rand);
	}
	
	@Override public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			super.updateTick(worldIn, pos, state, rand);
			
			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) this.grow(worldIn, pos, state, rand);
		}
	}
}