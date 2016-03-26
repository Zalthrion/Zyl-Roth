package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.BlockBase;

public class EmpoweredTenebraeCore extends BlockBase {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public EmpoweredTenebraeCore() {
		super(Material.rock);
		this.setCreativeTab();
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName("empoweredTenebraeCore");
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}
	
	@Override public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()));
	}
	
	@Override public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		super.randomDisplayTick(state, world, pos, rand);
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		for (int i = x - 2; i <= x + 2; i ++) {
			for (int j = z - 2; j <= z + 2; j ++) {
				if (i > x - 2 && i < x + 2 && j == z - 1) j = z + 2;
				if (rand.nextInt(16) == 0) {
					for (int k = y; k <= y + 1; k ++) {
						if (!world.isAirBlock(new BlockPos((i - x) / 2 + x, k, (j - z) / 2 + z))) break;
						
						world.spawnParticle(EnumParticleTypes.PORTAL, (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (i - x) + rand.nextFloat() - 0.1F), (double) ((float) (k - y) - rand.nextFloat() - 0.1F), (double) ((float) (j - z) + rand.nextFloat()) - 0.1F);
					}
				}
			}
		}
	}
	
	@Override public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
	}
	
	@Override public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}
}