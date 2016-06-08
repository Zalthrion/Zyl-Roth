package com.zalthrion.zylroth.world.provider;

import java.util.List;
import java.util.Random;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.zalthrion.zylroth.world.genlayer.GenLayerIridis;

//TODO Check all mappings, reorganize methods, etc.
public class BiomeProviderIridis extends BiomeProvider {
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;
	private BiomeCache biomeCache;
	private List<Biome> biomesToSpawnIn;
	
	public BiomeProviderIridis() {
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawnIn = Lists.<Biome> newArrayList();
		this.biomesToSpawnIn.addAll(allowedBiomes);
	}
	
	public BiomeProviderIridis(long seed, WorldType worldType) {
		this();
		
		GenLayer[] genlayer = GenLayerIridis.makeTheWorld(seed, worldType);
		genlayer = getModdedBiomeGenerators(worldType, seed, genlayer);
		this.genBiomes = genlayer[0];
		this.biomeIndexLayer = genlayer[1];
	}
	
	public BiomeProviderIridis(World world) {
		this(world.getSeed(), world.getWorldInfo().getTerrainType());
	}
	
	@Override public List<Biome> getBiomesToSpawnIn() {
		return this.biomesToSpawnIn;
	}
	
	@Override public Biome getBiome(BlockPos pos) {
		return this.biomeCache.getBiome(pos.getX(), pos.getZ(), (Biome) null);
	}
	
	@Override @SideOnly(Side.CLIENT) public float getTemperatureAtHeight(float par1, int par2) {
		return par1;
	}
	
	@Override public Biome[] getBiomesForGeneration(Biome[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
		IntCache.resetIntCache();
		
		if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
			par1ArrayOfBiomeGenBase = new Biome[par4 * par5];
		}
		
		int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);
		
		try {
			for (int i = 0; i < par4 * par5; ++ i) {
				par1ArrayOfBiomeGenBase[i] = Biome.getBiome(aint[i]);
			}
			
			return par1ArrayOfBiomeGenBase;
		} catch (Throwable throwable) {
			CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
			CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
			crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(par1ArrayOfBiomeGenBase.length));
			crashreportcategory.addCrashSection("x", Integer.valueOf(par2));
			crashreportcategory.addCrashSection("z", Integer.valueOf(par3));
			crashreportcategory.addCrashSection("w", Integer.valueOf(par4));
			crashreportcategory.addCrashSection("h", Integer.valueOf(par5));
			throw new ReportedException(crashreport);
		}
	}
	
	@Override public Biome[] getBiomes(Biome[] oldBiomeList, int x, int z, int width, int depth) {
		return this.getBiomes(oldBiomeList, x, z, width, depth, true);
	}
	
	@Override public Biome[] getBiomes(Biome[] listToReuse, int x, int y, int width, int length, boolean cacheFlag) {
		IntCache.resetIntCache();
		
		if (listToReuse == null || listToReuse.length < width * length) {
			listToReuse = new Biome[width * length];
		}
		
		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (y & 15) == 0) {
			Biome[] abiomegenbase1 = this.biomeCache.getCachedBiomes(x, y);
			System.arraycopy(abiomegenbase1, 0, listToReuse, 0, width * length);
			return listToReuse;
		} else {
			int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);
			
			for (int i = 0; i < width * length; ++ i) {
				listToReuse[i] = Biome.getBiome(aint[i]);
			}
			return listToReuse;
		}
	}
	
	@Override public boolean areBiomesViable(int x, int y, int z, List<Biome> par4List) {
		IntCache.resetIntCache();
		int l = x - z >> 2;
		int i1 = y - z >> 2;
		int j1 = x + z >> 2;
		int k1 = y + z >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		
		try {
			for (int j2 = 0; j2 < l1 * i2; ++ j2) {
				Biome biomegenbase = Biome.getBiome(aint[j2]);
				
				if (!par4List.contains(biomegenbase)) { return false; }
			}
			
			return true;
		} catch (Throwable throwable) {
			CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
			CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
			crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
			crashreportcategory.addCrashSection("x", Integer.valueOf(x));
			crashreportcategory.addCrashSection("z", Integer.valueOf(y));
			crashreportcategory.addCrashSection("radius", Integer.valueOf(z));
			crashreportcategory.addCrashSection("allowed", par4List);
			throw new ReportedException(crashreport);
		}
	}
	
	@Override public BlockPos findBiomePosition(int x, int y, int z, List<Biome> par4List, Random random) {
		IntCache.resetIntCache();
		int l = x - z >> 2;
		int i1 = y - z >> 2;
		int j1 = x + z >> 2;
		int k1 = y + z >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.genBiomes.getInts(l, i1, l1, i2);
		BlockPos blockpos = null;
		int j2 = 0;
		
		for (int k2 = 0; k2 < l1 * i2; ++ k2) {
			int l2 = l + k2 % l1 << 2;
			int i3 = i1 + k2 / l1 << 2;
			Biome biomegenbase = Biome.getBiome(aint[k2]);
			
			if (par4List.contains(biomegenbase) && (blockpos == null || random.nextInt(j2 + 1) == 0)) {
				blockpos = new BlockPos(l2, 0, i3);
				j2 ++;
			}
		}
		
		return blockpos;
	}
	
	@Override public void cleanupCache() {
		this.biomeCache.cleanupCache();
	}
}