package com.zalthrion.zylroth.world.dimension;

import com.zalthrion.zylroth.lib.ModBiomes;
import com.zalthrion.zylroth.lib.ModDimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class WorldProviderIridis extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerIridis(worldObj.getSeed(), terrainType);
		this.dimensionId = ModDimension.dimensionId_Iridis;
	}
	
	public IChunkProvider createChunkGenerator(){
        return new ChunkProviderIridis(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	@Override
	public String getDimensionName() {
		return "Iri'dis";
	}
	
}
