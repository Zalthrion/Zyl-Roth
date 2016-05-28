package com.zalthrion.zylroth.block;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.reference.Reference;

public class InfusedTenebrae extends BlockBase {
	public InfusedTenebrae() {
		super(Material.ROCK);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("infusedTenebrae");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
	}
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			tooltip.add(I18n.format("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae"));
		} else {
			tooltip.add(I18n.format("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
		}
	}
}