package com.zalthrion.zylroth.block;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.reference.Reference;

public class TenebraeCore extends BlockBase {
	public TenebraeCore() {
		super(Material.rock);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("tenebraeCore");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			tooltip.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "core"));
		} else {
			tooltip.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
		}
	}
}