package com.zalthrion.zylroth.world.dimension;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.world.gen.structures.DragonNest;

// TODO Remap from ChunkProviderOverworld
public class ChunkProviderKyrul implements IChunkGenerator {
	/** RNG. */
	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	
	private World worldObj;
	private final boolean mapFeaturesEnabled;
	private WorldType worldType;
	private final double[] doubleArray1;
	private final float[] parabolicField;
	private ChunkProviderSettings settings;
	private Block fluidBlock;
	private double[] stoneNoise;
	private MapGenBase caveGenerator;
	private MapGenMineshaft mineshaftGenerator;
	private MapGenBase ravineGenerator;
	private BiomeGenBase[] biomesForGeneration;
	double[] ngo3Octaves;
	double[] ngo1Octaves;
	double[] ngo2Octaves;
	double[] ngo5Octaves;
	private int dragonSpawnerChance = 10;
	
	public ChunkProviderKyrul(World world, long seed, boolean mapFeatures, String param5) {
		this.fluidBlock = Blocks.water;
		this.stoneNoise = new double[256];
		this.caveGenerator = new MapGenCaves();
		this.mineshaftGenerator = new MapGenMineshaft();
		this.ravineGenerator = new MapGenRavine();
		{
			caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, EventType.CAVE);
			mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, EventType.MINESHAFT);
			ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, EventType.RAVINE);
		}
		this.worldObj = world;
		this.mapFeaturesEnabled = mapFeatures;
		this.worldType = world.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 10);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.doubleArray1 = new double[825];
		this.parabolicField = new float[25];
		
		for (int j = -2; j <= 2; j ++) {
			for (int k = -2; k <= 2; k ++) {
				float f = 10.0F / MathHelper.sqrt_float((float) (j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
		
		if (param5 != null) {
			this.settings = ChunkProviderSettings.Factory.jsonToFactory(param5).func_177864_b();
			this.fluidBlock = this.settings.useLavaOceans ? Blocks.lava : Blocks.water;
		}
		
		ContextZylroth ctx = new ContextZylroth(noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise);
		ctx = TerrainGen.getModdedNoiseGenerators(world, this.rand, ctx);
		this.noiseGen1 = ctx.getNoiseGenOctave1();
		this.noiseGen2 = ctx.getNoiseGenOctave2();
		this.noiseGen3 = ctx.getNoiseGenOctave3();
		this.noiseGen4 = ctx.getNoiseGenPerlin1();
		this.noiseGen5 = ctx.getNoiseGenOctave4();
		this.noiseGen6 = ctx.getNoiseGenOctave5();
		this.mobSpawnerNoise = ctx.getNoiseGenOctave6();
	}
	
	public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		this.setupNoiseFields(chunkX * 4, 0, chunkZ * 4);
		
		for (int k = 0; k < 4; k ++) {
			int l = k * 5;
			int i1 = (k + 1) * 5;
			
			for (int j1 = 0; j1 < 4; j1 ++) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;
				
				for (int k2 = 0; k2 < 32; k2 ++) {
					double d0 = 0.125D;
					double d1 = this.doubleArray1[k1 + k2];
					double d2 = this.doubleArray1[l1 + k2];
					double d3 = this.doubleArray1[i2 + k2];
					double d4 = this.doubleArray1[j2 + k2];
					double d5 = (this.doubleArray1[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.doubleArray1[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.doubleArray1[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.doubleArray1[j2 + k2 + 1] - d4) * d0;
					
					for (int l2 = 0; l2 < 8; l2 ++) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for (int i3 = 0; i3 < 4; i3 ++) {
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;
							
							for (int j3 = 0; j3 < 4; j3 ++) {
								if ((d16 += d15) > 0) {
									primer.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, Blocks.stone.getDefaultState());
								} else if (k2 * 8 + l2 < this.settings.seaLevel) {
									primer.setBlockState(k * 4 + i3, k2 * 8 + l2, j1 * 4 + j3, this.fluidBlock.getDefaultState());
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
	
	public void replaceBlocksForBiome(int x, int z, ChunkPrimer primer, BiomeGenBase[] biomes) {
		if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.worldObj)) return;
		
		double d0 = 0.03125D;
		this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, (double) (x * 16), (double) (z * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
		
		for (int k = 0; k < 16; k ++) {
			for (int l = 0; l < 16; l ++) {
				BiomeGenBase bgb = biomes[l + k * 16];
				bgb.genTerrainBlocks(this.worldObj, this.rand, primer, x * 16 + k, z * 16 + l, this.stoneNoise[l + k * 16]);
			}
		}
	}
	
	@Override public Chunk provideChunk(int chunkX, int chunkZ) {
		this.rand.setSeed((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);
		ChunkPrimer primer = new ChunkPrimer();
		this.setBlocksInChunk(chunkX, chunkZ, primer);
		this.biomesForGeneration = this.worldObj.getBiomeProvider().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBlocksForBiome(chunkX, chunkZ, primer, this.biomesForGeneration);
		if (this.settings.useCaves) this.caveGenerator.generate(this.worldObj, chunkX, chunkZ, primer);
		if (this.settings.useRavines) this.ravineGenerator.generate(this.worldObj, chunkX, chunkZ, primer);
		if (this.settings.useMineShafts && this.mapFeaturesEnabled) this.mineshaftGenerator.generate(this.worldObj, chunkX, chunkZ, primer);
		Chunk chunk = new Chunk(this.worldObj, primer, chunkX, chunkZ);
		byte[] abyte = chunk.getBiomeArray();
		
		for (int k = 0; k < abyte.length; k ++) {
			abyte[k] = (byte) BiomeGenBase.getIdForBiome(this.biomesForGeneration[k]);
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	private void setupNoiseFields(int posX, int posY, int posZ) {
		this.ngo5Octaves = this.noiseGen6.generateNoiseOctaves(this.ngo5Octaves, posX, posZ, 5, 5, (double) this.settings.depthNoiseScaleX, (double) this.settings.depthNoiseScaleZ, (double) this.settings.depthNoiseScaleExponent);
		float f = this.settings.coordinateScale;
		float f1 = this.settings.heightScale;
		this.ngo3Octaves = this.noiseGen3.generateNoiseOctaves(this.ngo3Octaves, posX, posY, posZ, 5, 33, 5, (double) (f / this.settings.mainNoiseScaleX), (double) (f1 / this.settings.mainNoiseScaleY), (double) (f / this.settings.mainNoiseScaleZ));
		this.ngo1Octaves = this.noiseGen1.generateNoiseOctaves(this.ngo1Octaves, posX, posY, posZ, 5, 33, 5, (double) f, (double) f1, (double) f);
		this.ngo2Octaves = this.noiseGen2.generateNoiseOctaves(this.ngo2Octaves, posX, posY, posZ, 5, 33, 5, (double) f, (double) f1, (double) f);
		int l = 0;
		int i1 = 0;
		
		for (int j1 = 0; j1 < 5; j1 ++) {
			for (int k1 = 0; k1 < 5; k1 ++) {
				float f2 = 0.0F;
				float f3 = 0.0F;
				float f4 = 0.0F;
				byte b0 = 2;
				BiomeGenBase bgb = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
				
				for (int l1 = -b0; l1 <= b0; l1 ++) {
					for (int i2 = -b0; i2 < b0; i2 ++) {
						BiomeGenBase bgb1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f5 = this.settings.biomeDepthOffSet + bgb1.getBaseHeight() * this.settings.biomeDepthWeight;
						float f6 = this.settings.biomeScaleOffset + bgb1.getHeightVariation() * this.settings.biomeScaleWeight;
						
						if (this.worldType == WorldType.AMPLIFIED && f5 > 0.0F) {
							f5 = 1.0F + f5 * 2.0F;
							f6 = 1.0F + f6 * 4.0F;
						}
						
						float f7 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f5 + 2.0F);
						
						if (bgb1.getBaseHeight() > bgb.getBaseHeight()) {
							f7 /= 2.0F;
						}
						
						f2 += f6 * f7;
						f3 += f5 * f7;
						f4 += f7;
					}
				}
				
				f2 /= f4;
				f3 /= f4;
				f2 = f2 * 0.9F + 0.1F;
				f3 = (f3 * 4.0F - 1.0F) / 8.0F;
				double d7 = this.ngo5Octaves[i1] / 8000.0D;
				
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
				
				i1 ++;
				double d8 = (double) f3;
				double d9 = (double) f2;
				d8 += d7 * 0.2D;
				d8 = d8 * (double) this.settings.baseSize / 8.0D;
				double d0 = (double) this.settings.baseSize + d8 * 4.0D;
				
				for (int j2 = 0; j2 < 33; j2 ++) {
					double d1 = ((double) j2 - d0) * (double) this.settings.stretchY * 128.0D / 256.0D / d9;
					
					if (d1 < 0.0D) {
						d1 *= 4.0D;
					}
					
					double d2 = this.ngo1Octaves[l] / (double) this.settings.lowerLimitScale;
					double d3 = this.ngo2Octaves[l] / (double) this.settings.upperLimitScale;
					double d4 = (this.ngo3Octaves[l] / 10.0D + 1.0D) / 2.0D;
					double d5 = MathHelper.denormalizeClamp(d2, d3, d4) - d1;
					
					if (j2 > 29) {
						double d6 = (double) ((float) (j2 - 29) / 3.0F);
						d5 = d5 * (1.0D - d6) + -10.0D * d6;
					}
					
					this.doubleArray1[l] = d5;
					l ++;
				}
			}
		}
	}
	
	@Override public void populate(int chunkX, int chunkZ) {
		BlockFalling.fallInstantly = true;
		int xPos = chunkX * 16;
		int zPos = chunkZ * 16;
		BlockPos blockpos = new BlockPos(xPos, 0, zPos);
		BiomeGenBase bgb = this.worldObj.getBiomeGenForCoords(blockpos.add(16, 0, 16));
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long) chunkX * i1 + (long) chunkZ * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(chunkX, chunkZ);
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(this, worldObj, rand, chunkX, chunkZ, flag));
		
		if (this.settings.useMineShafts) this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, chunkcoordintpair);
		
		int k1;
		int l1;
		int i2;
		
		if (bgb != Biomes.desert && bgb != Biomes.desertHills && this.settings.useWaterLakes && !flag && this.rand.nextInt(this.settings.waterLakeChance) == 0 && TerrainGen.populate(this, worldObj, rand, chunkX, chunkZ, flag, LAKE)) {
			k1 = this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, blockpos.add(k1, l1, i2));
		}
		
		if (TerrainGen.populate(this, worldObj, rand, chunkX, chunkZ, flag, LAVA) && !flag && this.rand.nextInt(this.settings.lavaLakeChance / 10) == 0 && this.settings.useLavaLakes) {
			k1 = this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
			i2 = this.rand.nextInt(16) + 8;
			
			if (l1 < 63 || this.rand.nextInt(this.settings.lavaLakeChance / 8) == 0) {
				(new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, blockpos.add(k1, l1, i2));
			}
		}
		
		if (this.settings.useDungeons) {
			boolean doGen = TerrainGen.populate(this, worldObj, rand, chunkX, chunkZ, flag, DUNGEON);
			for (k1 = 0; doGen && k1 < this.settings.dungeonChance; ++ k1) {
				l1 = this.rand.nextInt(16) + 8;
				i2 = this.rand.nextInt(256);
				int j2 = this.rand.nextInt(16) + 8;
				(new WorldGenDungeons()).generate(this.worldObj, this.rand, blockpos.add(l1, i2, j2));
			}
		}
		
		bgb.decorate(this.worldObj, this.rand, new BlockPos(xPos, 0, zPos));
		if (TerrainGen.populate(this, worldObj, rand, chunkX, chunkZ, flag, ANIMALS)) {
			WorldEntitySpawner.performWorldGenSpawning(this.worldObj, bgb, xPos + 8, zPos + 8, 16, 16, this.rand);
		}
		blockpos = blockpos.add(8, 0, 8);
		
		boolean doGen = TerrainGen.populate(this, worldObj, rand, chunkX, chunkZ, flag, ICE);
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
		
		if (bgb == ModBiomes.voidMountains && this.rand.nextInt(this.dragonSpawnerChance) == 0) {
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
			if (yPos != -1) (new DragonNest()).generate(this.worldObj, this.rand, new BlockPos(blockpos.getX() + k1, yPos, blockpos.getZ() + i2));
		}
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(this, worldObj, rand, chunkX, chunkZ, flag));
		
		BlockFalling.fallInstantly = false;
	}
	
	@Override public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(pos);
		return biomegenbase == null ? null : biomegenbase.getSpawnableList(creatureType);
	}
	
	@Override public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}
	
	@Override public void recreateStructures(Chunk chunk, int chunkX, int chunkZ) {
		if (this.settings.useMineShafts && this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generate(this.worldObj, chunkX, chunkZ, (ChunkPrimer) null);
		}
	}

	@Override public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}
}