package com.zalthrion.zylroth.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.reference.Reference;

public class CoreItemBlock extends ItemBlock {
	
	public CoreItemBlock(Block b) {
		super(b);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "shift"));
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "core"));
			list.remove(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "shift"));
		}
	}
	
}
