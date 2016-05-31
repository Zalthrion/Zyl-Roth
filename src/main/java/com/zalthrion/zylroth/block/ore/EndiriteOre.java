package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.lib.ModInit.ItemInit;

public class EndiriteOre extends BlockBase {
	
	/* Constructors */
	
	public EndiriteOre() {
		super(Material.ROCK);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("endiriteOre");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
	}
	
	/* Overridden */
	
	@Override public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		if (entity instanceof EntityDragon) return false;
		return true;
	}
	
	@Override @Nullable public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.ENDIRITE_ORE_ITEM;
	}

	@Override public int quantityDropped(Random random) {
		return 2 + random.nextInt(4);
	}
}