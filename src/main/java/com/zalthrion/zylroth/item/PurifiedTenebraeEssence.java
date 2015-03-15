package com.zalthrion.zylroth.item;

import com.zalthrion.zylroth.lib.*;
import com.zalthrion.zylroth.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PurifiedTenebraeEssence extends Item{
	
	private String name = "Purified_Tenebrae_Essence";
	
	public PurifiedTenebraeEssence() {
		
	setUnlocalizedName(Reference.MOD_ID + "_" + name);
	GameRegistry.registerItem(this, name);
	setCreativeTab(ModTabs.Project_Exanimus);
    setTextureName(Reference.MOD_ID + ":" + name);
	}

}
