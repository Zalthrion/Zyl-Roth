package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;

import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.TenebraeOre;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {
	
	public static Block Tenebrae_Ore;
	public static Block Tenebrae_Block;
	public static Block Tenebrae_Core;
	public static Block Chiseled_Tenebrae;
	public static Block Infused_Tenebrae;
	
	public static Block Infuser;
	public static Block Infuser_Idle;
	
	public static void init() {
		registerBlocks();
	}
	
	public static void registerBlocks() {
		Tenebrae_Ore = new TenebraeOre();
		Tenebrae_Block = new TenebraeBlock();
		Tenebrae_Core = new TenebraeCore();
		Chiseled_Tenebrae = new ChiseledTenebrae();
		Infused_Tenebrae = new InfusedTenebrae();
		
		// Infuser
		
		Infuser = new InfuserMachine(true);
		Infuser_Idle = new InfuserMachine(false);
		
		GameRegistry.registerBlock(ModBlocks.Infuser_Idle, "infuserMachine");
		GameRegistry.registerBlock(ModBlocks.Infuser, "infuserMachineActive");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "Infuser");
	}
}
