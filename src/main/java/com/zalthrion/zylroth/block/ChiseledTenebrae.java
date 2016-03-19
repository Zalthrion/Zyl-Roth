package com.zalthrion.zylroth.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModTabs;

public class ChiseledTenebrae extends BlockBase {
	private String name = "chiseledTenebrae";
	
	public ChiseledTenebrae() {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ModTabs.zylRoth);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		
		/* Boss */
		
		if (world.getBlockState(pos.down()).getBlock() == ModBlocks.empoweredTenebraeCore && world.getBlockState(pos.down(2)).getBlock() == ModBlocks.infusedTenebrae) {
			boolean flag = world.getBlockState(pos.down().west()).getBlock() == ModBlocks.infusedTenebrae && world.getBlockState(pos.down().east()).getBlock() == ModBlocks.infusedTenebrae;
			boolean flag1 = world.getBlockState(pos.down().north()).getBlock() == ModBlocks.infusedTenebrae && world.getBlockState(pos.down().south()).getBlock() == ModBlocks.infusedTenebrae;
			
			if (flag || flag1) {
				world.setBlockToAir(pos);
				world.setBlockToAir(pos.down());
				world.setBlockToAir(pos.down(2));
				
				if (flag) {
					world.setBlockToAir(pos.down().west());
					world.setBlockToAir(pos.down().east());
				} else {
					world.setBlockToAir(pos.down().north());
					world.setBlockToAir(pos.down().south());
				}
				
				EntityTenebraeGuardian golem = new EntityTenebraeGuardian(world);
				golem.setLocationAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() - 1.95D, (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(golem);
				
				for (int i1 = 0; i1 < 120; ++ i1) {
					world.spawnParticle(EnumParticleTypes.SNOWBALL, (double) pos.getX() + world.rand.nextDouble(), (double) (pos.getY() - 2) + world.rand.nextDouble() * 3.9D, (double) pos.getZ() + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		
		/* Non-Boss "Golem-Guardian" */
		
		if (world.getBlockState(pos.down()).getBlock() == ModBlocks.tenebraeCore && world.getBlockState(pos.down(2)).getBlock() == ModBlocks.tenebraeBlock) {
			boolean flag = world.getBlockState(pos.west().down()).getBlock() == ModBlocks.tenebraeBlock && world.getBlockState(pos.east().down()).getBlock() == ModBlocks.tenebraeBlock;
			boolean flag1 = world.getBlockState(pos.down().north()).getBlock() == ModBlocks.tenebraeBlock && world.getBlockState(pos.down().south()).getBlock() == ModBlocks.tenebraeBlock;
			
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
				
				EntityTenebraeProtector golem = new EntityTenebraeProtector(world);
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