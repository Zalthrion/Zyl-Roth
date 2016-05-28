package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.BlockBase;

public class GoldBag extends BlockBase {
	// TODO EnumFacing
	public GoldBag() {
		super(Material.IRON);
		this.setCreativeTab();
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("goldBag");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
	}
	
	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		// TODO Placement orientation using BlockState
	}
}