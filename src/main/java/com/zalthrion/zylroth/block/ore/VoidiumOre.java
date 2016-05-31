package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

public class VoidiumOre extends BlockBase {
	public VoidiumOre() {
		super(Material.ROCK);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setNames("voidiumOre");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.VOIDIUM_CHUNK;
	}
	
	@Override public int quantityDropped(Random random) {
		return 2 + random.nextInt(4);
	}
	
	@Override public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
		
		double d0 = pos.getX() + (1.5F + rand.nextFloat() * 12.0F) / 16.0F;
		double d1 = pos.getY() + 1.1F;
		double d2 = pos.getZ() + (1.5F + rand.nextFloat() * 12.0F) / 16.0F;
		worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, -0.1, 0.2, 1);
	}
}