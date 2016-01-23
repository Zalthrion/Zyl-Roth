package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.block.machine.InfuserType;
import com.zalthrion.zylroth.block.ore.EndiriteOre;
import com.zalthrion.zylroth.block.ore.InferniumOre;
import com.zalthrion.zylroth.block.ore.TenebraeOre;
import com.zalthrion.zylroth.block.ore.VoidiumOre;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlockZL;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlockZL_2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlockZL;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlockZL_2;
import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;
import com.zalthrion.zylroth.itemblock.CoreItemBlock;
import com.zalthrion.zylroth.itemblock.HeadItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowLeaf2ItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowLeafItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowSapling2ItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

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
	public static Block rainbowLeafBlockZL = new RainbowLeafBlockZL();
	public static Block rainbowLeafBlockZL_2 = new RainbowLeafBlockZL_2();
	public static Block rainbowSaplingBlockZL = new RainbowSaplingBlockZL();
	public static Block rainbowSaplingBlockZL_2 = new RainbowSaplingBlockZL_2();
	
	/* Others */
	public static Block ashBlock = new AshBlock();
	
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
		ModRegistry.addRegister(30, rainbowLeafBlockZL, RainbowLeafItemBlock.class, "rainbowLeafBlockZL");
		ModRegistry.addRegister(31, rainbowLeafBlockZL_2, RainbowLeaf2ItemBlock.class, "rainbowLeafBlockZL_2");
		ModRegistry.addRegister(32, rainbowSaplingBlockZL, RainbowSaplingItemBlock.class, "rainbowSaplingBlockZL");
		ModRegistry.addRegister(33, rainbowSaplingBlockZL_2, RainbowSapling2ItemBlock.class, "rainbowSaplingBlockZL_2");
		
		/* Others */
		ModRegistry.addRegister(34, ashBlock, "ashBlock");
		
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
