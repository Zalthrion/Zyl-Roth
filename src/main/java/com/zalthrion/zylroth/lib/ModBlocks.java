package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.Benzenn;
import com.zalthrion.zylroth.block.BenzennStatue;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.GoldBag;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.Lamp;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.VoidPlanks;
import com.zalthrion.zylroth.block.VoidStone;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.block.machine.InfuserType;
import com.zalthrion.zylroth.block.ore.EndiriteOre;
import com.zalthrion.zylroth.block.ore.InferniumOre;
import com.zalthrion.zylroth.block.ore.TenebraeOre;
import com.zalthrion.zylroth.block.ore.VoidiumOre;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.block.tree.IridisLeafBlock;
import com.zalthrion.zylroth.block.tree.IridisSaplingBlock;
import com.zalthrion.zylroth.block.tree.KyrulLeafBlock;
import com.zalthrion.zylroth.block.tree.KyrulLogBlock;
import com.zalthrion.zylroth.block.tree.KyrulSaplingBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock_2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlock;
import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;
import com.zalthrion.zylroth.itemblock.CoreItemBlock;
import com.zalthrion.zylroth.itemblock.HeadItemBlock;
import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.itemblock.tree.IridisLeafItemBlock;
import com.zalthrion.zylroth.itemblock.tree.IridisSaplingItemBlock;
import com.zalthrion.zylroth.itemblock.tree.KyrulLeafItemBlock;
import com.zalthrion.zylroth.itemblock.tree.KyrulLogItemBlock;
import com.zalthrion.zylroth.itemblock.tree.KyrulSaplingItemBlock;
import com.zalthrion.zylroth.itemblock.tree.RainbowLeaf2ItemBlock;
import com.zalthrion.zylroth.itemblock.tree.RainbowLeafItemBlock;
import com.zalthrion.zylroth.itemblock.tree.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.tile.TileEntityBenzenn;
import com.zalthrion.zylroth.tile.TileEntityBenzennStatue;
import com.zalthrion.zylroth.tile.TileEntityGoldBag;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntityLamp;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

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
	public static Block kyrulLeafBlock = new KyrulLeafBlock();
	public static Block kyrulSaplingBlock = new KyrulSaplingBlock();
	
	/* Others */
	public static Block ashBlock = new AshBlock();
	public static Block goldBag = new GoldBag();
	public static Block benzenn = new Benzenn();
	public static Block benzennStatue = new BenzennStatue();
	public static Block lamp = new Lamp();
	public static Block voidStone = new VoidStone();
	public static Block voidPlanks = new VoidPlanks();
	
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
		ModRegistry.addRegister(75, kyrulLeafBlock, KyrulLeafItemBlock.class, "kyrulLeafBlock");
		ModRegistry.addRegister(76, kyrulSaplingBlock, KyrulSaplingItemBlock.class, "kyrulSaplingBlock");
		ModRegistry.addRegister(41, iridisLeafBlock, IridisLeafItemBlock.class, "iridisLeafBlock");
		ModRegistry.addRegister(42, iridisSaplingBlock, IridisSaplingItemBlock.class, "iridisSaplingBlock");
		
		/* Others */
		ModRegistry.addRegister(34, ashBlock, "ashBlock");
		ModRegistry.addRegister(40, goldBag, "goldBag");
		ModRegistry.addRegister(72, benzenn, "benzenn");
		ModRegistry.addRegister(73, benzennStatue, "benzennStatue");
		ModRegistry.addRegister(77, lamp, "lamp");
		ModRegistry.addRegister(74, voidStone, "voidStone");
		ModRegistry.addRegister(77, voidPlanks, "voidPlanks");
		
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
		GameRegistry.registerTileEntity(TileEntityGoldBag.class, "goldBag");
		GameRegistry.registerTileEntity(TileEntityBenzenn.class, "benzenn");
		GameRegistry.registerTileEntity(TileEntityBenzennStatue.class, "benzennStatue");
		GameRegistry.registerTileEntity(TileEntityLamp.class, "lamp");
	}
}
