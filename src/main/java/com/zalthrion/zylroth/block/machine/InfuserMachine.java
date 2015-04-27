package com.zalthrion.zylroth.block.machine;

import java.util.Random;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class InfuserMachine extends BlockBaseContainer {
	
	private String name = "infuserMachineActive";
	private String name_idle = "infuserMachine";
	
	private static final PropertyBool active = PropertyBool.create("active");
	
	private static boolean keepInventory;
	
	public InfuserMachine(boolean isActive) {
		
		super(!isActive);
		
		this.setNames(isActive ? name : name_idle);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(active, false));
		this.setStepSound(soundTypeMetal);
	}
	
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityInfuser();
	}
	
	@Override
	public int getRenderType() {
		return RenderIDs.blockInfuserRI;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
			return true;
		else {
			TileEntityInfuser tile = (TileEntityInfuser) worldIn.getTileEntity(pos);
			
			if ((tile == null) || playerIn.isSneaking()) return false;
			
			playerIn.openGui(Zylroth.instance, GuiIDs.INFUSER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.Infuser_Idle);
	}
	
	public static IBlockState getActiveState(IBlockState state, boolean isActive) {
		return state.withProperty(active, isActive);
	}
	
	public static void updateBlockState(boolean active, World world, BlockPos pos) {
		world.setBlockState(pos, getActiveState(world.getBlockState(pos), active));
		
		TileEntity tile = world.getTileEntity(pos);
		if (tile != null) {
			tile.validate();
			world.setTileEntity(pos, tile);
		}
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
		return new ItemStack(ModBlocks.Infuser_Idle);
	}
	
	@Override
	public boolean hasComparatorInputOverride() {
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(World world, BlockPos pos) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (!keepInventory) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (!(tileEntity instanceof IInventory)) { return; }
			IInventory inventory = (IInventory) tileEntity;
			
			for (int i = 0; i < inventory.getSizeInventory(); ++ i) {
				ItemStack itemstack = inventory.getStackInSlotOnClosing(i);
				
				if (itemstack != null) {
					float spawnX = pos.getX() + world.rand.nextFloat();
					float spawnY = pos.getY() + world.rand.nextFloat();
					float spawnZ = pos.getZ() + world.rand.nextFloat();
					
					EntityItem entityitem = new EntityItem(world, spawnX, spawnY, spawnZ, itemstack);
					
					float f3 = 0.05F;
					entityitem.motionX = (-0.5F + world.rand.nextGaussian()) * f3;
					entityitem.motionY = (4 + world.rand.nextGaussian()) * f3;
					entityitem.motionZ = (-0.5F + world.rand.nextGaussian()) * f3;
					
					world.spawnEntityInWorld(entityitem);
				}
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		int facing = MathHelper.floor_double((double) ((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		facing ++;
		TileEntity te = world.getTileEntity(pos);
		if (te != null && te instanceof TileEntityInfuser) {
			TileEntityInfuser tei = (TileEntityInfuser) te;
			tei.setFacing(facing);
			world.markBlockForUpdate(pos);
		}
	}
}