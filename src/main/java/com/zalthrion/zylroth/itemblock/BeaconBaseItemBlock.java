package com.zalthrion.zylroth.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.reference.Reference;

public class BeaconBaseItemBlock extends ItemBlock {
	
	public BeaconBaseItemBlock(Block b) {
		super(b);
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "beacon"));
		
		list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "shift"));
		
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			list.remove(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "shift"));
			
			if (block == ModBlocks.tenebrae_Block) {
				list.add(StatCollector.translateToLocal("tooltip" + "." + Reference.MOD_ID + ":" + "tenebrae"));
			}
		}
	}
}
