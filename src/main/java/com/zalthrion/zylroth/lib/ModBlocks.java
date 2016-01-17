package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.machine.GoldBag;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.block.machine.InfuserType;
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
import com.zalthrion.zylroth.itemblock.RainbowLeafItemBlock;
import com.zalthrion.zylroth.itemblock.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
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
	public static Block goldBag = new GoldBag();
	/* Spawners */
	public static Block spawner_VoidDragon = new SpawnerVoidDragon();
	/* Machines */
	public static Block infuser = new InfuserMachine(true, InfuserType.NORMAL);
	public static Block infuserIdle = new InfuserMachine(false, InfuserType.NORMAL);
	public static Block oreInfuser = new InfuserMachine(true, InfuserType.ORE);
	public static Block oreInfuserIdle = new InfuserMachine(false, InfuserType.ORE);
	
	public static void init() {
		/* TileEntity */
		GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
		/* Tenebrae */
		ModRegistry.addRegister(21, tenebraeOre, "tenebraeOre");
		ModRegistry.addRegister(28, tenebraeBlock, BeaconBaseItemBlock.class, "tenebraeBlock");
		ModRegistry.addRegister(29, tenebraeCore, CoreItemBlock.class, "tenebraeCore");
		ModRegistry.addRegister(30, empoweredTenebraeCore, CoreItemBlock.class, "empoweredTenebraeCore");
		ModRegistry.addRegister(31, chiseledTenebrae, HeadItemBlock.class, "chiseledTenebrae");
		ModRegistry.addRegister(32, infusedTenebrae, TenebraeItemBlock.class, "infusedTenebrae");
		/* Infernium */
		ModRegistry.addRegister(23, inferniumOre, "inferniumOre");
		/* Endirite */
		ModRegistry.addRegister(24, endiriteOre, "endiriteOre");
		/* Voidium */
		ModRegistry.addRegister(22, voidiumOre, "voidiumOre");
		/* Trees */
		ModRegistry.addRegister(25, rainbowSaplingBlockZL, RainbowSaplingItemBlock.class, "rainbowSaplingBlockZL");
		ModRegistry.addRegister(26, rainbowLeafBlockZL, RainbowLeafItemBlock.class, "rainbowLeafBlockZL");
		ModRegistry.addRegister(27, rainbowLeafBlockZL2, RainbowLeafItemBlock.class, "rainbowLeafBlockZL2");
		/* Others */
		ModRegistry.addRegister(33, ashBlock, "ashBlock");
		ModRegistry.addRegister(39, goldBag, "goldBag");
		/* Spawners */
		ModRegistry.addRegister(34, spawner_VoidDragon, "spawnerVoidDragon");
		/* Machines */
		ModRegistry.addRegister(35, infuserIdle, "infuserMachine");
		ModRegistry.addRegister(36, infuser, "infuserMachineActive");
		ModRegistry.addRegister(37, oreInfuserIdle, "oreInfuserMachine");
		ModRegistry.addRegister(38, oreInfuser, "oreInfuserMachineActive");
		
	}
}
