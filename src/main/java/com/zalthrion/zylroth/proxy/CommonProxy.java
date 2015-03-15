package com.zalthrion.zylroth.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy implements IProxy {

	
	public void registerRenderInformation(){ //Client side texture registering
	}

	public void registerTiles(){ //For registering TileEntities
	}

	public void registerBlocks(){ //For registering Blocks
	}

	public void registerItems(){ //For registering Items	
	}

	public void registerRenderers(){ //For registering renderers
	}
	
	public void init(){ //For registering stuff on the init
	}
}
