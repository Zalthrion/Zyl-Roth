package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;

public class VoidiumOre extends BlockBase {
	
	private String name = "voidiumOre";
	
	public VoidiumOre() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(world, pos, state, rand);
		
		double d0 = (double) ((float) pos.getX() + (1.5F + rand.nextFloat() * 12.0F) / 16.0F);
		double d1 = (double) ((float) pos.getY() + 1.1F);
		double d2 = (double) ((float) pos.getZ() + (1.5F + rand.nextFloat() * 12.0F) / 16.0F);
		world.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, -0.1, 0.2, 1);
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.raw_Tenebrae;
	}
	
	@Override public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(5);
	}
	
	@Override public int quantityDroppedWithBonus(int fortune, Random rand) {
		if (fortune <= 0) return quantityDropped(rand);
		
		int j = rand.nextInt(fortune + 2) - 1;
		if (j < 0) j = 0;
		return quantityDropped(rand) * (j + 1);
	}
}