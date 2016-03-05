package com.zalthrion.zylroth.world.dimension;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.world.gen.map.MapGenIceCavesGlaciem;
import com.zalthrion.zylroth.world.gen.map.MapGenIceRavineGlaciem;
import com.zalthrion.zylroth.world.gen.structures.IcePillar;

public class ChunkProviderGlaciem implements IChunkProvider {
	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private WorldType type;
	private final double[] doubleArray1;
	private final float[] parabolicField;
	private double[] packedIceNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenIceCavesGlaciem();
	private MapGenBase ravineGenerator = new MapGenIceRavineGlaciem();
	private BiomeGenBase[] biomesForGeneration;
	double[] noiseGen1Octaves;
	double[] noiseGen2Octaves;
	double[] noiseGen3Octaves;
	double[] noiseGen6Octaves;
	int[][] field_73219_j = new int[32][32];
	private int icePillarChance = 10;
	private int packedIcePillarChance = 10;
	
	public ChunkProviderGlaciem(World world, long seed, boolean mapFeatures) {
		{
			caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, EventType.CAVE);
			ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, EventType.RAVINE);
		}
		
		this.worldObj = world;
		this.type = world.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.doubleArray1 = new double[825];
		this.parabolicField = new float[25];
		
		for (int j = -2; j <= 2; ++ j) {
			for (int k = -2; k <= 2; ++ k) {
				float f = 10.0F / MathHelper.sqrt_float((float) (j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}
		
		NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise};
		noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
		this.noiseGen1 = (NoiseGeneratorOctaves) noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves) noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves) noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorPerlin) noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves) noiseGens[4];
		this.noiseGen6 = (NoiseGeneratorOctaves) noiseGens[5];
		this.mobSpawnerNoise = (NoiseGeneratorOctaves) noiseGens[6];
	}
	
	public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
		byte b0 = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, chunkX * 4 - 2, chunkZ * 4 - 2, 10, 10);
		this.setupNoiseFields(chunkX * 4, 0, chunkZ * 4);
		
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
					double d1 = this.doubleArray1[k1 + k2];
					double d2 = this.doubleArray1[l1 + k2];
					double d3 = this.doubleArray1[i2 + k2];
					double d4 = this.doubleArray1[j2 + k2];
					double d5 = (this.doubleArray1[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.doubleArray1[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.doubleArray1[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.doubleArray1[j2 + k2 + 1] - d4) * d0;
					
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
							
							for (int k3 = 0; k3 < 4; ++ k3) {
								j3 += short1;
								if ((d15 += d16) > 0.0D) {
									primer.setBlockState(j3, Blocks.packed_ice.getDefaultState());
								} else if (k2 * 8 + l2 < b0) {
									primer.setBlockState(j3, Blocks.water.getDefaultState());
								} else {
									primer.setBlockState(j3, Blocks.air.getDefaultState());
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
	
	public void replaceBlocksForBiome(int chunkX, int chunkZ, ChunkPrimer primer, BiomeGenBase[] biomes) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, primer, this.worldObj);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return;
		
		double d0 = 0.03125D;
		this.packedIceNoise = this.noiseGen4.func_151599_a(this.packedIceNoise, (double) (chunkX * 16), (double) (chunkZ * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
		
		for (int k = 0; k < 16; ++ k) {
			for (int l = 0; l < 16; ++ l) {
				BiomeGenBase biomegenbase = biomes[l + k * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, primer, chunkX * 16 + k, chunkZ * 16 + l, this.packedIceNoise[l + k * 16]);
			}
		}
	}
	
	/** Will return back a chunk, if it doesn't exist and its not a MP client it
	 * will generates all the blocks for the specified chunk from the map seed
	 * and chunk seed */
	@Override public Chunk provideChunk(int chunkX, int chunkZ) {
		this.rand.setSeed((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);
		
		ChunkPrimer primer = new ChunkPrimer();
		this.setBlocksInChunk(chunkX, chunkZ, primer);
		
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.replaceBlocksForBiome(chunkX, chunkZ, primer, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, chunkX + 200, chunkZ + 200, primer);
		this.ravineGenerator.generate(this, this.worldObj, chunkX + 200, chunkZ + 200, primer);
		
		Chunk chunk = new Chunk(this.worldObj, primer, chunkX, chunkZ);
		byte[] abyte1 = chunk.getBiomeArray();
		
		for (int k = 0; k < abyte1.length; ++ k) {
			abyte1[k] = (byte) this.biomesForGeneration[k].biomeID;
		}
		
		chunk.generateSkylightMap();
		return chunk;
	}
	
	private void setupNoiseFields(int x, int y, int z) {
		this.noiseGen6Octaves = this.noiseGen6.generateNoiseOctaves(this.noiseGen6Octaves, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.noiseGen3Octaves = this.noiseGen3.generateNoiseOctaves(this.noiseGen3Octaves, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.noiseGen1Octaves = this.noiseGen1.generateNoiseOctaves(this.noiseGen1Octaves, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.noiseGen2Octaves = this.noiseGen2.generateNoiseOctaves(this.noiseGen2Octaves, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		int l = 0;
		int i1 = 0;
		
		for (int j1 = 0; j1 < 5; ++ j1) {
			for (int k1 = 0; k1 < 5; ++ k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 12];
				
				for (int l1 = -b0; l1 <= b0; ++ l1) {
					for (int i2 = -b0; i2 <= b0; ++ i2) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f3 = biomegenbase1.minHeight;
						float f4 = biomegenbase1.maxHeight;
						
						if (this.type == WorldType.AMPLIFIED && f3 > 0.0F) {
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
				double d12 = this.noiseGen6Octaves[i1] / 8000.0D;
				
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
					
					double d7 = this.noiseGen2Octaves[l] / 512.0D;
					double d8 = this.noiseGen3Octaves[l] / 512.0D;
					double d9 = (this.noiseGen1Octaves[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;
					
					if (j2 > 29) {
						double d11 = (double) ((float) (j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}
					
					this.doubleArray1[l] = d10;
					++ l;
				}
			}
		}
	}
	
	/** Checks to see if a chunk exists at x, y */
	@Override public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
		return true;
	}
	
	/** Populates chunk with ores etc etc */
	@Override public void populate(IChunkProvider chunkProvider, int x, int z) {
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
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(chunkProvider, worldObj, rand, x, z, flag));
		
		int k1;
		int l1;
		int i2;
		
		if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills && !flag && this.rand.nextInt(4) == 0 && TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, LAKE)) {
			k1 = this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, blockpos.add(k1, l1, i2));
		}
		
		biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 64, l));
		if (TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, Populate.EventType.ANIMALS)) {
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		}
		
		biomegenbase.decorate(this.worldObj, this.rand, new BlockPos(k, 0, l));
		if (TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, ANIMALS)) {
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		}
		blockpos = blockpos.add(8, 0, 8);
		
		boolean doGen = TerrainGen.populate(chunkProvider, worldObj, rand, x, z, flag, ICE);
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
		
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(chunkProvider, worldObj, rand, x, z, flag));
		
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
		return "GlaciemRandomLevelSource";
	}
	
	@Override public int getLoadedChunkCount() {
		return 0;
	}

	@Override public Chunk provideChunk(BlockPos blockPosIn) {
		return this.provideChunk(blockPosIn.getX() >> 4, blockPosIn.getZ() >> 4);
	}

	@Override public boolean populateChunk(IChunkProvider p_177460_1_, Chunk p_177460_2_, int p_177460_3_, int p_177460_4_) {
		return false;
	}

	@Override public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(pos);
		return biomegenbase == null ? null : biomegenbase.getSpawnableList(creatureType);
	}

	@Override public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}

	@Override public void recreateStructures(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {
		
	}
}