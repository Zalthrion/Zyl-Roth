package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;

import com.zalthrion.zylroth.block.*;
import com.zalthrion.zylroth.block.machine.*;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {
	
	public static Block Tenebrae_Ore;
	public static Block Tenebrae_Block;
	public static Block Tenebrae_Core;
	public static Block Chiseled_Tenebrae;
	public static Block Infused_Tenebrae;
	
	public static Block Ash_Block;
	
	public static Block Infuser;
	public static Block Infuser_Idle;
	
	public static void init() {
		registerBlocks();
	}
	
	public static void registerBlocks() {
		
		//Tenebrae
		
		Tenebrae_Ore = new TenebraeOre();
		Tenebrae_Block = new TenebraeBlock();
		Tenebrae_Core = new TenebraeCore();
		Chiseled_Tenebrae = new ChiseledTenebrae();
		Infused_Tenebrae = new InfusedTenebrae();
		
		
		//Ambient
		
		Ash_Block = new AshBlock();
		
		
		// Infuser
		
		Infuser = new InfuserMachine(true);
		Infuser_Idle = new InfuserMachine(false);
		
		GameRegistry.registerBlock(ModBlocks.Infuser_Idle, "infuserMachine");
		GameRegistry.registerBlock(ModBlocks.Infuser, "infuserMachineActive");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "Infuser");
		
	}
}
