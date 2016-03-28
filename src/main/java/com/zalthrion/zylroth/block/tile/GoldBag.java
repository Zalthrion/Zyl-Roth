package com.zalthrion.zylroth.block.tile;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.BlockContainerBase;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;

public class GoldBag extends BlockContainerBase {
	public GoldBag() {
		super(Material.iron);
		this.setCreativeTab();
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setParticleBlockState(Blocks.gold_block.getDefaultState());
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName("goldBag");
	}
	
	@Override public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGoldBag();
	}
	
	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		// TODO Placement orientation using BlockState
	}
}