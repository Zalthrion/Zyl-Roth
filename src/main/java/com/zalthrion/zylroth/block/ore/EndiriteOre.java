package com.zalthrion.zylroth.block.ore;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.zalthrion.zylroth.block.BlockBase;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.lib.ModTabs;

public class EndiriteOre extends BlockBase {
	private String name = "endiriteOre";
	
	public EndiriteOre() {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setCreativeTab(ModTabs.zylRoth);
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.endiriteChunk;
	}
	
	@Override public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(4);
	}
	
	@Override public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		if (entity instanceof EntityDragon) {
			return false;
		}
		return true;
	}
}