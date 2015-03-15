package com.zalthrion.zylroth.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import com.zalthrion.zylroth.block.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class ModTabs {

	public static CreativeTabs Project_Exanimus = new CreativeTabs("Project_Exanimus") {

	@Override
	public Item getTabIconItem() {

		return ModItems.Purified_Tenebrae_Essence;
	}
	};
	
}