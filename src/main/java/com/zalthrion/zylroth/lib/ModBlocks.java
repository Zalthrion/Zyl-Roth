package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.block.machine.OreInfuserMachine;
import com.zalthrion.zylroth.block.ore.EndiriteOre;
import com.zalthrion.zylroth.block.ore.InferniumOre;
import com.zalthrion.zylroth.block.ore.TenebraeOre;
import com.zalthrion.zylroth.block.ore.VoidiumOre;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlockZL;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlockZL2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlockZL;
import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;
import com.zalthrion.zylroth.itemblock.CoreItemBlock;
import com.zalthrion.zylroth.itemblock.HeadItemBlock;
import com.zalthrion.zylroth.itemblock.ItemBlockInfuser;
import com.zalthrion.zylroth.itemblock.RainbowLeafItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityOreInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

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
	public static Block rainbowLeafBlockZL2 = new RainbowLeafBlockZL2();
	public static Block rainbowSaplingBlockZL = new RainbowSaplingBlockZL();
	/* Others */
	public static Block ashBlock = new AshBlock();
	/* Spawners */
	public static Block spawner_VoidDragon = new SpawnerVoidDragon();
	/* Machines */
	public static Block infuser = new InfuserMachine(true);
	public static Block infuserIdle = new InfuserMachine(false);
	public static Block oreInfuser = new OreInfuserMachine(true);
	public static Block oreInfuserIdle = new OreInfuserMachine(false);
	
	public static void init() {
		/* TileEntity */
		GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
		GameRegistry.registerTileEntity(TileEntityOreInfuser.class, "oreInfuser");
		/* Tenebrae */
		ModRegistry.addRegister(20, tenebraeOre, "tenebraeOre");
		ModRegistry.addRegister(27, tenebraeBlock, BeaconBaseItemBlock.class, "tenebraeBlock");
		ModRegistry.addRegister(28, tenebraeCore, CoreItemBlock.class, "tenebraeCore");
		ModRegistry.addRegister(29, empoweredTenebraeCore, CoreItemBlock.class, "empoweredTenebraeCore");
		ModRegistry.addRegister(30, chiseledTenebrae, HeadItemBlock.class, "chiseledTenebrae");
		ModRegistry.addRegister(31, infusedTenebrae, TenebraeItemBlock.class, "infusedTenebrae");
		/* Infernium */
		ModRegistry.addRegister(22, inferniumOre, "inferniumOre");
		/* Endirite */
		ModRegistry.addRegister(23, endiriteOre, "endiriteOre");
		/* Voidium */
		ModRegistry.addRegister(21, voidiumOre, "voidiumOre");
		/* Trees */
		ModRegistry.addRegister(24, rainbowSaplingBlockZL, RainbowSaplingItemBlock.class, "rainbowSaplingBlockZL");
		ModRegistry.addRegister(25, rainbowLeafBlockZL, RainbowLeafItemBlock.class, "rainbowLeafBlockZL");
		ModRegistry.addRegister(26, rainbowLeafBlockZL2, RainbowLeafItemBlock.class, "rainbowLeafBlockZL2");
		/* Others */
		ModRegistry.addRegister(32, ashBlock, "ashBlock");
		/* Spawners */
		ModRegistry.addRegister(33, spawner_VoidDragon, "spawnerVoidDragon");
		/* Machines */
		ModRegistry.addRegister(34, infuserIdle, ItemBlockInfuser.class, "infuserMachine");
		ModRegistry.addRegister(35, infuser, "infuserMachineActive");
		ModRegistry.addRegister(36, oreInfuserIdle, "oreInfuserMachine"); //TODO Probably make an ItemBlock for this
		ModRegistry.addRegister(37, oreInfuser, "oreInfuserMachineActive");
		
	}
}
