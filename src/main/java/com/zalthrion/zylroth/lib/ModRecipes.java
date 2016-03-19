package com.zalthrion.zylroth.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.block.machine.InfuserType;
import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.recipe.InfusionFuels;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;

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
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.tenebraeOre), "CC", "CC", 'C', ModItems.tenebraeChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.endiriteOre), "CC", "CC", 'C', ModItems.endiriteChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.voidiumOre), "CC", "CC", 'C', ModItems.voidiumChunk);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.chiseledTenebrae), "IRI", "RBR", "IRI", 'I', Items.iron_ingot, 'R', ModItems.tenebraeChunk, 'B', ModBlocks.tenebraeBlock);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebraeCore), "RTR", "TBT", "RTR", 'R', Blocks.redstone_block, 'T', ModItems.tenebraeIngot, 'B', ModBlocks.tenebraeBlock);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebraeBlock), "III", "III", "III", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.voidGem), "NVN", "VDV", "NVN", 'V', ModItems.voidEssence, 'D', Items.diamond);
		// GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.infuserIdle), "RTR", "ICI", "RTR", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'T', ModBlocks.tenebraeBlock, 'C', ModItems.unstableTenebraeCore);
		// GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.oreInfuserIdle), "IRI", "RER", "IRI", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'E', Items.ender_pearl); // FIXME
	}
	
	public static void registerShapelessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tenebraeIngot, 9), new ItemStack(ModBlocks.tenebraeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.tenebraeBlock, 1), new ItemStack(ModBlocks.chiseledTenebrae));
		if (ConfigurationHandler.getKyrulEnabled()) GameRegistry.addShapelessRecipe(new ItemStack(ModItems.voidTalisman, 1), new ItemStack(ModItems.goldTalisman), new ItemStack(ModItems.voidGem));
	}
	
	public static void registerArmorRecipes() {
		/* Tenebrae Armor */
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeHelmet), "III", "IEI", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeChestplate), "IEI", "III", "III", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeLeggings), "III", "IEI", "IEI", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeBoots), "IEI", "IEI", 'I', ModItems.tenebraeIngot);
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
		/* Debug Recipes */
		
		/* InfusionFuels.registerFuel(new ItemStack(Items.coal), 200);
		InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(Items.emerald), new ItemStack(Items.diamond), new ItemStack(Blocks.dirt, 2), new ItemStack(Blocks.stone));
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(Blocks.diamond_ore), new ItemStack(Blocks.iron_ore), new ItemStack(Blocks.dirt), new ItemStack(Blocks.stone)); */
		
		/* Real Recipes */
		InfusionFuels.registerFuel(new ItemStack(ModItems.tenebraeOre), 200);
		
		InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(ModBlocks.endiriteOre), new ItemStack(Blocks.end_stone), new ItemStack(ModItems.tenebraeOre), new ItemStack(Items.ender_pearl));
		InfusionRecipeHandler.instance().addInfusion(InfuserType.NORMAL, 1F, 100, new ItemStack(ModBlocks.infusedTenebrae), new ItemStack(ModBlocks.tenebraeBlock), new ItemStack(Items.diamond), new ItemStack(Items.ender_pearl));
		InfusionRecipeHandler.instance().addInfusion(InfuserType.ORE, 1F, 100, new ItemStack(ModItems.tenebriumIngot), new ItemStack(ModItems.tenebraeIngot), new ItemStack(Items.iron_ingot), new ItemStack(ModItems.inferniumIngot));
	}
}