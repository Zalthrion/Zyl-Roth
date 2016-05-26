package com.zalthrion.zylroth.block;

import com.zalthrion.zylroth.block.machine.BlockBaseContainer;
import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.tile.TileEntityBenzennStatue;
import com.zalthrion.zylroth.utility.EnumFacingUtil;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BenzennStatue extends BlockBaseContainer {
	private String name = "benzennStatue";
	
	public BenzennStatue() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBenzennStatue();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
		EnumFacing facing = EnumFacingUtil.forPlacing((MathHelper.floor_double(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3) + 2);
		
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if (tileentity instanceof TileEntityBenzennStatue) {
			((TileEntityBenzennStatue) tileentity).setFacing(facing);
			world.markBlockForUpdate(x, y, z);
		}
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldIn, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x + this.minX - 0.5F, y + this.minY, z + this.minZ, x + this.maxX + 0.5F, y + this.maxY + 1.8F, z + this.maxZ + 0.1F);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldIn, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x + this.minX - 0.5F, y + this.minY, z + this.minZ, x + this.maxX + 0.5F, y + this.maxY + 1.8F, z + this.maxZ + 0.1F);
	}
}