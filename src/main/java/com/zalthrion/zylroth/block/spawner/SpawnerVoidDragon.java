package com.zalthrion.zylroth.block.spawner;

import java.util.Random;

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
		this.setNames(name);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySpawnerVoidDragon();
	}
	
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return null;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }
    
}
