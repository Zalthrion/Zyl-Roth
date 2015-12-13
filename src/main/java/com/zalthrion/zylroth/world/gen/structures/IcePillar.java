package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class IcePillar extends WorldGenerator {
	
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {Blocks.ice};
	}
	
	public boolean locationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block check = world.getBlock(i, j, k);
		
		while (check != Blocks.air) {
			if (distanceToAir > 3) { return false; }
			
			distanceToAir ++;
			check = world.getBlock(i, j + distanceToAir, k);
		}
		
		j += distanceToAir - 1;
		
		Block block = world.getBlock(i, j, k);
		Block blockAbove = world.getBlock(i, j + 1, k);
		Block blockBelow = world.getBlock(i, j - 1, k);
		
		for (Block x : getValidSpawnBlocks()) {
			if (blockAbove != Blocks.air) { return false; }
			if (block == x) {
				return true;
			}
			else if (block == Blocks.snow && blockBelow == x) { return true; }
		}
		
		return false;
	}
	
	public IcePillar() {}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		// check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, x, y, z) || !locationIsValidSpawn(world, x + 1, y, z) || !locationIsValidSpawn(world, x + 1, y, z + 1) || !locationIsValidSpawn(world, x, y, z + 1) || !locationIsValidSpawn(world, x - 1, y, z) || !locationIsValidSpawn(world, x - 1, y, z - 1) || !locationIsValidSpawn(world, x, y, z - 1) || !locationIsValidSpawn(world, x + 1, y, z - 1) || !locationIsValidSpawn(world, x - 1, y, z + 1) || !locationIsValidSpawn(world, x + 2, y + 1, z + 0) || !locationIsValidSpawn(world, x - 2, y + 1, z + 0) || !locationIsValidSpawn(world, x + 0, y + 1, z + 2) || !locationIsValidSpawn(world, x + 1, y + 1, z - 1) || !locationIsValidSpawn(world, x - 1, y + 1, z + 1) || !locationIsValidSpawn(world, x + 0, y + 1, z - 2) || !locationIsValidSpawn(world, x + 1, y + 1, z - 2) || !locationIsValidSpawn(world, x - 1, y + 1, z - 2)) { return false; }
		
		/* z = z - 10; x = x - 10; */
		
		world.setBlock(x + 0, y + 1, z + 0, Blocks.ice, 0, 0);
		
		world.setBlock(x + 1, y + 1, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x + -1, y + 1, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 1, z - 1, Blocks.ice, 0, 0);
		
		world.setBlock(x - 1, y + 1, z - 1, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.ice, 0, 0);
		
		world.setBlock(x + 2, y + 1, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 2, y + 1, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.ice, 0, 0);
		
		world.setBlock(x + 1, y + 1, z - 1, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 1, z + 1, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 1, z - 2, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 1, z - 2, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 1, z - 2, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 2, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 2, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 2, y + 2, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 2, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 2, z - 1, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 2, z - 1, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 2, z - 1, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 2, z - 2, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 3, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 3, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 2, y + 3, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 3, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 3, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 3, z + 2, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 3, z - 1, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 3, z - 1, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 4, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 4, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 4, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 4, z + 1, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 4, z - 1, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 5, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 1, y + 5, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 5, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x + 0, y + 5, z + 1, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 6, z + 0, Blocks.ice, 0, 0);
		world.setBlock(x - 1, y + 6, z + 0, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 7, z + 0, Blocks.ice, 0, 0);
		
		world.setBlock(x + 0, y + 8, z + 0, Blocks.ice, 0, 0);
		
		return true;
	}
}