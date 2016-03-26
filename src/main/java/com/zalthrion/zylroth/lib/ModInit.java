package com.zalthrion.zylroth.lib;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.zalthrion.zylroth.block.AshBlock;
import com.zalthrion.zylroth.block.ChiseledTenebrae;
import com.zalthrion.zylroth.block.EmpoweredTenebraeCore;
import com.zalthrion.zylroth.block.InfusedTenebrae;
import com.zalthrion.zylroth.block.TenebraeBlock;
import com.zalthrion.zylroth.block.TenebraeCore;

public class ModInit {
	public static String[] sortOrder = new String[] { "ashBlock", "chiseledTenebrae", "empoweredTenebraeCore", "infusedTenebrae", "tenebraeBlock", "tenebraeCore" };
	public static class BlockInit {
		public static Block ashBlock = new AshBlock();
		public static Block chiseledTenebrae = new ChiseledTenebrae();
		public static Block empoweredTenebraeCore = new EmpoweredTenebraeCore();
		public static Block infusedTenebrae = new InfusedTenebrae();
		public static Block tenebraeBlock = new TenebraeBlock();
		public static Block tenebraeCore = new TenebraeCore();
		
		public static void preInit() {
			ModRegistry.addRegister(ashBlock, "ashBlock");
			ModRegistry.addRegister(chiseledTenebrae, "chiseledTenebrae");
			ModRegistry.addRegister(empoweredTenebraeCore, "empoweredTenebraeCore");
			ModRegistry.addRegister(infusedTenebrae, "infusedTenebrae");
			ModRegistry.addRegister(tenebraeBlock, "tenebraeBlock");
			ModRegistry.addRegister(tenebraeCore, "tenebraeCore");
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
		ModRegistry.sortThenRegister(sortOrder);
	}
}