package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModTabs;

public class EmpoweredTenebraeCore extends BlockBase {
	
	private String name = "empoweredTenebraeCore";
	
	public EmpoweredTenebraeCore() {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(ModTabs.zylRoth);
	}
	
	@Override
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(world, pos, state, rand);
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		for (int l = x - 2; l <= x + 2; ++ l) {
			for (int i1 = z - 2; i1 <= z + 2; ++ i1) {
				if (l > x - 2 && l < x + 2 && i1 == z - 1) i1 = z + 2;
				if (rand.nextInt(16) == 0) {
					for (int j1 = y; j1 <= y + 1; ++ j1) {
						if (!world.isAirBlock(new BlockPos((l - x) / 2 + x, j1, (i1 - z) / 2 + z))) break;
						
						world.spawnParticle(EnumParticleTypes.PORTAL, (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (l - x) + rand.nextFloat() - 0.1F), (double) ((float) (j1 - y) - rand.nextFloat() - 0.1F), (double) ((float) (i1 - z) + rand.nextFloat()) - 0.1F);
					}
				}
			}
		}
	}
	
/*	@Override public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) {
		int l = MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}*/ //TODO Make this block rotatable or whatever this was supposed to do
}