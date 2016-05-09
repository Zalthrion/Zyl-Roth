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
import com.zalthrion.zylroth.world.generator.ChunkGeneratorKyrul;
import com.zalthrion.zylroth.world.render.SkyRenderKyrul;

public class WorldProviderKyrul extends WorldProvider {
	@Override public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.0F;
	}
	
	@Override @SideOnly(Side.CLIENT) public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		return null;
	}
	
	@Override public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	@Override public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderKyrul(this.worldObj.getSeed(), this.worldObj.getWorldInfo().getTerrainType());
		this.hasNoSky = true;
	}
	
	@Override public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorKyrul(this.worldObj, this.worldObj.getSeed(), true, this.worldObj.getWorldInfo().getGeneratorOptions());
	}
	
	@Override @SideOnly(Side.CLIENT) public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getCloudRenderer() {
		return new SkyRenderKyrul();
	}
	
	@Override public DimensionType getDimensionType() {
		return DimensionInit.KYRUL;
	}
	
	@Override @SideOnly(Side.CLIENT) public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		int i = 10518688;
/*		float f2 = MathHelper.cos(p_76562_1_ * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
		f2 = MathHelper.clamp_float(f2, 0.0F, 1.0F);*/
		
		float f3 = (float) (i >> 16 & 255) / 255.0F;
		float f4 = (float) (i >> 8 & 255) / 255.0F;
		float f5 = (float) (i & 255) / 255.0F;
/*		f3 *= f2 * 0.0F + 0.15F;
		f4 *= f2 * 0.0F + 0.15F;
		f5 *= f2 * 0.0F + 0.15F; // TODO Do these all just multiply by 0.15F? */
		f3 *= 0.15F;
		f4 *= 0.15F;
		f5 *= 0.15F;
		return new Vec3d((double) f3, (double) f4, (double) f5);
	}
	
	@Override public String getSaveFolder() {
		return "Ky'rul";
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getSkyRenderer() {
		return new SkyRenderKyrul();
	}
}