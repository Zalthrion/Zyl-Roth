package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.world.World;

import com.zalthrion.zylroth.itemblock.CoreItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class TenebraeCore extends BlockBase {
	
	private String name = "tenebraeCore";
	
	public TenebraeCore() {
		super();
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		GameRegistry.registerBlock(this, CoreItemBlock.class, name);
	}
	
	@Override
	public void randomDisplayTick(World par1World, int x, int y, int z, Random par5Random) {
		super.randomDisplayTick(par1World, x, y, z, par5Random);
		
		for (int l = x - 2; l <= x + 2; ++ l) {
			for (int i1 = z - 2; i1 <= z + 2; ++ i1) {
				if (l > x - 2 && l < x + 2 && i1 == z - 1) {
					i1 = z + 2;
				}
				
				if (par5Random.nextInt(16) == 0) {
					for (int j1 = y; j1 <= y + 1; ++ j1) {
						{
							if (!par1World.isAirBlock((l - x) / 2 + x, j1, (i1 - z) / 2 + z)) {
								break;
							}
							
							par1World.spawnParticle("portal", (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (l - x) + par5Random.nextFloat() - 0.1F), (double) ((float) (j1 - y) - par5Random.nextFloat() - 0.1F), (double) ((float) (i1 - z) + par5Random.nextFloat()) - 0.1F);
						}
					}
				}
			}
		}
	}
}
