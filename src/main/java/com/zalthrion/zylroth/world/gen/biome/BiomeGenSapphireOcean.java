package com.zalthrion.zylroth.world.gen.biome;

import com.zalthrion.zylroth.reference.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSapphireOcean extends BiomeGenBase {
	
    public BiomeGenSapphireOcean(int id)
    {
        super(id);
        
        this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.topBlock = (Blocks.flowing_water);
		this.fillerBlock = (Blocks.flowing_water);
		
		this.setBiomeName(StatCollector.translateToLocal("biome" + "." + Reference.MOD_ID + ":" + "sapphireOcean"));
		this.setHeight(height_Oceans);
		
		this.waterColorMultiplier = 0x38CAE0;
		
    }

    public BiomeGenBase.TempCategory getTempCategory()
    {
        return BiomeGenBase.TempCategory.OCEAN;
    }
	
	@Override
	public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
		return color = 0x0CA833;
	}
	
	@Override
	public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
		return color = 0x16BA40;
	}
	
	public int getSkyColorByTemp(float par1) {
		return 0x3CA7B5;
	}
	
}