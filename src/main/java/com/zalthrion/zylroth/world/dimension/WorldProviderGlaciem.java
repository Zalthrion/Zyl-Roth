package com.zalthrion.zylroth.world.dimension;

import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import com.zalthrion.zylroth.handler.ConfigurationHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderGlaciem extends WorldProvider {
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderGlaciem(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerGlaciem(worldObj.getSeed(), terrainType);
		this.dimensionId = ConfigurationHandler.getGlaciemId();
		this.hasNoSky = false;
	}
	
	@Override
	public String getDimensionName() {
		return "Glaciem";
	}
	
	@Override
	public String getSaveFolder() {
		return "Glaciem";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer() {
		return new SkyRenderGlaciem();
	}
	
	@Override
	public IRenderHandler getCloudRenderer() {
		return new SkyRenderGlaciem();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
		return Vec3.createVectorHelper((double) 0.9, (double) 1, (double) 1);
	}
	
	@Override @SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	/** Returns 'true' if in the "main surface world", but 'false' if in the
	 * Nether or End dimensions. */
	@Override public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return true;
	}
	
	@Override
	public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	/** Calculates the angle of sun and moon in the sky relative to a specified
	 * time (usually worldTime) */
	@Override
	public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return 0.0F;
	}
	
	/** Returns array with sunrise/sunset colors */
	@Override
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
		return null;
	}
	
	/** Lightness of the dimension */
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.08F;
		
		for (int i = 0; i <= 15; ++ i) {
			float f1 = 1.0F - i / 15.0F;
			lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
}
