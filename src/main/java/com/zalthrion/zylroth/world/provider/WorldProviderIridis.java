package com.zalthrion.zylroth.world.provider;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModInit.DimensionInit;
import com.zalthrion.zylroth.world.generator.ChunkGeneratorIridis;
import com.zalthrion.zylroth.world.render.SkyRenderIridis;

public class WorldProviderIridis extends WorldProvider {
	@Override public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderIridis(this.worldObj.getSeed(), this.worldObj.getWorldInfo().getTerrainType());
	}
	
	@Override public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorIridis(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().getGeneratorOptions());
	}
	
	@Override public DimensionType getDimensionType() {
		return DimensionInit.IRIDIS;
	}
	
	@Override public String getSaveFolder() {
		return "Iri'dis";
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getSkyRenderer() {
		return new SkyRenderIridis();
	}
}