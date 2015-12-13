package com.zalthrion.zylroth.world.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

import com.zalthrion.zylroth.lib.ModDimension;

public class WorldProviderIridis extends WorldProvider {
	
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerIridis(worldObj.getSeed(), terrainType);
		this.dimensionId = ModDimension.dimensionId_Iridis;
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderIridis(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName() {
		return "Iri'dis";
	}
	
	@Override
	public String getSaveFolder() {
		return "Iri'dis";
	}
}
