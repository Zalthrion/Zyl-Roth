package com.zalthrion.zylroth.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.zalthrion.zylroth.lib.ModDimension;

public class WorldProviderIridis extends WorldProvider {
	
	@Override public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderIridis(worldObj.getSeed(), this.worldObj.getWorldInfo().getTerrainType());
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderIridis(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().getGeneratorOptions());
	}
	
	@Override public String getSaveFolder() {
		return "Iri'dis";
	}
	
	@Override @SideOnly(Side.CLIENT) public IRenderHandler getSkyRenderer() {
		return new SkyRenderIridis();
	}
	
	@Override public DimensionType getDimensionType() {
		return ModDimension.IRIDIS;
	}
}