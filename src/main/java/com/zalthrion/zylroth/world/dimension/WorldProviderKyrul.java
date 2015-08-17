package com.zalthrion.zylroth.world.dimension;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import com.zalthrion.zylroth.lib.ModDimension;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderKyrul extends WorldProvider {
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerKyrul(worldObj.getSeed(), terrainType);
		this.dimensionId = ModDimension.dimensionId_Kyrul;
		this.hasNoSky = true;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderKyrul(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName() {
		return "Ky'rul";
	}
	
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
		int i = 10518688;
		float f2 = MathHelper.cos(p_76562_1_ * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		
		float f3 = (float) (i >> 16 & 255) / 255.0F;
		float f4 = (float) (i >> 8 & 255) / 255.0F;
		float f5 = (float) (i & 255) / 255.0F;
		f3 *= f2 * 0.0F + 0.15F;
		f4 *= f2 * 0.0F + 0.15F;
		f5 *= f2 * 0.0F + 0.15F;
		return Vec3.createVectorHelper((double) f3, (double) f4, (double) f5);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	/** Returns 'true' if in the "main surface world", but 'false' if in the
	 * Nether or End dimensions. */
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return 8.0F;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	/** Calculates the angle of sun and moon in the sky relative to a specified
	 * time (usually worldTime) */
	public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return 0.0F;
	}
	
	/** Returns array with sunrise/sunset colors */
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}
	
	/** Lightness of the dimension */
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.05F;
		
		for (int i = 0; i <= 15; ++ i) {
			float f1 = 1.0F - i / 15.0F;
			lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer() {
		
		return new SkyRenderKyrul();
		
	}
}
