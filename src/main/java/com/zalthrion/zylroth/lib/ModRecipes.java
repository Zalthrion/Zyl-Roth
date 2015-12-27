package com.zalthrion.zylroth.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.zalthrion.zylroth.handler.ConfigurationHandler;
import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;
import com.zalthrion.zylroth.handler.recipe.OreInfusionRecipeHandler;

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
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebraeCore), "DTD", "TBT", "DTD", 'D', Items.diamond, 'T', ModItems.tenebraeIngot, 'B', ModBlocks.tenebraeBlock);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebraeBlock), "III", "III", "III", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.infuserIdle), "RTR", "ICI", "RIR", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'C', ModItems.unstableTenebraeCore);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.oreInfuserIdle), "IRI", "RER", "IRI", 'R', Blocks.redstone_block, 'I', Blocks.iron_block, 'E', Items.ender_pearl);
	}
	
	public static void registerShapelessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tenebraeIngot, 9), new ItemStack(ModBlocks.tenebraeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.tenebraeBlock, 1), new ItemStack(ModBlocks.chiseledTenebrae));
		if (ConfigurationHandler.getKyrulEnabled()) GameRegistry.addShapelessRecipe(new ItemStack(ModItems.voidTalisman, 1), new ItemStack(ModItems.goldTalisman), new ItemStack(ModItems.voidGem));
	}
	
	public static void registerArmorRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeHelmet), "III", "IEI", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeChestplate), "IEI", "III", "III", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeLeggings), "III", "IEI", "IEI", 'I', ModItems.tenebraeIngot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.tenebraeBoots), "IEI", "IEI", 'I', ModItems.tenebraeIngot);
	}
	
	public static void registerToolRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeSword), "NTN", "OTO", "NBN", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraePickaxe), "TTT", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeAxe), "TTN", "TBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeAxe), "NTT", "NBT", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeShovel), "NTN", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeHoe), "TTN", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeHoe), "NTT", "NBN", "NON", 'T', ModItems.tenebraeIngot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
	}
	
	public static void registerInfusionRecipes() {
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(Blocks.wool), new ItemStack(Blocks.wool, 1, 3), 0.5F, new ItemStack(Items.dye, 1, 3));
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(Blocks.end_stone), new ItemStack(ModBlocks.endiriteOre), 0, new ItemStack(ModItems.tenebraeOre, 1, 0), new ItemStack(Items.ender_pearl, 1, 0));
		OreInfusionRecipeHandler.instance().addOreInfusion(new ItemStack(ModItems.tenebraeIngot), new ItemStack(ModItems.tenebriumIngot, 1), 0.5F, new ItemStack(Items.iron_ingot, 1, 0), new ItemStack(ModItems.inferniumIngot, 1, 0));
	}
}
