package com.zalthrion.zylroth.block.machine;

import com.zalthrion.zylroth.block.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBaseContainer extends BlockBase implements ITileEntityProvider {
	
	public BlockBaseContainer() {
		this(Material.rock);
	}
	
	public BlockBaseContainer(boolean setCreativeTab) {
		this(Material.rock, setCreativeTab);
	}
	
	public BlockBaseContainer(Material material) {
		this(material, true);
	}
	
	public BlockBaseContainer(Material material, boolean setCreativeTab) {
		super(material, setCreativeTab);
		this.isBlockContainer = true;
	}
	
	/** Called whenever the block is added into the world. Args: world, x, y, z */
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		super.breakBlock(world, x, y, z, block, meta);
		world.removeTileEntity(x, y, z);
	}
	
	@Override
	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventID, int eventData) {
		super.onBlockEventReceived(world, x, y, z, eventID, eventData);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		return tileentity != null ? tileentity.receiveClientEvent(eventID, eventData) : false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return null;
	}
}