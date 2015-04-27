package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.TenebraeOre;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

public final class ModBlocks {
	
	public static Block Tenebrae_Ore;
	public static Block Tenebrae_Block;
	public static Block Tenebrae_Core;
	public static Block Chiseled_Tenebrae;
	public static Block Infused_Tenebrae;
	
	public static Block Ash_Block;
	
	public static Block Spawner_VoidDragon;
	
	public static Block Infuser;
	public static Block Infuser_Idle;
	
	public static void init() {
		registerBlocks();
	}
	
	public static void registerBlocks() {
		
		// Tenebrae
		
		Tenebrae_Ore = new TenebraeOre();
		Tenebrae_Block = new TenebraeBlock();
		Tenebrae_Core = new TenebraeCore();
		Chiseled_Tenebrae = new ChiseledTenebrae();
		Infused_Tenebrae = new InfusedTenebrae();
		
		// Ambient
		
		Ash_Block = new AshBlock();
		
		// Spawners
		
		Spawner_VoidDragon = new SpawnerVoidDragon();
		GameRegistry.registerBlock(ModBlocks.Spawner_VoidDragon, "spawnerVoidDragon");
		GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "Spawner Void Dragon");
		
		// Infuser
		
		Infuser = new InfuserMachine(true);
		Infuser_Idle = new InfuserMachine(false);
		
		GameRegistry.registerBlock(ModBlocks.Infuser_Idle, "infuserMachine");
		GameRegistry.registerBlock(ModBlocks.Infuser, "infuserMachineActive");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "Infuser");
		
	}
}
