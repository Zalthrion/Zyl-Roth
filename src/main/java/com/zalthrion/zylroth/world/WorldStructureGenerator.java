package com.zalthrion.zylroth.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldStructureGenerator implements IWorldGenerator {
	
	public static final int MAX_HEIGHT = 256;
	
	@Override
	public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case 0:
				GenerateOverworld(random, x * 16, z * 16, world);
				break;
			case 1:
				GenerateEnd(random, x * 16, z * 16, world);
				break;
			case -1:
				GenerateNether(random, x * 16, z * 16, world);
				break;
			case 47:
				GenerateKyrul(random, x * 16, z * 16, world);
		}
	}
	
	private void GenerateOverworld(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateNether(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateEnd(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateKyrul(Random random, int x, int z, World world) {
		
/*		BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
		if (biomegenbase == ModBiomes.VoidMountains) {
			for (int k = 0; k < 2; k ++) {
				int RandPosX = x + random.nextInt(16);
				int RandPosY = random.nextInt(90);
				int RandPosZ = z + random.nextInt(16);
				new DragonNest().generate(world, random, RandPosX, RandPosY, RandPosZ);
			}
		}*/
	}
	
}