package com.zalthrion.zylroth.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.Reference;

public class BeaconBaseItemBlock extends ItemBlock {
	
	public BeaconBaseItemBlock(Block b) {
		super(b);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean advanced) {
		list.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "beacon"));
		
		list.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.remove(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "shift"));
			
			if (block == ModBlocks.tenebraeBlock) {
				list.add(I18n.translateToLocal("tooltip" + "." + Reference.MOD_ID.toLowerCase() + ":" + "tenebrae"));
			}
		}
	}
}
