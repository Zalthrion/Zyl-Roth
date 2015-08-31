package com.zalthrion.zylroth.world.gen.structures;

import java.util.Random;

import com.zalthrion.zylroth.lib.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class IcePillar extends WorldGenerator implements IWorldGenerator {
	
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
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {}
	
	public void setBlock(World world, int x, int y, int z, Block block, int metadata) {
		Block b1 = world.getBlock(x, y, z);
		
		if (b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, metadata, 2);
		}
	}
	
	public boolean generate(World world, Random rand, int x, int y, int z) {
		// check that each corner is one of the valid spawn blocks
		if (!locationIsValidSpawn(world, x, y, z) || !locationIsValidSpawn(world, x + 6, y, z) || !locationIsValidSpawn(world, x + 6, y, z + 6) || !locationIsValidSpawn(world, x, y, z + 6)) { return false; }
		
		z = z - 10;
		x = x - 10;
		
		this.setBlock(world, x + 0, y + 0, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 0, z + 1, Blocks.cobblestone, 0);
		this.setBlock(world, x + 0, y + 0, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 0, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 0, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 0, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 0, y + 0, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 3, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 3, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 0, y + 2, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 0, z + 0, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 0, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 0, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 0, z + 6, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 1, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 1, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 1, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 1, y + 1, z + 4, Blocks.cobblestone, 0);
		this.setBlock(world, x + 1, y + 1, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 3, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 1, y + 2, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 0, z + 0, Blocks.cobblestone, 0);
		this.setBlock(world, x + 2, y + 0, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 0, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 0, z + 6, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 1, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 1, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 1, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 1, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 1, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 2, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 2, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 2, y + 2, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 2, y + 2, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 3, y + 0, z + 0, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 0, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 0, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 0, z + 6, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 3, y + 1, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 1, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 1, z + 3, Blocks.cobblestone, 0);
		this.setBlock(world, x + 3, y + 1, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 1, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 3, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 3, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 3, y + 2, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 2, z + 3, ModBlocks.spawner_VoidDragon, 0);
		this.setBlock(world, x + 3, y + 3, z + 3, Blocks.gravel, 0); // Top
																		// Block
		this.setBlock(world, x + 3, y + 2, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 3, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 3, y + 2, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 0, z + 0, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 0, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 0, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 0, z + 6, Blocks.cobblestone, 0);
		this.setBlock(world, x + 4, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 1, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 1, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 1, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 1, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 1, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 2, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 2, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 4, y + 2, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 4, y + 2, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 0, z + 0, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 0, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 0, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 0, z + 6, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 1, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 1, z + 2, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 1, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 1, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 5, y + 1, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 3, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 5, y + 2, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 0, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 0, z + 1, Blocks.stone, 0);
		this.setBlock(world, x + 6, y + 0, z + 2, Blocks.cobblestone, 0);
		this.setBlock(world, x + 6, y + 0, z + 3, Blocks.stone, 0);
		this.setBlock(world, x + 6, y + 0, z + 4, Blocks.stone, 0);
		this.setBlock(world, x + 6, y + 0, z + 5, Blocks.stone, 0);
		this.setBlock(world, x + 6, y + 0, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 3, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 1, z + 6, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 0, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 1, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 2, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 3, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 4, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 5, Blocks.air, 0);
		this.setBlock(world, x + 6, y + 2, z + 6, Blocks.air, 0);
		
		return true;
	}
}