package com.zalthrion.zylroth.block.machine;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;

public class GoldBag extends BlockBaseContainer {
	private String name = "goldBag";
	
	public GoldBag() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setParticleBlockState(Blocks.gold_block.getDefaultState());
	}
	
	@Override public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGoldBag();
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		EnumFacing facing = placer.getHorizontalFacing().getOpposite();
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof TileEntityGoldBag) {
			((TileEntityGoldBag) tileentity).setFacing(facing);
			tileentity.markDirty();
		}
	}
}