package com.zalthrion.zylroth.world.dimension;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.Zylroth;

public class WorldProviderGlaciem extends WorldProvider {
	
	@Override public void registerWorldChunkManager() {
		this.worldChunkMgr = new BiomeProviderGlaciem(worldObj.getSeed(), this.worldObj.getWorldType());
	}

	@Override @SideOnly(Side.CLIENT) public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d((double) 0.9, (double) 1, (double) 1);
	}

	@Override protected void generateLightBrightnessTable() {
		float f = 0.08F;
		
		for (int i = 0; i <= 15; ++ i) {
			float f1 = 1.0F - i / 15.0F;
			lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
	
	@Override public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderGlaciem(this.worldObj, this.worldObj.getSeed());
	}
	
	@Override public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return 0.0F;
	}
	
	@Override @SideOnly(Side.CLIENT) public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	@Override public DimensionType getDimensionType() {
		return Zylroth.GLACIEM;
	}
	
	// Extras
	
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
	
	@Override public boolean canDoRainSnowIce(Chunk chunk) {
		return true;
	}
	
	@Override public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	@Override @SideOnly(Side.CLIENT) public float[] calcSunriseSunsetColors(float p_76560_1_, float p_76560_2_) {
		return null;
	}
}