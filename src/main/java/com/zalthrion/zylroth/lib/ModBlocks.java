package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.TenebraeOre;
import com.zalthrion.zylroth.block.VoidiumOre;
import com.zalthrion.zylroth.block.item.ItemBlockInfuser;
import com.zalthrion.zylroth.block.machine.InfuserMachine;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.itemblock.BeaconBaseItemBlock;
import com.zalthrion.zylroth.itemblock.CoreItemBlock;
import com.zalthrion.zylroth.itemblock.HeadItemBlock;
import com.zalthrion.zylroth.itemblock.TenebraeItemBlock;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

public final class ModBlocks {
	/* Tenebrae */
	public static Block tenebrae_Ore = new TenebraeOre();
	public static Block tenebrae_Block = new TenebraeBlock();
	public static Block tenebrae_Core = new TenebraeCore();
	public static Block empowered_Tenebrae_Core = new EmpoweredTenebraeCore();
	public static Block chiseled_Tenebrae = new ChiseledTenebrae();
	public static Block infused_Tenebrae = new InfusedTenebrae();
	/* Voidium */
	public static Block voidium_Ore = new VoidiumOre();
	/* Others */
	public static Block ash_Block = new AshBlock();
	/* Spawners */
	public static Block spawner_VoidDragon = new SpawnerVoidDragon();
	/* Machines */
	public static Block infuser = new InfuserMachine(true);
	public static Block infuser_Idle = new InfuserMachine(false);
	
	public static void init() {
		/* TileEntity */
		GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
		/* Tenebrae */
		ModRegistry.addRegister(15, tenebrae_Ore, "tenebraeOre");
		ModRegistry.addRegister(17, tenebrae_Block, BeaconBaseItemBlock.class, "tenebraeBlock");
		ModRegistry.addRegister(18, tenebrae_Core, CoreItemBlock.class, "tenebraeCore");
		ModRegistry.addRegister(19, empowered_Tenebrae_Core, CoreItemBlock.class, "empoweredTenebraeCore");
		ModRegistry.addRegister(20, chiseled_Tenebrae, HeadItemBlock.class, "chiseledTenebrae");
		ModRegistry.addRegister(21, infused_Tenebrae, TenebraeItemBlock.class, "infusedTenebrae");
		/* Voidium */
		ModRegistry.addRegister(16, voidium_Ore, "voidiumOre");
		/* Others */
		ModRegistry.addRegister(22, ash_Block, "ashBlock");
		/* Spawners */
		ModRegistry.addRegister(23, spawner_VoidDragon, "spawnerVoidDragon");
		/* Machines */
		ModRegistry.addRegister(24, infuser_Idle, ItemBlockInfuser.class, "infuserMachine");
		ModRegistry.addRegister(25, infuser, "infuserMachineActive");
		
	}
}
