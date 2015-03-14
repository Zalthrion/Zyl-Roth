package com.zalthrion.zylroth.block;

import java.util.Random;

import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class TenebraeOre extends BlockBase {
	
	private String name = "tenebraeOre";
	
	public TenebraeOre() {
		
		super();
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override public void randomDisplayTick(World par1World, int x, int y, int z, Random par5Random) {
		super.randomDisplayTick(par1World, x, y, z, par5Random);
		
		double d0 = (double) ((float) x + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
		double d1 = (double) ((float) y + 0.4F);
		double d2 = (double) ((float) z + (1.5F + par5Random.nextFloat() * 12.0F) / 16.0F);
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
	}
}