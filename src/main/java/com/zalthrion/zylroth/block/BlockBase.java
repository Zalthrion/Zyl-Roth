package com.zalthrion.zylroth.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.zalthrion.zylroth.lib.ModTabs;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBase extends Block {
	
	public BlockBase(Material material) {
		super(material);
	}
	
	public BlockBase(Material material, boolean setCreativeTab) {
		super(material);
		if (setCreativeTab) this.setCreativeTab(ModTabs.ZylRoth);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	public String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	protected void setNames(String name) {
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MOD_ID + ":" + name);
	}
	
}