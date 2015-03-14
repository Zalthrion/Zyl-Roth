package com.zalthrion.zylroth.block.machine;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

public class InfuserMachine extends BlockBaseContainer {
	
	private String name = "infuserMachineActive";
	private String name_idle = "infuserMachine";
	
	private InventoryPlayer inventory;
	private TileEntityInfuser tile;
	
	private final boolean isActive;
	private static boolean keepInventory;
	
	public InfuserMachine(boolean isActive) {
		
		super(!isActive);
		
		this.setNames(isActive ? name : name_idle);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setStepSound(soundTypeMetal);
		this.isActive = isActive;
		
	}
	
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new TileEntityInfuser();
	}
	
	@Override public int getRenderType() {
		return RenderIDs.blockInfuserRI;
	}
	
	@Override public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			TileEntityInfuser tile = (TileEntityInfuser) world.getTileEntity(x, y, z);
			
			if ((tile == null) || player.isSneaking()) return false;
			
			player.openGui(Zylroth.instance, GuiIDs.INFUSER, world, x, y, z);
			return true;
		}
	}
	
	public Block blockDropped(int par1, Random random, int par3) {
		return ModBlocks.Infuser_Idle;
		
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
	
	public static void updateBlockState(boolean active, World world, int x, int y, int z) {
		
		int i = world.getBlockMetadata(x, y, z);
		
		TileEntity tile = world.getTileEntity(x, y, z);
		keepInventory = true;
		
		if (active) {
			world.setBlock(x, y, z, ModBlocks.Infuser);
			
		} else {
			
			world.setBlock(x, y, z, ModBlocks.Infuser_Idle);
		}
		
		keepInventory = false;
		
		world.setBlockMetadataWithNotify(x, y, z, i, 2);
		
		if (tile != null) {
			tile.validate();
			world.setTileEntity(x, y, z, tile);
		}
	}
	
	public Block blockPicked(World world, int x, int y, int z) {
		return ModBlocks.Infuser_Idle;
	}
	
	public boolean hasComparatorInputOverride() {
		return true;
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}
	
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
	
}