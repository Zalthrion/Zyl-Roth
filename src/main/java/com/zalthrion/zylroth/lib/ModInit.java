package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;
import com.zalthrion.zylroth.block.ore.EndiriteOre;
import com.zalthrion.zylroth.block.ore.InferniumOre;
import com.zalthrion.zylroth.block.ore.TenebraeOre;
import com.zalthrion.zylroth.block.ore.VoidiumOre;
import com.zalthrion.zylroth.block.spawner.SpawnerVoidDragon;
import com.zalthrion.zylroth.block.tile.GoldBag;
import com.zalthrion.zylroth.block.tile.InfuserMachine;
import com.zalthrion.zylroth.block.tile.InfuserType;
import com.zalthrion.zylroth.block.tree.IridisLeafBlock;
import com.zalthrion.zylroth.block.tree.IridisSaplingBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock;
import com.zalthrion.zylroth.block.tree.RainbowLeafBlock2;
import com.zalthrion.zylroth.block.tree.RainbowSaplingBlock;
import com.zalthrion.zylroth.item.block.IridisLeafItemBlock;
import com.zalthrion.zylroth.item.block.IridisSaplingItemBlock;
import com.zalthrion.zylroth.item.block.RainbowLeafItemBlock;
import com.zalthrion.zylroth.item.block.RainbowSaplingItemBlock;
import com.zalthrion.zylroth.item.ore.EndiriteChunk;
import com.zalthrion.zylroth.item.ore.RawInfernium;
import com.zalthrion.zylroth.item.ore.TenebraeChunk;
import com.zalthrion.zylroth.item.ore.VoidiumChunk;
import com.zalthrion.zylroth.tile.TileEntityInfuser;
import com.zalthrion.zylroth.tile.TileEntitySpawnerVoidDragon;

public class ModInit {
	public static String[] sortOrder = new String[] { "ashBlock", "chiseledTenebrae", "empoweredTenebraeCore", "infusedTenebrae", "tenebraeBlock", "tenebraeCore",
		"infuserIdle", "infuser", "oreInfuserIdle", "oreInfuser", "endiriteOre", "inferniumOre", "tenebraeOre", "voidiumOre", "spawnerVoidDragon",
		"iridisLeafBlock", "iridisSaplingBlock", "rainbowLeafBlock", "rainbowLeafBlock2", "rainbowSaplingBlock", "endiriteChunk", "rawInfernium", "tenebraeChunk",
		"voidiumChunk" };
	public static class BlockInit {
		public static Block ashBlock = new AshBlock();
		public static Block chiseledTenebrae = new ChiseledTenebrae();
		public static Block empoweredTenebraeCore = new EmpoweredTenebraeCore();
		public static Block infusedTenebrae = new InfusedTenebrae();
		public static Block tenebraeBlock = new TenebraeBlock();
		public static Block tenebraeCore = new TenebraeCore();
		
		public static Block endiriteOre = new EndiriteOre();
		public static Block inferniumOre = new InferniumOre();
		public static Block tenebraeOre = new TenebraeOre();
		public static Block voidiumOre = new VoidiumOre();

		public static Block spawnerVoidDragon = new SpawnerVoidDragon();
		
		public static Block goldBag = new GoldBag();
		public static Block infuserIdle = new InfuserMachine(false, InfuserType.NORMAL);
		public static Block infuser = new InfuserMachine(true, InfuserType.NORMAL);
		public static Block oreInfuserIdle = new InfuserMachine(false, InfuserType.ORE);
		public static Block oreInfuser = new InfuserMachine(true, InfuserType.ORE);
		
		public static Block iridisLeafBlock = new IridisLeafBlock();
		public static Block iridisSaplingBlock = new IridisSaplingBlock();
		public static Block rainbowLeafBlock = new RainbowLeafBlock();
		public static Block rainbowLeafBlock2 = new RainbowLeafBlock2();
		public static Block rainbowSaplingBlock = new RainbowSaplingBlock();
		
		public static void preInit() {
			GameRegistry.registerTileEntity(TileEntitySpawnerVoidDragon.class, "spawnerVoidDragon");
			GameRegistry.registerTileEntity(TileEntityInfuser.class, "infuser");
			
			ModRegistry.addRegister(ashBlock, "ashBlock");
			ModRegistry.addRegister(chiseledTenebrae, "chiseledTenebrae");
			ModRegistry.addRegister(empoweredTenebraeCore, "empoweredTenebraeCore");
			ModRegistry.addRegister(infusedTenebrae, "infusedTenebrae");
			ModRegistry.addRegister(tenebraeBlock, "tenebraeBlock");
			ModRegistry.addRegister(tenebraeCore, "tenebraeCore");
			
			ModRegistry.addRegister(endiriteOre, "endiriteOre");
			ModRegistry.addRegister(inferniumOre, "inferniumOre");
			ModRegistry.addRegister(tenebraeOre, "tenebraeOre");
			ModRegistry.addRegister(voidiumOre, "voidiumOre");
			
			ModRegistry.addRegister(spawnerVoidDragon, "spawnerVoidDragon");
			
			ModRegistry.addRegister(goldBag, "goldBag");
			ModRegistry.addRegister(infuserIdle, "infuserIdle");
			ModRegistry.addRegister(infuser, "infuser");
			ModRegistry.addRegister(oreInfuserIdle, "oreInfuserIdle");
			ModRegistry.addRegister(oreInfuser, "oreInfuser");
			
			ModRegistry.addRegister(iridisLeafBlock, IridisLeafItemBlock.class, "iridisLeafBlock");
			ModRegistry.addRegister(iridisSaplingBlock, IridisSaplingItemBlock.class, "iridisSaplingBlock");
			ModRegistry.addRegister(rainbowLeafBlock, RainbowLeafItemBlock.class, "rainbowLeafBlock");
			ModRegistry.addRegister(rainbowLeafBlock2, RainbowLeafItemBlock.class, "rainbowLeafBlock2");
			ModRegistry.addRegister(rainbowSaplingBlock, RainbowSaplingItemBlock.class, "rainbowSaplingBlock");
		}
	}
	
	public static class ItemInit {
		public static Item endiriteChunk = new EndiriteChunk();
		public static Item rawInfernium = new RawInfernium();
		public static Item tenebraeChunk = new TenebraeChunk();
		public static Item voidiumChunk = new VoidiumChunk();
		
		public static void preInit() {
			ModRegistry.addRegister(endiriteChunk, "endiriteChunk");
			ModRegistry.addRegister(rawInfernium, "rawInfernium");
			ModRegistry.addRegister(tenebraeChunk, "tenebraeChunk");
			ModRegistry.addRegister(voidiumChunk, "voidiumChunk");
		}
	}
	
	public static class ZylrothTab {
		public static CreativeTabs zylRoth = new CreativeTabs("Zyl'Roth") {
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(BlockInit.ashBlock); // TODO ModItems.unstableTenebraeCore
			}
		};
	}
	
	public static void preInit() {
		BlockInit.preInit();
		ItemInit.preInit();
		ModRegistry.sortThenRegister(sortOrder);
	}
}