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
		/* Tenebrae */
		GameRegistry.registerBlock(tenebrae_Ore, "tenebraeOre");
		GameRegistry.registerBlock(tenebrae_Block, BeaconBaseItemBlock.class, "tenebraeBlock");
		GameRegistry.registerBlock(tenebrae_Core, CoreItemBlock.class, "tenebraeCore");
		GameRegistry.registerBlock(empowered_Tenebrae_Core, CoreItemBlock.class, "empoweredTenebraeCore");
		GameRegistry.registerBlock(chiseled_Tenebrae, HeadItemBlock.class, "chiseledTenebrae");
		GameRegistry.registerBlock(infused_Tenebrae, TenebraeItemBlock.class, "infusedTenebrae");
		/* Voidium */
		GameRegistry.registerBlock(voidium_Ore, "voidiumOre");
		/* Others */
		GameRegistry.registerBlock(ash_Block, "ashBlock");
		/* Spawners */
		GameRegistry.registerBlock(spawner_VoidDragon, "spawnerVoidDragon");
		GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
		/* Machines */
		GameRegistry.registerBlock(infuser_Idle, ItemBlockInfuser.class, "infuserMachine");
		GameRegistry.registerBlock(infuser, "infuserMachineActive");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
	}
}
