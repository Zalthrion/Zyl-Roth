package com.zalthrion.zylroth.block.spawner;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zalthrion.zylroth.base.BlockContainerBase;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

public class SpawnerVoidDragon extends BlockContainerBase {
	public SpawnerVoidDragon() {
		this.setHardness(3.0F);
		this.setNames("spawnerVoidDragon");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySpawnerVoidDragon();
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override public int quantityDropped(Random random) {
		return 0;
	}
}