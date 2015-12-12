package com.zalthrion.zylroth.block.machine;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.zalthrion.zylroth.block.BlockBase;

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
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
	}
	
	@Override
	public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
		super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		return tileentity != null ? tileentity.receiveClientEvent(eventID, eventParam) : false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return null;
	}
}