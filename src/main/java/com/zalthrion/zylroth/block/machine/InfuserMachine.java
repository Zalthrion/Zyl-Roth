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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.zalthrion.zylroth.Zylroth;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.GuiIDs;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.utility.EnumFacingUtil;

public class InfuserMachine extends BlockBaseContainer {
	private String name = "infuserMachineActive";
	private String name_idle = "infuserMachine";
	private String oreName = "oreInfuserMachineActive";
	private String oreName_idle = "oreInfuserMachine";
	private InfuserType type;
	private static boolean keepInventory;
	
	public InfuserMachine(boolean isActive, InfuserType type) {
		super(!isActive);
		this.type = type;
		this.setNames(isActive ? (type.isNormal() ? name : oreName) : (type.isNormal() ? name_idle : oreName_idle));
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setStepSound(soundTypeMetal);
	}
	
	@Override public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityInfuser(this.type);
	}
	
	@Override
	public int getRenderType() {
		return RenderIDs.blockInfuserRI;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			TileEntityInfuser tile = (TileEntityInfuser) world.getTileEntity(x, y, z);
			
			if ((tile == null) || player.isSneaking())
				return false;
			
			player.openGui(Zylroth.instance, GuiIDs.INFUSER, world, x, y, z);
			return true;
		}
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return Item.getItemFromBlock(ModBlocks.infuser_Idle);
	}
	
	public static void setState(InfuserType type, boolean active, World world, int x, int y, int z) {
		int l = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		keepInventory = true;
		
		if (active && type.isNormal()) {
			world.setBlock(x, y, z, ModBlocks.infuser);
		} else if (!active && type.isNormal()) {
			world.setBlock(x, y, z, ModBlocks.infuser_Idle);
		} else if (active && !type.isNormal()) {
			world.setBlock(x, y, z, ModBlocks.oreInfuser);
		} else if (!active && !type.isNormal()) {
			world.setBlock(x, y, z, ModBlocks.oreInfuser_Idle);
		}
		
		keepInventory = false;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
		
		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition mop, World world, int x, int y, int z, EntityPlayer player) {
		return new ItemStack(type.isNormal() ? ModBlocks.infuser_Idle : ModBlocks.oreInfuser_Idle);
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
	
	@Override public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
		EnumFacing facing = EnumFacingUtil.forPlacing((MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2);
		
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity instanceof TileEntityInfuser) {
			if (stack.hasDisplayName()) {
				((TileEntityInfuser) tileentity).setCustomInventoryName(stack.getDisplayName());
			}
			((TileEntityInfuser) tileentity).setFacing(facing);
			world.markBlockForUpdate(x, y, z);
		}
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (!this.type.isNormal()) return;
		TileEntity tile = world.getTileEntity(x, y, z);
		TileEntityInfuser tei = (TileEntityInfuser) tile;
		
		if (tei.isBurning()) {
			for (int l = x - 2; l <= x + 2; ++ l) {
				for (int i1 = z - 2; i1 <= z + 2; ++ i1) {
					if (l > x - 2 && l < x + 2 && i1 == z - 1) {
						i1 = z + 2;
					}
					
					if (rand.nextInt(16) == 0) {
						for (int j1 = y; j1 <= y + 1; ++ j1) {
							{
								if (!world.isAirBlock((l - x) / 2 + x, j1, (i1 - z) / 2 + z)) {
									break;
								}
								
								world.spawnParticle("portal", (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (l - x) + rand.nextFloat() - 0.1F), (double) ((float) (j1 - y) - rand.nextFloat() - 0.1F), (double) ((float) (i1 - z) + rand.nextFloat()) - 0.1F);
							}
						}
					}
				}
			}
		}
	}
}