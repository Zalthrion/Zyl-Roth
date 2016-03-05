package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;

import com.zalthrion.zylroth.block.*;
import com.zalthrion.zylroth.block.machine.*;
import com.zalthrion.zylroth.block.ore.*;
import com.zalthrion.zylroth.block.spawner.*;
import com.zalthrion.zylroth.block.tree.*;
import com.zalthrion.zylroth.itemblock.*;
import com.zalthrion.zylroth.itemblock.tree.*;
import com.zalthrion.zylroth.tile.*;

import cpw.mods.fml.common.registry.GameRegistry;

public final class ModBlocks {
	
	/* Tenebrae */
	public static Block tenebraeOre = new TenebraeOre();
	public static Block tenebraeBlock = new TenebraeBlock();
	public static Block tenebraeCore = new TenebraeCore();
	public static Block empoweredTenebraeCore = new EmpoweredTenebraeCore();
	public static Block chiseledTenebrae = new ChiseledTenebrae();
	public static Block infusedTenebrae = new InfusedTenebrae();
	
	/* Infernium */
	public static Block inferniumOre = new InferniumOre();
	
	/* Endirite */
	public static Block endiriteOre = new EndiriteOre();
	
	/* Voidium */
	public static Block voidiumOre = new VoidiumOre();
	
	/* Trees */
	public static Block rainbowLeafBlock = new RainbowLeafBlock();
	public static Block rainbowLeafBlock_2 = new RainbowLeafBlock_2();
	public static Block rainbowSaplingBlockZL = new RainbowSaplingBlock();
	public static Block iridisLeafBlock = new IridisLeafBlock();
	public static Block iridisSaplingBlock = new IridisSaplingBlock();
	public static Block kyrulLogBlock = new KyrulLogBlock();
	
	/* Others */
	public static Block ashBlock = new AshBlock();
	public static Block goldBag = new GoldBag();
	
	/* Spawners */
	public static Block spawner_VoidDragon = new SpawnerVoidDragon();
	
	/* Machines */	
	public static Block infuser = new InfuserMachine(true, InfuserType.NORMAL);
	public static Block infuser_Idle = new InfuserMachine(false, InfuserType.NORMAL);
	public static Block oreInfuser = new InfuserMachine(true, InfuserType.ORE);
	public static Block oreInfuser_Idle = new InfuserMachine(false, InfuserType.ORE);
	
	public static void init() {
		
		/* Tenebrae */
		ModRegistry.addRegister(21, tenebraeOre, "tenebraeOre");
		
		ModRegistry.addRegister(25, tenebraeBlock, BeaconBaseItemBlock.class, "tenebraeBlock");
		ModRegistry.addRegister(26, tenebraeCore, CoreItemBlock.class, "tenebraeCore");
		ModRegistry.addRegister(27, empoweredTenebraeCore, CoreItemBlock.class, "empoweredTenebraeCore");
		ModRegistry.addRegister(28, chiseledTenebrae, HeadItemBlock.class, "chiseledTenebrae");
		ModRegistry.addRegister(29, infusedTenebrae, TenebraeItemBlock.class, "infusedTenebrae");
		
		/* Infernium */
		ModRegistry.addRegister(22, inferniumOre, "inferniumOre");
		
		/* Endirite */
		ModRegistry.addRegister(23, endiriteOre, "endiriteOre");
		
		/* Voidium */
		ModRegistry.addRegister(24, voidiumOre, "voidiumOre");
		
		/* Trees */
		ModRegistry.addRegister(31, rainbowLeafBlock, RainbowLeafItemBlock.class, "rainbowLeafBlock");
		ModRegistry.addRegister(30, rainbowLeafBlock_2, RainbowLeaf2ItemBlock.class, "rainbowLeafBlock_2");
		ModRegistry.addRegister(32, rainbowSaplingBlockZL, RainbowSaplingItemBlock.class, "rainbowSaplingBlockZL");
		ModRegistry.addRegister(33, kyrulLogBlock, KyrulLogItemBlock.class, "kyrulLogBlock");
		ModRegistry.addRegister(41, iridisLeafBlock, IridisLeafItemBlock.class, "iridisLeafBlock");
		ModRegistry.addRegister(42, iridisSaplingBlock, IridisSaplingItemBlock.class, "iridisSaplingBlock");
		
		/* Others */
		ModRegistry.addRegister(34, ashBlock, "ashBlock");
		ModRegistry.addRegister(40, goldBag, "goldBag");
		
		/* Spawners */
		ModRegistry.addRegister(35, spawner_VoidDragon, "spawnerVoidDragon");
		
		/* Machines */
		ModRegistry.addRegister(36, infuser, "infuserMachineActive");
		ModRegistry.addRegister(37, infuser_Idle, "infuserMachine");
		
		ModRegistry.addRegister(38, oreInfuser, "oreInfuserMachineActive");
		ModRegistry.addRegister(39, oreInfuser_Idle, "oreInfuserMachine");
		
		/* Tile Entities */
		GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "Infuser");
	}
}
