package com.zalthrion.zylroth.world.generator;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;

// TODO Check mappings, method order, etc.
public class WorldOreGenerator implements IWorldGenerator {
	@Override public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int dimId = world.provider.getDimensionType().getId();
		if (dimId == 0) generateOverworld(random, chunkX * 16, chunkZ * 16, world);
		if (dimId == 1) generateEnd(random, chunkX * 16, chunkZ * 16, world);
		if (dimId == -1) generateNether(random, chunkX * 16, chunkZ * 16, world);
		if (dimId == ConfigurationHandler.getKyrulId()) generateKyrul(random, chunkX * 16, chunkZ * 16, world);
		if (dimId == ConfigurationHandler.getIridisId()) generateIridis(random, chunkX * 16, chunkZ * 16, world);
	}
	
	private void generateOverworld(Random random, int x, int z, World world) {
		this.addOreSpawn(BlockInit.tenebraeOre, world, random, x, z, 2, 6, 7, 0, 32, Blocks.STONE);
	}
	
	private void generateNether(Random random, int x, int z, World world) {
		this.addOreSpawn(BlockInit.inferniumOre, world, random, x, z, 2, 6, 20, 0, 128, Blocks.NETHERRACK);
	}
	
	private void generateEnd(Random random, int x, int z, World world) {
		this.addOreSpawn(BlockInit.endiriteOre, world, random, x, z, 2, 6, 20, 0, 75, Blocks.END_STONE);
	}
	
	private void generateKyrul(Random random, int x, int z, World world) {
		this.addOreSpawn(BlockInit.voidiumOre, world, random, x, z, 2, 6, 7, 0, 32, BlockInit.voidStone);
	}
	
	private void generateIridis(Random random, int x, int z, World world) {
		this.addOreSpawn(BlockInit.tenebraeOre, world, random, x, z, 2, 6, 7, 0, 32, Blocks.STONE);
	}
	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block spawnBlock) {
		WorldGenMinable minable = new WorldGenMinable(block.getDefaultState(), (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), BlockMatcher.forBlock(spawnBlock));
		for (int i = 0; i < chancesToSpawn; i ++) {
			int posX = blockXPos + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(16);
			minable.generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
}
