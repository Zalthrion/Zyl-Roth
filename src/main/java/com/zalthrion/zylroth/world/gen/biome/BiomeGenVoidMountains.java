package com.zalthrion.zylroth.world.gen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.zalthrion.zylroth.world.gen.structures.DragonNest;

public class BiomeGenVoidMountains extends BiomeGenBase {
	
	public BiomeGenVoidMountains(int id) {
		super(id);
		
		this.enableRain = false;
		this.enableSnow = false;
		
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.flowers.clear();
		
		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
		
		this.setHeight(height_HighPlateaus);
		this.setBiomeName("Void Mountains");
		
		this.waterColorMultiplier = 0xE42D17;
	}
	
	@Override public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		if (rand.nextInt(100) == 0) {
			int i = rand.nextInt(16) + 8;
			int j = rand.nextInt(16) + 8;
			BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
			(new DragonNest()).generate(worldIn, rand, blockpos);
		}
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return color = 0x423E45;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return color = 0x423E45;
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x1E2224;
	}
}