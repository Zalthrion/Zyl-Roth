package com.zalthrion.zylroth.world.provider;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.DimensionInit;
import com.zalthrion.zylroth.world.generator.ChunkGeneratorGlaciem;
import com.zalthrion.zylroth.world.render.SkyRenderGlaciem;

public class WorldProviderGlaciem extends WorldProvider {
	@Override @SideOnly(Side.CLIENT) public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		return null;
	}
	
	@Override public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.0F;
	}
	
	@Override public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	@Override public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderGlaciem(this.worldObj.getSeed(), this.worldObj.getWorldType());
	}
	
	@Override public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorGlaciem(this.worldObj, this.worldObj.getSeed());
	}
	
	@Override @SideOnly(Side.CLIENT) public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	@Override protected void generateLightBrightnessTable() {
		float f = 0.08F;
		
		for (int i = 0; i <= 15; i ++) {
			float f1 = 1.0F - i / 15.0F;
			lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
		}
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getCloudRenderer() {
		return new SkyRenderGlaciem();
	}
	
	@Override public DimensionType getDimensionType() {
		return DimensionInit.GLACIEM;
	}
	
	@Override @SideOnly(Side.CLIENT) public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.9, 1, 1);
	}
	
	@Override public String getSaveFolder() {
		return "Glaciem";
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getSkyRenderer() {
		return new SkyRenderGlaciem();
	}
	
	@Override @SideOnly(Side.CLIENT) public boolean isSkyColored() {
		return true;
	}
	
	@Override public boolean isSurfaceWorld() {
		return false;
	}
}