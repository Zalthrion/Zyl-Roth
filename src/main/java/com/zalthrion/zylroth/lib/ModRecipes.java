package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.block.machine.InfuserType;
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.recipe.InfusionFuels;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public final class ModRecipes {
	
	public static void init() {
		registerSmeltingRecipes();
		registerShapedRecipes();
		registerShapelessRecipes();
		registerArmorRecipes();
		registerToolRecipes();
		registerInfusionRecipes();
	}
	
	public static void registerSmeltingRecipes() {
		
		GameRegistry.addSmelting(ModBlocks.tenebraeOre, new ItemStack(ModItems.tenebraeChunk), 0.5F);
		
		GameRegistry.addSmelting(ModItems.tenebraeOre, new ItemStack(ModItems.tenebraeIngot), 0.1F);
		
	}
	
	public static void registerShapedRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.goldTalisman), "GEG", "EDE", "GEG", 'E', Items.ender_pearl, 'G', Items.gold_ingot, 'D', Items.diamond);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.chiseledTenebrae), "IRI", "RBR", "IRI", 'I', Items.iron_ingot, 'R', ModItems.tenebraeChunk, 'B', ModBlocks.tenebraeBlock);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebraeCore), "RTR", "TBT", "RTR", 'R', Blocks.redstone_block, 'T', ModItems.tenebraeIngot, 'B', ModBlocks.tenebraeBlock);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebraeBlock), "III", "III", "III", 'I', ModItems.tenebraeIngot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.voidGem), "NVN", "VDV", "NVN", 'V', ModItems.voidEssence, 'D', Items.diamond);
		
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.infuser_Idle), "RTR", "ICI", "RTR", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'T', ModBlocks.tenebraeBlock, 'C', ModItems.celestialCore);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.oreInfuser_Idle), "IRI", "RER", "IRI", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'E', Items.ender_pearl);
		
	}
	
	public static void registerShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tenebraeIngot, 9), new ItemStack(ModBlocks.tenebraeBlock));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.tenebraeBlock, 1), new ItemStack(ModBlocks.chiseledTenebrae));
		
		if (ConfigurationHandler.getKyrulEnabled())
			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.voidTalisman, 1), new ItemStack(ModItems.goldTalisman), new ItemStack(ModItems.voidGem));
		
	}
	
	public static void registerArmorRecipes() {
		
		/* Tenebrae Armor */
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Helmet), "III", "IEI", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Chestplate), "IEI", "III", "III", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Leggings), "III", "IEI", "IEI", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Boots), "IEI", "IEI", 'I', ModItems.tenebraeIngot);
		
	}
	
	public static void registerToolRecipes() {
		
		/* Tenebrae Tools */
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeSword), "NTN", "OTO", "NBN", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraePickaxe), "TTT", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeAxe), "TTN", "TBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeAxe), "NTT", "NBT", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeShovel), "NTN", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeHoe), "TTN", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeHoe), "NTT", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		
	}
	
	public static void registerInfusionRecipes() {
		
		/* Real Fuel Items */
		InfusionFuels.registerFuel(new ItemStack(ModItems.tenebraeOre), 200);
		
		/* Real Recipes */
		InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(ModBlocks.endiriteOre), new ItemStack(Blocks.end_stone), new ItemStack(ModItems.tenebraeOre), new ItemStack(Items.ender_pearl));
		InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(ModBlocks.infusedTenebrae), new ItemStack(ModBlocks.tenebraeBlock), new ItemStack(Items.diamond), new ItemStack(Items.ender_pearl));
		
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.tenebriumIngot), new ItemStack(ModItems.tenebraeIngot), new ItemStack(Items.iron_ingot), new ItemStack(ModItems.inferniumIngot));;
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.voidiriteIngot), new ItemStack(ModItems.voidiumIngot), new ItemStack(Items.iron_ingot), new ItemStack(ModItems.inferniumIngot));;
	
		/* Temporal Recipes (Ore Smelter) */
		
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.tenebraeIngot), new ItemStack(ModItems.tenebraeOre), new ItemStack(ModItems.tenebraeOre), new ItemStack(ModItems.tenebraeOre));;
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.inferniumIngot), new ItemStack(ModItems.rawInfernium), new ItemStack(ModItems.rawInfernium), new ItemStack(ModItems.rawInfernium));;
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.endiriteIngot), new ItemStack(ModItems.endiriteOre), new ItemStack(ModItems.endiriteOre), new ItemStack(ModItems.endiriteOre));;
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.voidiumIngot), new ItemStack(ModItems.voidiumOre), new ItemStack(ModItems.voidiumOre), new ItemStack(ModItems.voidiumOre));;
		
		/* Debug Recipes */
/*		InfusionFuels.registerFuel(new ItemStack(Items.coal), 200);
		InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(Items.emerald), new ItemStack(Items.diamond), new ItemStack(Blocks.dirt), new ItemStack(Blocks.stone));
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(Blocks.diamond_ore), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.dirt), new ItemStack(Blocks.stone));;
		*/
	}
}
