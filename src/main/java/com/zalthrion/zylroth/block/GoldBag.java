package com.zalthrion.zylroth.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zalthrion.zylroth.block.machine.BlockBaseContainer;
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
		this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGoldBag();
	}
	
	@Override public int getRenderType() {
		return 2;
	}
}