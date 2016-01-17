package com.zalthrion.zylroth.block.machine;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;

public class GoldBag extends BlockBaseContainer {
	private String name = "goldBag";
	
	public GoldBag() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeMetal);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ModTabs.zylRoth);
		this.setParticleBlockState(Blocks.gold_block.getDefaultState());
	}
	
	@Override public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGoldBag();
	}
	
	@Override public int getRenderType() {
		return 2;
	}
}