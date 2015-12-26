package com.zalthrion.zylroth.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.world.gen.structures.DragonNest;
import com.zalthrion.zylroth.world.gen.structures.IcePillar;
import com.zalthrion.zylroth.world.gen.structures.PackedIcePillar;

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
	
	private void generateKyrul(Random random, int x, int z, World world) {
		BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenerator(new BlockPos(x + 16, 0, z + 16));
		if (biomegenbase == ModBiomes.voidMountains) {
			for (int k = 0; k < 2; k ++) {
				int randPosX = x + random.nextInt(16);
				int randPosZ = z + random.nextInt(16);
				int posY = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
				BlockPos randPos = new BlockPos(randPosX, posY, randPosZ);
				new DragonNest().generate(world, random, randPos);
			}
		}
	}
	
	private void generateIridis(Random random, int x, int z, World world) {
		// Github 1.7.10 branch has this commented out.
		// TODO Add this in when 1.7.10 Branch has it.
	}
	
	private void generateGlaciem(Random random, int x, int z, World world) {
		BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenerator(new BlockPos(x + 16, 0, z + 16));
		
		if (biomegenbase == ModBiomes.frozenWastes) {
			for (int i = 0; i < 5; i ++) {
				int randPosX = x + random.nextInt(16);
				int randPosZ = z + random.nextInt(16);
				int posY = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
				BlockPos randPos = new BlockPos(randPosX, posY, randPosZ);
				
				new IcePillar().generate(world, random, randPos);
			}
			
			for (int i = 0; i < 5; i ++) {
				int randPosX = x + random.nextInt(16);
				int randPosZ = +random.nextInt(16);
				int posY = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z)).getY();
				BlockPos randPos = new BlockPos(randPosX, posY, randPosZ);
				
				new PackedIcePillar().generate(world, random, randPos);
			}
		}
	}
}