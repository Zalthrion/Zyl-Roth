package com.zalthrion.zylroth.block.tree;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModInit.ZylrothTab;
import com.zalthrion.zylroth.lib.ModRegistry;

public class KyrulLogBlock extends BlockLog {
	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis> create("axis", BlockLog.EnumAxis.class);
	
	/* Constructors */
	
	public KyrulLogBlock() {
		super();
		this.setCreativeTab(ZylrothTab.ZYLROTH);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
		this.setRegistryName(ModRegistry.createRegistryNameFor("kyrulLogBlock"));
		this.setUnlocalizedName("kyrulLogBlock");
	}
	
	/* Overridden */
	
	@Override public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}
	
	@Override protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1, 0);
	}
	
	@Override public boolean isWood(IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
	}
	
	@Override public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
			case COUNTERCLOCKWISE_90:
			case CLOCKWISE_90:
				
				switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
					case X:
						return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
					case Z:
						return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
					default:
						return state;
				}
				
			default:
				return state;
		}
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		
		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
			case X:
				i |= 4;
				break;
			case Z:
				i |= 8;
				break;
			case NONE:
				i |= 12;
			default:
				break;
		}
		
		return i;
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState();
		
		switch (meta & 12) {
			case 0:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
				break;
			case 4:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
				break;
			case 8:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
				break;
			default:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}
		
		return iblockstate;
	}
}