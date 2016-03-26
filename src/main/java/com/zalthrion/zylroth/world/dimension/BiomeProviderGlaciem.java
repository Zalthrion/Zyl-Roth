package com.zalthrion.zylroth.world.dimension;

import java.util.List;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.zalthrion.zylroth.world.gen.GenLayerGlaciem;

public class BiomeProviderGlaciem extends BiomeProvider {
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;
	private BiomeCache biomeCache;
	private List<BiomeGenBase> biomesToSpawnIn;
	
	public BiomeProviderGlaciem() {
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawnIn = Lists.<BiomeGenBase>newArrayList();
		this.biomesToSpawnIn.addAll(allowedBiomes);
	}
	
	public BiomeProviderGlaciem(long seed, WorldType worldType) {
		this();
		
		GenLayer[] genlayer = GenLayerGlaciem.makeTheWorld(seed, worldType);
		genlayer = getModdedBiomeGenerators(worldType, seed, genlayer);
		this.genBiomes = genlayer[0];
		this.biomeIndexLayer = genlayer[1];
	}
	
	public BiomeProviderGlaciem(World world) {
		this(world.getSeed(), world.getWorldInfo().getTerrainType());
	}
	
	@Override public List<BiomeGenBase> getBiomesToSpawnIn() {
		return this.biomesToSpawnIn;
	}
	
	@Override public BiomeGenBase getBiomeGenerator(BlockPos pos) {
		return this.biomeCache.getBiome(pos.getX(), pos.getZ(), (BiomeGenBase) null);
	}
	
	@Override @SideOnly(Side.CLIENT) public float getTemperatureAtHeight(float par1, int par2) {
		return par1;
	}
	
	@Override public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
		IntCache.resetIntCache();
		
		if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
			par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
		}
		
		int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);
		
		try {
			for (int i = 0; i < par4 * par5; ++ i) {
				par1ArrayOfBiomeGenBase[i] = BiomeGenBase.getBiome(aint[i]);
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
	
	@Override public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] oldBiomeList, int x, int z, int width, int depth) {
		return this.getBiomeGenAt(oldBiomeList, x, z, width, depth, true);
	}
	
	@Override public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse, int x, int y, int width, int length, boolean cacheFlag) {
		IntCache.resetIntCache();
		
		if (listToReuse == null || listToReuse.length < width * length) {
			listToReuse = new BiomeGenBase[width * length];
		}
		
		if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (y & 15) == 0) {
			BiomeGenBase[] abiomegenbase1 = this.biomeCache.getCachedBiomes(x, y);
			System.arraycopy(abiomegenbase1, 0, listToReuse, 0, width * length);
			return listToReuse;
		} else {
			int[] aint = this.biomeIndexLayer.getInts(x, y, width, length);
			
			for (int i = 0; i < width * length; ++ i) {
				listToReuse[i] = BiomeGenBase.getBiome(aint[i]);
			}
			return listToReuse;
		}
	}
	
	@Override public boolean areBiomesViable(int x, int y, int z, List<BiomeGenBase> par4List) {
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
				BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[j2]);
				
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
	
	@Override public void cleanupCache() {
		this.biomeCache.cleanupCache();
	}
}