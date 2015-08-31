package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.zalthrion.zylroth.lib.ModBlocks;

public class DragonNest extends WorldGenerator {
	
	protected Block[] getValidSpawnBlocks() {
		return new Block[] {Blocks.grass};
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
	
	public DragonNest() {}
	
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		// check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, x, y, z) || !locationIsValidSpawn(world, x + 6, y, z) || !locationIsValidSpawn(world, x + 6, y, z + 6) || !locationIsValidSpawn(world, x, y, z + 6) && world.isAirBlock(x + 3, y + 4, z + 3)) { return false; }
		
		/* z = z - 10; x = x - 10; */
		
		world.setBlock(x + 0, y + 0, z + 1, Blocks.cobblestone, 0, 0);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 0, y + 0, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 0, z + 6, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.cobblestone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.cobblestone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 0, z + 6, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 1, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 1, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 0, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.stone, 0, 0); // Central
																	// Block
		world.setBlock(x + 3, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 0, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 0, z + 6, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.cobblestone, 0, 0);
		world.setBlock(x + 3, y + 1, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 1, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 3, y + 2, z + 3, ModBlocks.spawner_VoidDragon, 0, 0);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.gravel, 0, 0); // Top Block
		world.setBlock(x + 3, y + 2, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 0, z + 6, Blocks.cobblestone, 0, 0);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 1, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 1, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 0, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 5, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 0, z + 6, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 1, z + 2, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 5, y + 1, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 6, y + 0, z + 1, Blocks.stone, 0, 0);
		world.setBlock(x + 6, y + 0, z + 2, Blocks.cobblestone, 0, 0);
		world.setBlock(x + 6, y + 0, z + 3, Blocks.stone, 0, 0);
		world.setBlock(x + 6, y + 0, z + 4, Blocks.stone, 0, 0);
		world.setBlock(x + 6, y + 0, z + 5, Blocks.stone, 0, 0);
		
		return true;
	}
}