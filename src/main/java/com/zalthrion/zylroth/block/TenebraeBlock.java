package com.zalthrion.zylroth.block;

import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;

import cpw.mods.fml.common.registry.GameRegistry;

public class TenebraeBlock extends BlockBase {
	
	private String name = "tenebraeBlock";
	
	public TenebraeBlock() {
		
		super();
		this.setNames(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		GameRegistry.registerBlock(this, BeaconBaseItemBlock.class, name);
	}
	
	@Override public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
}