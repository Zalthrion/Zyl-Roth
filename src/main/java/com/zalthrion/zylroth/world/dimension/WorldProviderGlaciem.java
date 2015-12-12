package com.zalthrion.zylroth.world.dimension;

import com.zalthrion.zylroth.lib.ModDimension;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderGlaciem extends WorldProvider {
	
	@Override public IChunkProvider createChunkGenerator() {
		return new ChunkProviderGlaciem(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerGlaciem(worldObj.getSeed(), this.worldObj.getWorldType());
		this.dimensionId = ModDimension.dimensionId_Glaciem;
		this.hasNoSky = false;
	}
	
	@Override public String getDimensionName() {
		return "Glaciem";
	}
	
	@Override public String getSaveFolder() {
		return "Glaciem";
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getSkyRenderer() {
		return new SkyRenderGlaciem();
	}
	
	@Override public IRenderHandler getCloudRenderer() {
		return new SkyRenderGlaciem();
	}
	
	@Override @SideOnly(Side.CLIENT) public boolean isSkyColored() {
		return true;
	}
	
	@Override @SideOnly(Side.CLIENT) public Vec3 getFogColor(float p_76562_1_, float p_76562_2_) {
		float f2 = MathHelper.cos(p_76562_1_ * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		
		float f3 = 255.0F;
		float f4 = 255.0F;
		float f5 = 255.0F;
		f3 *= f2 * 0.0F + 0.15F;
		f4 *= f2 * 0.0F + 0.15F;
		f5 *= f2 * 0.0F + 0.15F;
		return new Vec3(f3, f4, f5);
	}
	
	@Override @SideOnly(Side.CLIENT) public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	/** Returns 'true' if in the "main surface world", but 'false' if in the
	 * Nether or End dimensions. */
	@Override public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override public boolean canDoRainSnowIce(Chunk chunk) {
		return true;
	}
	
	@Override public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	/** Calculates the angle of sun and moon in the sky relative to a specified
	 * time (usually worldTime) */
	@Override public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return 0.0F;
	}
	
	/** Returns array with sunrise/sunset colors */
	@Override @SideOnly(Side.CLIENT) public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
		return null;
	}
	
	/** Lightness of the dimension */
	@Override protected void generateLightBrightnessTable() {
		float f = 0.08F;
		
		for (int i = 0; i <= 15; ++ i) {
			float f1 = 1.0F - i / 15.0F;
			lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}

	@Override public String getInternalNameSuffix() {
		return "";
	}
}