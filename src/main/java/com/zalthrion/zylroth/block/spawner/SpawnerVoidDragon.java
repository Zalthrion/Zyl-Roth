package com.zalthrion.zylroth.block.spawner;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zalthrion.zylroth.block.machine.BlockBaseContainer;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

public class SpawnerVoidDragon extends BlockBaseContainer {
	
	private String name = "spawnerVoidDragon";
	
	public SpawnerVoidDragon() {
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySpawnerVoidDragon();
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
}