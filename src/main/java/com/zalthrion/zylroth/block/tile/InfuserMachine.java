package com.zalthrion.zylroth.block.tile;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.base.BlockContainerBase;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.reference.Reference;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

// TODO Organize methods alphabetically
public class InfuserMachine extends BlockContainerBase {
	private InfuserType type;
	private static boolean keepInventory;
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<InfuserType> INFUSER_TYPE = PropertyEnum.<InfuserType>create("type", InfuserType.class);
	
	public InfuserMachine(boolean isActive, InfuserType type) {
		super();
		
		if (!isActive) this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setParticleBlockState(type.isNormal() ? BlockInit.tenebraeCore.getDefaultState() : Blocks.quartz_block.getDefaultState());
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(isActive ? (type.isNormal() ? "infuserMachineActive" : "oreInfuserMachineActive") : (type.isNormal() ? "infuserMachine" : "oreInfuserMachine"));
		
		this.type = type;
	}
	
	/* Custom Methods */
	
	public static void setState(InfuserType type, boolean active, World world, BlockPos pos) {
		IBlockState iblockstate = world.getBlockState(pos);
		TileEntity tileentity = world.getTileEntity(pos);
		keepInventory = true;
		
		if (active && type.isNormal()) {
			world.setBlockState(pos, BlockInit.infuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, BlockInit.infuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		} else if (!active && type.isNormal()) {
			world.setBlockState(pos, BlockInit.infuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, BlockInit.infuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		} else if (active && !type.isNormal()) {
			world.setBlockState(pos, BlockInit.oreInfuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, BlockInit.oreInfuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		} else if (!active && !type.isNormal()) {
			world.setBlockState(pos, BlockInit.oreInfuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, BlockInit.oreInfuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		}

        keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
	}
	
	/* Overridden */
	
	@Override public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityInfuser(this.type);
	}
	
	@Override public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) return true;
		TileEntityInfuser tei = (TileEntityInfuser) worldIn.getTileEntity(pos);
		if ((tei == null) || playerIn.isSneaking()) return false;
		playerIn.openGui(Zylroth.instance, Reference.GuiIDs.INFUSER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(state.getValue(INFUSER_TYPE).isNormal() ? BlockInit.infuserIdle : BlockInit.oreInfuserIdle);
	}
	
	@Override public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(state.getValue(INFUSER_TYPE).isNormal() ? BlockInit.infuserIdle : BlockInit.oreInfuserIdle);
	}
	
	@Override public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}
	
	@Override public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
	}
	
	@Override public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		  if (!keepInventory) {
			  TileEntity te = worldIn.getTileEntity(pos);
			  if (!(te instanceof IInventory)) return;
			  IInventory inventory = (IInventory) te;
			  
			  for (int i = 0; i < inventory.getSizeInventory(); i ++) {
				  ItemStack itemStack = inventory.removeStackFromSlot(i);
				  
				  if (itemStack != null) {
					  float spawnX = pos.getX() + worldIn.rand.nextFloat();
					  float spawnY = pos.getY() + worldIn.rand.nextFloat();
					  float spawnZ = pos.getZ() + worldIn.rand.nextFloat();
					  
					  EntityItem entityItem = new EntityItem(worldIn, spawnX, spawnY, spawnZ, itemStack);
					  
					  float f3 = 0.05F;
					  entityItem.motionX = (-0.5F + worldIn.rand.nextGaussian()) * f3;
					  entityItem.motionY = (4 + worldIn.rand.nextGaussian()) * f3;
					  entityItem.motionZ = (-0.5F + worldIn.rand.nextGaussian()) * f3;
					  
					  worldIn.spawnEntityInWorld(entityItem);
				  }
			  }
		  }
		  
		  super.breakBlock(worldIn, pos, state);
	}
	
	@Override public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(INFUSER_TYPE, this.type).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(INFUSER_TYPE, this.type).withProperty(FACING, placer.getHorizontalFacing().getOpposite())); // TODO See if this is needed
		
		if (!stack.hasDisplayName()) return;
		TileEntity te = worldIn.getTileEntity(pos);
		if (te instanceof TileEntityInfuser) {
			// ((TileEntityInfuser) te).setCustomInventoryName(stack.getDisplayName()); // TODO Add this
		}
	}
	
	@Override public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (!stateIn.getValue(INFUSER_TYPE).isNormal()) return;
		TileEntity te = worldIn.getTileEntity(pos);
		TileEntityInfuser tei = (TileEntityInfuser) te;
		
/*		if (tei.isBurning()) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			for (int i = x - 2; i <= x + 2; i ++) {
				for (int j = z - 2; j <= z + 2; j ++) {
					if (i > x - 2 && i < x + 2 && j == z - 1) {
						j = z + 2;
					}
					
					if (rand.nextInt(16) == 0) {
						for (int k = y; k <= y + 1; k ++) {
							if (!worldIn.isAirBlock(new BlockPos((i - x) / 2 + x, k, (j - z) / 2 + z))) break;
							worldIn.spawnParticle(EnumParticleTypes.PORTAL, (double) x + 0.5F, (double) y + 0.5F, (double) z + 0.5F, (double) ((float) (i - x) + rand.nextFloat() - 0.1F), (double) ((float) (k - y) - rand.nextFloat() - 0.1F), (double) ((float) (j - z) + rand.nextFloat()) - 0.1F);
						}
					}
				}
			}
		}*/ // TODO Add this
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		int i = meta & 7;
		EnumFacing facing = (i > 3) ? EnumFacing.NORTH : EnumFacing.getFront(i);
		return this.getDefaultState().withProperty(FACING, facing).withProperty(INFUSER_TYPE, ((meta & 8) > 0) ? InfuserType.ORE : InfuserType.NORMAL);
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing) state.getValue(FACING)).getIndex();
		if (!((InfuserType) state.getValue(INFUSER_TYPE)).isNormal()) {
			i |= 8;
		}
		return i;
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, INFUSER_TYPE });
	}
}