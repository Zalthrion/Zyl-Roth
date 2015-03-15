package com.zalthrion.zylroth.itemblock;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class HeadItemBlock extends ItemBlock {
	
	private String name = "HeadItemBlock";
	
    public HeadItemBlock(Block b)
    {
        super(b);
    }
	
	@Override
	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
	    list.add(StatCollector.translateToLocal("shift.tooltip"));
	    
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
		    list.add(StatCollector.translateToLocal("head.tooltip"));
		    list.remove(StatCollector.translateToLocal("shift.tooltip"));
		}
	}

}
