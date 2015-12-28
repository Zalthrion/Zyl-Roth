package com.zalthrion.zylroth.block.machine;

import java.util.Random;

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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class InfuserMachine extends BlockBaseContainer {
	private String name = "infuserMachineActive";
	private String name_idle = "infuserMachine";
	
	private static boolean keepInventory;
	
	public InfuserMachine(boolean isActive) {
		
		super(!isActive);
		
		this.setUnlocalizedName(isActive ? name : name_idle);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setStepSound(soundTypeMetal);
		this.setParticleBlockState(ModBlocks.tenebraeCore.getDefaultState());
	}
	
	@Override public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityInfuser();
	}
	
	@Override public int getRenderType() {
		return 2;
	}
	
	@Override public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) return true;
		TileEntityInfuser tile = (TileEntityInfuser) worldIn.getTileEntity(pos);
		
		if ((tile == null) || playerIn.isSneaking()) return false;
		
		playerIn.openGui(Zylroth.instance, GuiIDs.INFUSER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.infuserIdle);
	}
	
	public static void updateBlockState(boolean active, World world, BlockPos pos) {
		TileEntity tileentity = world.getTileEntity(pos);
		keepInventory = true;
		
		if (active) {
			world.setBlockState(pos, ModBlocks.infuser.getDefaultState(), 3);
			world.setBlockState(pos, ModBlocks.infuser.getDefaultState(), 3);
		} else {
			world.setBlockState(pos, ModBlocks.infuserIdle.getDefaultState(), 3);
			world.setBlockState(pos, ModBlocks.infuserIdle.getDefaultState(), 3);
		}

        keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
	}
	
	@Override public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
		return new ItemStack(ModBlocks.infuserIdle);
	}
	
	@Override public boolean hasComparatorInputOverride() {
		return true;
	}
	
	@Override public int getComparatorInputOverride(World world, BlockPos pos) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
	}
	
	@Override public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (!keepInventory) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (!(tileEntity instanceof IInventory)) { return; }
			IInventory inventory = (IInventory) tileEntity;
			
			for (int i = 0; i < inventory.getSizeInventory(); ++ i) {
				ItemStack itemstack = inventory.removeStackFromSlot(i);
				
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
	
	@Override public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
		TileEntity tile = world.getTileEntity(pos);
		TileEntityInfuser tei = (TileEntityInfuser) tile;
		
		if (tei.isBurning()) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			for (int l = x - 2; l <= x + 2; ++ l) {
				for (int i1 = z - 2; i1 <= z + 2; ++ i1) {
					if (l > x - 2 && l < x + 2 && i1 == z - 1) {
						i1 = z + 2;
					}
					
					if (rand.nextInt(16) == 0) {
						for (int j1 = y; j1 <= y + 1; ++ j1) {
							if (!world.isAirBlock(new BlockPos((l - x) / 2 + x, j1, (i1 - z) / 2 + z))) {
								break;
							}
							
							world.spawnParticle(EnumParticleTypes.PORTAL, (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (l - x) + rand.nextFloat() - 0.1F), (double) ((float) (j1 - y) - rand.nextFloat() - 0.1F), (double) ((float) (i1 - z) + rand.nextFloat()) - 0.1F);
						}
					}
				}
			}
		}
	}
}