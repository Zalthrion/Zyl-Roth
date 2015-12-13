package com.zalthrion.zylroth.block.machine;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;

public class OreInfuserMachine extends BlockBaseContainer {
	
	private String name = "oreInfuserMachineActive";
	private String name_idle = "oreInfuserMachine";
	
	private static boolean keepInventory;
	
	public OreInfuserMachine(boolean isActive) {
		
		super(!isActive);
		
		this.setNames(isActive ? name : name_idle);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setStepSound(soundTypeMetal);
	}
	
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityOreInfuser();
	}
	
	@Override
	public int getRenderType() {
		return RenderIDs.blockOreInfuserRI;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			TileEntityOreInfuser tile = (TileEntityOreInfuser) world.getTileEntity(x, y, z);
			
			if ((tile == null) || player.isSneaking())
				return false;
			
			player.openGui(Zylroth.instance, GuiIDs.ORE_INFUSER, world, x, y, z);
			return true;
		}
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(ModBlocks.oreInfuser_Idle);
	}
	
	public static void updateBlockState(boolean active, World world, int x, int y, int z) {
		int i = world.getBlockMetadata(x, y, z);
		
		TileEntity tile = world.getTileEntity(x, y, z);
		keepInventory = true;
		
		if (active) {
			world.setBlock(x, y, z, ModBlocks.oreInfuser);
		}
		
		else {
			world.setBlock(x, y, z, ModBlocks.oreInfuser_Idle);
		}
		
		keepInventory = false;
		
		world.setBlockMetadataWithNotify(x, y, z, i, 2);
		
		if (tile != null) {
			tile.validate();
			world.setTileEntity(x, y, z, tile);
		}
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition mop, World world, int x, int y, int z, EntityPlayer player) {
		return new ItemStack(ModBlocks.oreInfuser_Idle);
	}
	
	@Override
	public boolean hasComparatorInputOverride() {
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!keepInventory) {
			TileEntity tileEntity = world.getTileEntity(x, y, z);
			if (!(tileEntity instanceof IInventory)) { return; }
			IInventory inventory = (IInventory) tileEntity;
			
			for (int i = 0; i < inventory.getSizeInventory(); ++ i) {
				ItemStack itemstack = inventory.getStackInSlotOnClosing(i);
				
				if (itemstack != null) {
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();
					
					EntityItem entityitem = new EntityItem(world, spawnX, spawnY, spawnZ, itemstack);
					
					float f3 = 0.05F;
					entityitem.motionX = (-0.5F + world.rand.nextGaussian()) * f3;
					entityitem.motionY = (4 + world.rand.nextGaussian()) * f3;
					entityitem.motionZ = (-0.5F + world.rand.nextGaussian()) * f3;
					
					world.spawnEntityInWorld(entityitem);
				}
			}
		}
		
		super.breakBlock(world, x, y, z, block, meta);
	}
	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack itemStack) {
		int facing = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		facing ++;
		TileEntity te = world.getTileEntity(i, j, k);
		if (te != null && te instanceof TileEntityOreInfuser) {
			TileEntityOreInfuser tei = (TileEntityOreInfuser) te;
			tei.setFacing(facing);
			world.markBlockForUpdate(i, j, k);
		}
	}
}