package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TenebraeIngot extends Item{
	
	private String name = "Tenebrae_Ingot";
	
	public TenebraeIngot() {
		
	setUnlocalizedName(Reference.MOD_ID + "_" + name);
	GameRegistry.registerItem(this, name);
	setCreativeTab(ModTabs.Project_Exanimus);
    setTextureName(Reference.MOD_ID + ":" + name);
	}

}
