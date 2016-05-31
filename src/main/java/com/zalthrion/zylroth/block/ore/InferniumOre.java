package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

public class InferniumOre extends BlockBase {
	
	/* Constructors */
	
	public InferniumOre() {
		super(Material.ROCK);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("inferniumOre");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
	
	/* Overridden */
	
	@Override @Nullable public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.RAW_INFERNIUM;
	}
	
	@Override public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(3);
	}
}