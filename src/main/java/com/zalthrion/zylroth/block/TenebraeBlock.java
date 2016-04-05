package com.zalthrion.zylroth.block;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.reference.Reference;

public class TenebraeBlock extends BlockBase {
	public TenebraeBlock() {
		super(Material.rock);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("tenebraeBlock");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "beacon"));
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			tooltip.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae"));
		} else {
			tooltip.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
		}
	}
	
	@Override public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}