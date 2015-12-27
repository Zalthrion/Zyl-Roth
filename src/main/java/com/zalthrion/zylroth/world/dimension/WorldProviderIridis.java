package com.zalthrion.zylroth.world.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

import com.zalthrion.zylroth.handler.ConfigurationHandler;

public class WorldProviderIridis extends WorldProvider {
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerIridis(worldObj.getSeed(), this.worldObj.getWorldInfo().getTerrainType());
		this.dimensionId = ConfigurationHandler.getIridisId();
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderIridis(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().getGeneratorOptions());
	}
	
	@Override
	public String getDimensionName() {
		return "Iri'dis";
	}

	@Override public String getInternalNameSuffix() {
		return "";
	}
	
	@Override public String getSaveFolder() {
		return "Iri'dis";
	}
}