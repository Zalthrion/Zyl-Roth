package com.zalthrion.zylroth.world.dimension;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.MINESHAFT;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderKyrul implements IChunkProvider {
	/** RNG. */
	private Random rand;
	private NoiseGeneratorOctaves field_147431_j;
	private NoiseGeneratorOctaves field_147432_k;
	private NoiseGeneratorOctaves field_147429_l;
	private NoiseGeneratorPerlin field_147430_m;
	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen5;
	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	/** Reference to the World object. */
	private World worldObj;
	/** are map structures going to be generated (e.g. strongholds) */
	private final boolean mapFeaturesEnabled;
	private WorldType field_147435_p;
	private final double[] field_147434_q;
	private final float[] parabolicField;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
	/** Holds Mineshaft Generator */
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	// private DragonNest dragonNestGenerator = new DragonNest();
	/** Holds ravine generator */
	private MapGenBase ravineGenerator = new MapGenRavine();
	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[] biomesForGeneration;
	double[] field_147427_d;
	double[] field_147428_e;
	double[] field_147425_f;
	double[] field_147426_g;
	int[][] field_73219_j = new int[32][32];
	
	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
		mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
		ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
	}
	
	public ChunkProviderKyrul(World p_i2006_1_, long p_i2006_2_, boolean p_i2006_4_) {
		this.worldObj = p_i2006_1_;
		this.mapFeaturesEnabled = p_i2006_4_;
		this.field_147435_p = p_i2006_1_.getWorldInfo().getTerrainType();
		this.rand = new Random(p_i2006_2_);
		this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
		this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.field_147434_q = new double[825];
		this.parabolicField = new float[25];
		
		for (int j = -2; j <= 2; ++ j) {
			for (int k = -2; k <= 2; ++ k) {
				float f = 10.0F / MathHelper.sqrt_float((float) (j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
		
		NoiseGenerator[] noiseGens = {field_147431_j, field_147432_k, field_147429_l, field_147430_m, noiseGen5, noiseGen6, mobSpawnerNoise};
		noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2006_1_, this.rand, noiseGens);
		this.field_147431_j = (NoiseGeneratorOctaves) noiseGens[0];
		this.field_147432_k = (NoiseGeneratorOctaves) noiseGens[1];
		this.field_147429_l = (NoiseGeneratorOctaves) noiseGens[2];
		this.field_147430_m = (NoiseGeneratorPerlin) noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves) noiseGens[4];
		this.noiseGen6 = (NoiseGeneratorOctaves) noiseGens[5];
		this.mobSpawnerNoise = (NoiseGeneratorOctaves) noiseGens[6];
	}
	
	public void populateChunkArray(int chunkX, int chunkZ, ChunkPrimer primer) {
		byte b0 = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		this.func_147423_a(chunkX * 4, 0, chunkZ * 4);
		
		for (int k = 0; k < 4; ++ k) {
			int l = k * 5;
			int i1 = (k + 1) * 5;
			
			for (int j1 = 0; j1 < 4; ++ j1) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;
				
				for (int k2 = 0; k2 < 32; ++ k2) {
					double d0 = 0.125D;
					double d1 = this.field_147434_q[k1 + k2];
					double d2 = this.field_147434_q[l1 + k2];
					double d3 = this.field_147434_q[i2 + k2];
					double d4 = this.field_147434_q[j2 + k2];
					double d5 = (this.field_147434_q[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.field_147434_q[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.field_147434_q[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.field_147434_q[j2 + k2 + 1] - d4) * d0;
					
					for (int l2 = 0; l2 < 8; ++ l2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;
						
						for (int i3 = 0; i3 < 4; ++ i3) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;
							
                            for (int k3 = 0; j2 < 4; ++j2)
                            {
                                IBlockState iblockstate = null;

                                if ((d15 += d16) > 0.0D) iblockstate = Blocks.stone.getDefaultState();
                                if (k2 * 8 + l2 < b0) iblockstate = Blocks.water.getDefaultState();

                                int xPos = i2 + i1 * 4;
                                int yPos = l1 + k1 * 8;
                                int zPos = j2 + j1 * 4;
                                primer.setBlockState(xPos, yPos, zPos, iblockstate);
                                d15 += d16;
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
	
	private void populateChunkArrayNew(int chunkX, int chunkY, ChunkPrimer primer) {
		for (int y = 0; y <= 64; y ++) {
			for (int x = 0; x < 16; x ++) {
				for (int z = 0; z < 16; z ++) {
					if (y == 0) primer.setBlockState(x, y, z, Blocks.bedrock.getDefaultState());
					if (y > 0 && y < 64) primer.setBlockState(x, y, z, Blocks.dirt.getDefaultState());
					if (y == 64) primer.setBlockState(x, y, z, Blocks.grass.getDefaultState());
				}
			}
		}
	}
	
	@Override public Chunk provideChunk(int chunkX, int chunkZ) {
		this.rand.setSeed((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);
		ChunkPrimer primer = new ChunkPrimer();
		// this.populateChunkArray(chunkX, chunkZ, primer);
		this.populateChunkArrayNew(chunkX, chunkZ, primer);
		// primer.setBlockState(0, Blocks.bedrock.getDefaultState());
		this.caveGenerator.generate(this, this.worldObj, chunkX, chunkZ, primer);
		this.ravineGenerator.generate(this, this.worldObj, chunkX, chunkZ, primer);
		
		if (this.mapFeaturesEnabled) this.mineshaftGenerator.generate(this, this.worldObj, chunkX, chunkZ, primer);
		
		Chunk chunk = new Chunk(this.worldObj, primer, chunkX, chunkZ);
		BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[]) null, chunkX * 16, chunkZ * 16, 16, 16);
		byte[] abyte1 = chunk.getBiomeArray();
		
		for (int k = 0; k < abyte1.length; ++ k) {
			abyte1[k] = (byte) abiomegenbase[k].biomeID;
		}
		
		chunk.resetRelightChecks();
		return chunk;
	}
	
	private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
		this.field_147426_g = this.noiseGen6.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
		this.field_147427_d = this.field_147429_l.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.field_147428_e = this.field_147431_j.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.field_147425_f = this.field_147432_k.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		int l = 0;
		int i1 = 0;
		
		for (int j1 = 0; j1 < 5; ++ j1) {
			for (int k1 = 0; k1 < 5; ++ k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
				
				for (int l1 = -b0; l1 <= b0; ++ l1) {
					for (int i2 = -b0; i2 <= b0; ++ i2) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f3 = biomegenbase1.minHeight;
						float f4 = biomegenbase1.maxHeight;
						
						if (this.field_147435_p == WorldType.AMPLIFIED && f3 > 0.0F) {
							f3 = 1.0F + f3 * 2.0F;
							f4 = 1.0F + f4 * 4.0F;
						}
						
						float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
						
						if (biomegenbase1.minHeight > biomegenbase.minHeight) {
							f5 /= 2.0F;
						}
						
						f += f4 * f5;
						f1 += f3 * f5;
						f2 += f5;
					}
				}
				
				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d12 = this.field_147426_g[i1] / 8000.0D;
				
				if (d12 < 0.0D) {
					d12 = -d12 * 0.3D;
				}
				
				d12 = d12 * 3.0D - 2.0D;
				
				if (d12 < 0.0D) {
					d12 /= 2.0D;
					
					if (d12 < -1.0D) {
						d12 = -1.0D;
					}
					
					d12 /= 1.4D;
					d12 /= 2.0D;
				} else {
					if (d12 > 1.0D) {
						d12 = 1.0D;
					}
					
					d12 /= 8.0D;
				}
				
				++ i1;
				double d13 = (double) f1;
				double d14 = (double) f;
				d13 += d12 * 0.2D;
				d13 = d13 * 8.5D / 8.0D;
				double d5 = 8.5D + d13 * 4.0D;
				
				for (int j2 = 0; j2 < 33; ++ j2) {
					double d6 = ((double) j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
					
					if (d6 < 0.0D) {
						d6 *= 4.0D;
					}
					
					double d7 = this.field_147428_e[l] / 512.0D;
					double d8 = this.field_147425_f[l] / 512.0D;
					double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
					
					if (j2 > 29) {
						double d11 = (double) ((float) (j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}
					
					this.field_147434_q[l] = d10;
					++ l;
				}
			}
		}
	}
	
	/** Checks to see if a chunk exists at x, y */
	public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
		return true;
	}
	
	/** Populates chunk with ores etc etc */
	@Override public void populate(IChunkProvider provider, int chunkX, int chunkZ) {
		BlockFalling.fallInstantly = true;
		
		int k = chunkX * 16;
		int l = chunkZ * 16;
		
		ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(chunkX, chunkZ);
		
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long) chunkX * i1 + (long) chunkZ * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(provider, this.worldObj, this.rand, chunkX, chunkZ, false));
		
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(new BlockPos(chunkX * 16, 0, chunkZ * 16));
		
		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, chunkcoordintpair);
		}
		
		int k1;
		int l1;
		int i2;
		
		if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(provider, worldObj, rand, chunkX, chunkZ, flag, Populate.EventType.LAKE)) {
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = l + this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, new BlockPos(k1, l1, i2));
		}
		
		if (TerrainGen.populate(provider, worldObj, rand, chunkX, chunkZ, flag, Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
			i2 = l + this.rand.nextInt(16) + 8;
			
			if (l1 < 63 || this.rand.nextInt(10) == 0) {
				(new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, new BlockPos(k1, l1, i2));
			}
		}
		
		boolean doGen = TerrainGen.populate(provider, worldObj, rand, chunkX, chunkZ, flag, Populate.EventType.DUNGEON);
		for (k1 = 0; doGen && k1 < 8; ++ k1) {
			l1 = k + this.rand.nextInt(16) + 8;
			i2 = this.rand.nextInt(256);
			int j2 = l + this.rand.nextInt(16) + 8;
			(new WorldGenDungeons()).generate(this.worldObj, this.rand, new BlockPos(l1, i2, j2));
		}
		
		biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 0, l));
		if (TerrainGen.populate(provider, worldObj, rand, chunkX, chunkZ, flag, Populate.EventType.ANIMALS)) {
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		}
		
		k += 8;
		l += 8;
		
		doGen = TerrainGen.populate(provider, worldObj, rand, chunkX, chunkZ, flag, Populate.EventType.ICE);
		for (k1 = 0; doGen && k1 < 16; ++ k1) {
			for (l1 = 0; l1 < 16; ++ l1) {
				i2 = this.worldObj.getPrecipitationHeight(new BlockPos(k + k1, 0, l + l1)).getY();
				
				if (this.worldObj.canBlockFreeze(new BlockPos(k1 + k, i2 - 1, l1 + l), false)) {
					this.worldObj.setBlockState(new BlockPos(k1 + k, i2 - 1, l1 + l), Blocks.ice.getDefaultState());
				}
				
				if (this.worldObj.canSnowAt(new BlockPos(k1 + k, i2, l1 + l), true)) {
					this.worldObj.setBlockState(new BlockPos(k1 + k, i2, l1 + l), Blocks.snow_layer.getDefaultState());
				}
			}
		}
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(provider, worldObj, rand, chunkX, chunkZ, flag));
		
		BlockFalling.fallInstantly = false;
	}
	
	/** Two modes of operation: if passed true, save all Chunks in one go. If
	 * passed false, save up to two chunks. Return true if all chunks have been
	 * saved. */
	@Override public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
		return true;
	}
	
	/** Save extra data not associated with any Chunk. Not saved during autosave,
	 * only during world unload. Currently unimplemented. */
	@Override public void saveExtraData() {}
	
	/** Unloads chunks that are marked to be unloaded. This is not guaranteed to
	 * unload every such chunk. */
	@Override public boolean unloadQueuedChunks() {
		return false;
	}
	
	/** Returns if the IChunkProvider supports saving. */
	@Override public boolean canSave() {
		return true;
	}
	
	/** Converts the instance data to a readable string. */
	@Override public String makeString() {
		return "RandomLevelSource";
	}
	
/*	public ChunkPosition findClosestStructure(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
		return null;
	}*/
	
	@Override public int getLoadedChunkCount() {
		return 0;
	}

	@Override public Chunk provideChunk(BlockPos blockPosIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public boolean func_177460_a(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes") @Override public List getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(pos);
		return biomegenbase == null ? null : biomegenbase.getSpawnableList(creatureType);
	}

	@Override public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public void recreateStructures(Chunk chunk, int chunkX, int chunkZ) {
/*		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generate(this, this.worldObj, p_82695_1_, p_82695_2_, (Block[]) null);
		}*/
	}
}