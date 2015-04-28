package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.EntityMutantTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

public class ChiseledTenebrae extends BlockBase {
	private String name = "chiseledTenebrae";
	
	public ChiseledTenebrae() {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setNames(name);
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		
		if (world.getBlockState(pos.down()).getBlock() == ModBlocks.tenebrae_Core && world.getBlockState(pos.down(2)).getBlock() == ModBlocks.infused_Tenebrae) {
			boolean flag = world.getBlockState(pos.add(-1, -1, 0)).getBlock() == ModBlocks.infused_Tenebrae && world.getBlockState(pos.add(1, -1, 0)).getBlock() == ModBlocks.infused_Tenebrae;
			boolean flag1 = world.getBlockState(pos.add(0, -1, -1)).getBlock() == ModBlocks.infused_Tenebrae && world.getBlockState(pos.add(0, -1, 1)).getBlock() == ModBlocks.infused_Tenebrae;
			
			if (flag || flag1) {
				world.setBlockToAir(pos);
				world.setBlockToAir(pos.add(0, -1, 0));
				world.setBlockToAir(pos.add(0, -2, 0));
				
				if (flag) {
					world.setBlockToAir(pos.add(-1, -1, 0));
					world.setBlockToAir(pos.add(1, -1, 0));
				} else {
					world.setBlockToAir(pos.add(0, -1, -1));
					world.setBlockToAir(pos.add(0, -1, 1));
				}
				
				EntityMutantTenebraeGolem golem = new EntityMutantTenebraeGolem(world);
				golem.setPlayerCreated(true);
				golem.setLocationAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() - 1.95D, (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(golem);
				
				for (int i1 = 0; i1 < 120; ++ i1) {
					world.spawnParticle(EnumParticleTypes.SNOWBALL, (double) pos.getX() + world.rand.nextDouble(), (double) (pos.getY() - 2) + world.rand.nextDouble() * 3.9D, (double) pos.getZ() + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		
		if (world.getBlockState(pos.down()).getBlock() == ModBlocks.tenebrae_Block && world.getBlockState(pos.down(2)).getBlock() == ModBlocks.tenebrae_Block) {
			boolean flag = world.getBlockState(pos.west().down()).getBlock() == ModBlocks.tenebrae_Block && world.getBlockState(pos.east().down()).getBlock() == ModBlocks.tenebrae_Block;
			boolean flag1 = world.getBlockState(pos.down().north()).getBlock() == ModBlocks.tenebrae_Block && world.getBlockState(pos.down().south()).getBlock() == ModBlocks.tenebrae_Block;
			
			if (flag || flag1) {
				world.setBlockToAir(pos);
				world.setBlockToAir(pos.down());
				world.setBlockToAir(pos.down(2));
				
				if (flag) {
					world.setBlockToAir(pos.west().down());
					world.setBlockToAir(pos.east().down());
				} else {
					world.setBlockToAir(pos.down().north());
					world.setBlockToAir(pos.down().south());
				}
				
				EntityTenebraeGolem golem = new EntityTenebraeGolem(world);
				golem.setPlayerCreated(true);
				golem.setLocationAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() - 1.95D, (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(golem);
				
				for (int i1 = 0; i1 < 120; ++ i1) {
					world.spawnParticle(EnumParticleTypes.SNOWBALL, (double) pos.getX() + world.rand.nextDouble(), (double) (pos.getY() - 2) + world.rand.nextDouble() * 3.9D, (double) pos.getZ() + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}