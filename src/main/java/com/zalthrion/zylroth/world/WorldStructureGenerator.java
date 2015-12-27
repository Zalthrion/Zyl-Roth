package com.zalthrion.zylroth.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldStructureGenerator implements IWorldGenerator {
	
	public static final int MAX_HEIGHT = 256;
	
	@Override public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
			case 0:
				generateOverworld(random, x * 16, z * 16, world);
				break;
			case 1:
				generateEnd(random, x * 16, z * 16, world);
				break;
			case -1:
				generateNether(random, x * 16, z * 16, world);
				break;
			case 47:
				generateKyrul(random, x * 16, z * 16, world);
				break;
			case 48:
				generateIridis(random, x * 16, z * 16, world);
				break;
			case 49:
				generateGlaciem(random, x * 16, z * 16, world);
				break;
		}
	}
	
	private void generateOverworld(Random random, int x, int z, World world) {}
	private void generateNether(Random random, int x, int z, World world) {}
	private void generateEnd(Random random, int x, int z, World world) {}
	
	private void generateKyrul(Random random, int x, int z, World world) {}
	private void generateIridis(Random random, int x, int z, World world) {}
	private void generateGlaciem(Random random, int x, int z, World world) {}
}