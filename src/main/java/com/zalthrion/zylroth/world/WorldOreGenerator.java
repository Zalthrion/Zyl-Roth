package com.zalthrion.zylroth.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldOreGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
			case 0:
				GenerateOverworld(random, chunkX * 16, chunkZ * 16, world);
				break;
			case 1:
				GenerateEnd(random, chunkX * 16, chunkZ * 16, world);
				break;
			case -1:
				GenerateNether(random, chunkX * 16, chunkZ * 16, world);
				break;
			case 47:
				GenerateKyrul(random, chunkX * 16, chunkZ * 16, world);
		}
	}
	
	private void GenerateOverworld(Random random, int x, int z, World world) {
		
		// this.addOreSpawn(ModBlocks.Tenebrae_Ore, world, random, x, z, 2, 6, 4, 0, 32);
		
	}
	
	private void GenerateNether(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateEnd(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateKyrul(Random random, int x, int z, World world) {
		
		// this.addOreSpawn(ModBlocks.Tenebrae_Ore, world, random, x, z, 2, 6, 5, 0, 32);
		
	}
	
/*	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY) {
		WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.stone);
		for (int i = 0; i < chancesToSpawn; i ++) {
			int posX = blockXPos + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(16);
			minable.generate(world, random, posX, posY, posZ);
		}
	}*/
}
