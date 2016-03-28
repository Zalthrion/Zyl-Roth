package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

public class InferniumOre extends BlockBase {
	public InferniumOre() {
		super(Material.rock);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setUnlocalizedName("inferniumOre");
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.rawInfernium;
	}
	
	@Override public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0) {
			int j = random.nextInt(fortune + 2) - 1;
			if (j < 0) j = 0;
			return this.quantityDropped(random) * (j + 1);
		}
		
		return this.quantityDropped(random);
	}
}