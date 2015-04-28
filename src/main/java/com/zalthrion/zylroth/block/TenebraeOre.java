package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.lib.ModTabs;

public class TenebraeOre extends BlockBase {
	
	private String name = "tenebraeOre";
	
	public TenebraeOre() {
		super(Material.rock);
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModTabs.ZylRoth);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(world, pos, state, rand);
		
		double d0 = (double) ((float) pos.getX() + (1.5F + rand.nextFloat() * 12.0F) / 16.0F);
		double d1 = (double) ((float) pos.getY() + 0.4F);
		double d2 = (double) ((float) pos.getZ() + (1.5F + rand.nextFloat() * 12.0F) / 16.0F);
		world.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, 0, 0, 0);
	}
}