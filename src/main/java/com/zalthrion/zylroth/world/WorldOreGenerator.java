package com.zalthrion.zylroth.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.zalthrion.zylroth.lib.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldOreGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
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
		this.addOreSpawn(ModBlocks.tenebraeOre, world, random, x, z, 2, 6, 7, 0, 32, Blocks.stone);
	}
	
	private void GenerateNether(Random random, int x, int z, World world) {
		this.addOreSpawn(ModBlocks.inferniumOre, world, random, x, z, 2, 6, 20, 0, 128, Blocks.netherrack);
	}
	
	private void GenerateEnd(Random random, int x, int z, World world) {
		this.addOreSpawn(ModBlocks.endiriteOre, world, random, x, z, 2, 6, 20, 0, 75, Blocks.end_stone);
	}
	
	private void GenerateKyrul(Random random, int x, int z, World world) {
		this.addOreSpawn(ModBlocks.voidiumOre, world, random, x, z, 2, 6, 7, 0, 32, Blocks.stone);
	}
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block spawnBlock) {		
		WorldGenMinable minable = new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), spawnBlock);
		
		for (int i = 0; i < chancesToSpawn; i ++) {
			int posX = blockXPos + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(16);
			minable.generate(world, random, posX, posY, posZ);
		}
	}
}
