package com.zalthrion.zylroth.world;

import java.util.Random;

import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.world.gen.structures.DragonNest;
import com.zalthrion.zylroth.world.gen.structures.IcePillar;
import com.zalthrion.zylroth.world.gen.structures.PackedIcePillar;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

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
				break;
			case 48:
				GenerateIridis(random, x * 16, z * 16, world);
				break;
			case 49:
				GenerateGlaciem(random, x * 16, z * 16, world);
				break;
		}
	}
	
	private void GenerateOverworld(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateNether(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateEnd(Random random, int x, int z, World world) {
		
	}
	
	private void GenerateKyrul(Random random, int x, int z, World world) {
		
		BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
		
		if (biomegenbase == ModBiomes.VoidMountains) {
			if (random.nextInt(100) < 50) {
				int Xcoord = x + random.nextInt(16);
				int Ycoord = random.nextInt(90);
				int Zcoord = z + random.nextInt(16);
				new DragonNest().generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}
	}
	
	private void GenerateIridis(Random random, int x, int z, World world) {
		
/*		BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
		
		if (biomegenbase == ModBiomes.DryDesert) {
			if (random.nextInt(100) < 50) {
				int Xcoord = x + random.nextInt(16);
				int Ycoord = random.nextInt(90);
				int Zcoord = z + random.nextInt(16);
								
				if (random.nextInt(100) < 75) {
				new RegularWell().generate(world, random, Xcoord, Ycoord, Zcoord);
				} else {
					new TreasureWell().generate(world, random, Xcoord, Ycoord, Zcoord);
				}
			} else {}
		}*/
	}
	
	private void GenerateGlaciem(Random random, int x, int z, World world) {
		
		BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
		
		if (biomegenbase == ModBiomes.FrozenWastes) {
			for (int i = 0; i < 2; i ++) {
				int Xcoord = x + random.nextInt(16);
				int Ycoord = random.nextInt(90);
				int Zcoord = z + random.nextInt(16);
				
				new IcePillar().generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}
		
		if (biomegenbase == ModBiomes.FrozenWastes) {
			for (int i = 0; i < 2; i ++) {
				int Xcoord = x + random.nextInt(16);
				int Ycoord = random.nextInt(90);
				int Zcoord = z + random.nextInt(16);
				
				new PackedIcePillar().generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}
		
/*		if (biomegenbase == ModBiomes.SnowPlateau) {
			if (random.nextInt(100) < 1) {
				int Xcoord = x + random.nextInt(16);
				int Ycoord = random.nextInt(90);
				int Zcoord = z + random.nextInt(16);
				
				new BenzennHut().generate(world, random, Xcoord, Ycoord, Zcoord);
			}
		}*/
	}
}