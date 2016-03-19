package com.zalthrion.zylroth.world.dimension;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;
import net.minecraftforge.event.terraingen.TerrainGen;

import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.world.gen.map.MapGenIceCavesGlaciem;
import com.zalthrion.zylroth.world.gen.map.MapGenIceRavineGlaciem;
import com.zalthrion.zylroth.world.gen.structures.IcePillar;

public class ChunkProviderGlaciem implements IChunkGenerator {
	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private WorldType terrainType;
	private final double[] heightMap;
	private final float[] parabolicField;
	private double[] packedIceNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenIceCavesGlaciem();
	private MapGenBase ravineGenerator = new MapGenIceRavineGlaciem();
	private BiomeGenBase[] biomesForGeneration;
	double[] noiseGen1Octaves;
	double[] noiseGen2Octaves;
	double[] noiseGen3Octaves;
	double[] noiseGen6Octaves;
	
	private int icePillarChance = 10;
	private int packedIcePillarChance = 10;
	
	public ChunkProviderGlaciem(World worldIn, long seed) {
		{
			caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, EventType.CAVE);
			ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, EventType.RAVINE);
		}
		
		this.worldObj = worldIn;
		this.terrainType = worldIn.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.heightMap = new double[825];
		this.parabolicField = new float[25];
		
		for (int j = -2; j <= 2; ++ j) {
			for (int k = -2; k <= 2; ++ k) {
				float f = 10.0F / MathHelper.sqrt_float((float) (j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
		
		ContextZylroth ctx = new ContextZylroth(noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise);
		ctx = TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, ctx);
		this.noiseGen1 = ctx.getNoiseGenOctave1();
		this.noiseGen2 = ctx.getNoiseGenOctave2();
		this.noiseGen3 = ctx.getNoiseGenOctave3();
		this.noiseGen4 = ctx.getNoiseGenPerlin1();
		this.noiseGen5 = ctx.getNoiseGenOctave4();
		this.noiseGen6 = ctx.getNoiseGenOctave5();
		this.mobSpawnerNoise = ctx.getNoiseGenOctave6();
	}
	
	public void setBlocksInChunk(int x, int z, ChunkPrimer primer) {
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
		this.generateHeightmap(x * 4, 0, z * 4);
		
		for (int i = 0; i < 4; i ++) {
			int j = i * 5;
			int k = (i + 1) * 5;
			
			for (int l = 0; l < 4; l ++) {
				int i1 = (j + l) * 33;
				int j1 = (j + l + 1) * 33;
				int k1 = (k + l) * 33;
				int l1 = (k + l + 1) * 33;
				
				for (int i2 = 0; i2 < 32; i2 ++) {
					double d0 = 0.125D;
					double d1 = this.heightMap[i1 + i2];
					double d2 = this.heightMap[j1 + i2];
					double d3 = this.heightMap[k1 + i2];
					double d4 = this.heightMap[l1 + i2];
					double d5 = (this.heightMap[i1 + i2 + 1] - d1) * d0;
					double d6 = (this.heightMap[j1 + i2 + 1] - d2) * d0;
					double d7 = (this.heightMap[k1 + i2 + 1] - d3) * d0;
					double d8 = (this.heightMap[l1 + i2 + 1] - d4) * d0;
					
					for (int j2 = 0; j2 < 8; j2 ++) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for (int k2 = 0; k2 < 4; k2 ++) {
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double lvt_45_1_ = d10 - d16;
							
							for (int l2 = 0; l2 < 4; l2 ++) {
								if ((lvt_45_1_ += d16) > 0.0D) {
									primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.packed_ice.getDefaultState());
								} else if (i2 * 8 + j2 < 63) {
									primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.water.getDefaultState());
								} else {
									primer.setBlockState(i * 4 + k2, i2 * 8 + j2, l * 4 + l2, Blocks.air.getDefaultState());
								}
							}
							
							d10 += d12;
							d11 += d13;
						}
						
						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, BiomeGenBase[] biomesIn) {
		if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.worldObj)) return;
		double d0 = 0.03125D;
		this.packedIceNoise = this.noiseGen4.func_151599_a(this.packedIceNoise, (double) (x * 16), (double) (z * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
		
		for (int i = 0; i < 16; i ++) {
			for (int j = 0; j < 16; j ++) {
				BiomeGenBase biomegenbase = biomesIn[j + i * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, primer, x * 16 + i, z * 16 + j, this.packedIceNoise[j + i * 16]);
			}
		}
	}
	
	@Override public Chunk provideChunk(int x, int z) {
		this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);
		this.biomesForGeneration = this.worldObj.getBiomeProvider().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);
		this.caveGenerator.generate(this.worldObj, x, z, chunkprimer);
		this.ravineGenerator.generate(this.worldObj, x, z, chunkprimer);
		
		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		byte[] abyte = chunk.getBiomeArray();
		
		for (int i = 0; i < abyte.length; i ++) {
			abyte[i] = (byte) BiomeGenBase.getIdForBiome(this.biomesForGeneration[i]);
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	// Taken from ChunkProviderOverworld. While porting any this.settings refer to ChunkProviderSettings.Factory
	private void generateHeightmap(int x, int y, int z) {
		this.noiseGen6Octaves = this.noiseGen6.generateNoiseOctaves(this.noiseGen6Octaves, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		float f = 684.412F;
		float f1 = 684.412F;
		this.noiseGen3Octaves = this.noiseGen3.generateNoiseOctaves(this.noiseGen3Octaves, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.noiseGen1Octaves = this.noiseGen1.generateNoiseOctaves(this.noiseGen1Octaves, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.noiseGen2Octaves = this.noiseGen2.generateNoiseOctaves(this.noiseGen2Octaves, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		z = 0;
		x = 0;
		int i = 0;
		int j = 0;
		
		for (int k = 0; k < 5; k ++) {
			for (int l = 0; l < 5; l ++) {
				float f2 = 0.0F;
				float f3 = 0.0F;
				float f4 = 0.0F;
				int i1 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[k + 2 + (l + 2) * 10];
				
				for (int j1 = -i1; j1 <= i1; j1 ++) {
					for (int k1 = -i1; k1 <= i1; k1 ++) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[k + j1 + 2 + (l + k1 + 2) * 10];
						float f5 = biomegenbase1.getBaseHeight();
						float f6 = biomegenbase1.getHeightVariation();
						
						if (this.terrainType == WorldType.AMPLIFIED && f5 > 0.0F) {
							f5 = 1.0F + f5 * 2.0F;
							f6 = 1.0F + f6 * 4.0F;
						}
						
						float f7 = this.parabolicField[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);
						
						if (biomegenbase1.getBaseHeight() > biomegenbase.getBaseHeight()) {
							f7 /= 2.0F;
						}
						
						f2 += f6 * f7;
						f3 += f5 * f7;
						f4 += f7;
					}
				}
				
				f2 = f2 / f4;
				f3 = f3 / f4;
				f2 = f2 * 0.9F + 0.1F;
				f3 = (f3 * 4.0F - 1.0F) / 8.0F;
				double d7 = this.noiseGen6Octaves[i1] / 8000.0D;
				
				if (d7 < 0.0D) {
					d7 = -d7 * 0.3D;
				}
				
				d7 = d7 * 3.0D - 2.0D;
				
				if (d7 < 0.0D) {
					d7 /= 2.0D;
					
					if (d7 < -1.0D) {
						d7 = -1.0D;
					}
					
					d7 /= 1.4D;
					d7 /= 2.0D;
				} else {
					if (d7 > 1.0D) {
						d7 = 1.0D;
					}
					
					d7 /= 8.0D;
				}
				
				j ++;
				double d8 = (double) f3;
				double d9 = (double) f2;
				d8 = d8 + d7 * 0.2D;
				d8 = d8 * 8.5D / 8.0D;
				double d0 = 8.5D + d8 * 4.0D;
				
				for (int l1 = 0; l1 < 33; l1 ++) {
					double d1 = ((double) l1 - d0) * 12.0D * 128.0D / 256.0D / d9;
					
					if (d1 < 0.0D) {
						d1 *= 4.0D;
					}
					
					double d2 = this.noiseGen2Octaves[l] / 512.0D;
					double d3 = this.noiseGen3Octaves[l] / 512.0D;
					double d4 = (this.noiseGen1Octaves[l] / 10.0D + 1.0D) / 2.0D;
					double d5 = MathHelper.denormalizeClamp(d2, d3, d4) - d1;
					
					if (l1 > 29) {
						double d6 = (double) ((float) (l1 - 29) / 3.0F);
						d5 = d5 * (1.0D - d6) + -10.0D * d6;
					}
					
					this.heightMap[l] = d5;
					i ++;
				}
			}
		}
	}
	
	// TODO Remap from ChunkProviderOverworld
	@Override public void populate(int x, int z) {
		BlockFalling.fallInstantly = true;
		int k = x * 16;
		int l = z * 16;
		BlockPos blockpos = new BlockPos(k, 0, l);
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(blockpos.add(16, 0, 16));
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long) x * i1 + (long) z * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(this, worldObj, rand, x, z, flag));
		
		int k1;
		int l1;
		int i2;
		
		if (biomegenbase != Biomes.desert && biomegenbase != Biomes.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(this, worldObj, rand, x, z, flag, LAKE)) {
			k1 = this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, blockpos.add(k1, l1, i2));
		}
		
		biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 64, l));
		if (TerrainGen.populate(this, worldObj, rand, x, z, flag, Populate.EventType.ANIMALS)) {
			WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		}
		
		biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 0, l));
		if (TerrainGen.populate(this, worldObj, rand, x, z, flag, ANIMALS)) {
			WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		}
		blockpos = blockpos.add(8, 0, 8);
		
		boolean doGen = TerrainGen.populate(this, worldObj, rand, x, z, flag, ICE);
		for (k1 = 0; doGen && k1 < 16; ++ k1) {
			for (l1 = 0; l1 < 16; ++ l1) {
				BlockPos blockpos1 = this.worldObj.getPrecipitationHeight(blockpos.add(k1, 0, l1));
				BlockPos blockpos2 = blockpos1.down();
				
				if (this.worldObj.canBlockFreezeWater(blockpos2)) {
					this.worldObj.setBlockState(blockpos2, Blocks.ice.getDefaultState(), 2);
				}
				
				if (this.worldObj.canSnowAt(blockpos1, true)) {
					this.worldObj.setBlockState(blockpos1, Blocks.snow_layer.getDefaultState(), 2);
				}
			}
		}
		
		if (biomegenbase == ModBiomes.frozenWastes) {
			if (this.rand.nextInt(icePillarChance) == 0) {
				k1 = this.rand.nextInt(16) + 8;
				i2 = this.rand.nextInt(16) + 8;
				int yPos = -1;
				for (int i = 256; i > 0; i --) {
					Block blockInPlace = this.worldObj.getBlockState(new BlockPos(blockpos.getX() + k1, i, blockpos.getZ() + i2)).getBlock();
					if (blockInPlace != Blocks.air) {
						yPos = i + 1;
						break;
					}
				}
				BlockPos mainPos = new BlockPos(blockpos.getX() + k1, yPos, blockpos.getZ() + i2);
				if (yPos != -1) (new IcePillar(this.rand.nextInt(3), mainPos)).generate(this.worldObj, this.rand, mainPos);
			} else if (this.rand.nextInt(packedIcePillarChance) == 0) {
				k1 = this.rand.nextInt(16) + 8;
				i2 = this.rand.nextInt(16) + 8;
				int yPos = -1;
				for (int i = 256; i > 0; i --) {
					Block blockInPlace = this.worldObj.getBlockState(new BlockPos(blockpos.getX() + k1, i, blockpos.getZ() + i2)).getBlock();
					if (blockInPlace != Blocks.air) {
						yPos = i + 1;
						break;
					}
				}
				BlockPos mainPos = new BlockPos(blockpos.getX() + k1, yPos, blockpos.getZ() + i2);
				if (yPos != -1) (new IcePillar(this.rand.nextInt(3), mainPos).setPacked()).generate(this.worldObj, this.rand, mainPos);
			}
		}
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(this, worldObj, rand, x, z, flag));
		
		BlockFalling.fallInstantly = false;
	}
	
	@Override public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}
	
	@Override public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(pos);
		return biomegenbase == null ? null : biomegenbase.getSpawnableList(creatureType);
	}

	@Override public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}

	@Override public void recreateStructures(Chunk chunkIn, int x, int z) {}
}