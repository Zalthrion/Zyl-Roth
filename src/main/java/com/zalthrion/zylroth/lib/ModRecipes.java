package com.zalthrion.zylroth.lib;

import com.zalthrion.zylroth.handler.recipe.InfusionRecipeHandler;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

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
		
		GameRegistry.addSmelting(ModBlocks.tenebrae_Ore, new ItemStack(ModItems.raw_Tenebrae), 0.5F);
		
		GameRegistry.addSmelting(ModItems.raw_Tenebrae_Ingot, new ItemStack(ModItems.tenebrae_Ingot), 0.1F);
		
	}
	
	public static void registerShapedRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gold_Talisman), "GEG", "EDE", "GEG", 'E', Items.ender_pearl, 'G', Items.gold_ingot, 'D', Items.diamond);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.raw_Tenebrae_Ingot), "RRR", 'R', ModItems.raw_Tenebrae);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.chiseled_Tenebrae), "IRI", "RBR", "IRI", 'I', Items.iron_ingot, 'R', ModItems.raw_Tenebrae, 'B', ModBlocks.tenebrae_Block);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebrae_Core), "DTD", "TBT", "DTD", 'D', Items.diamond, 'T', ModItems.tenebrae_Ingot, 'B', ModBlocks.tenebrae_Block);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebrae_Block), "III", "III", "III", 'I', ModItems.tenebrae_Ingot);
						
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.infuser_Idle), "RTR", "TCT", "DTD", 'D', Blocks.redstone_block, 'T', ModBlocks.tenebrae_Block, 'C', ModItems.unstable_Tenebrae_Core);
		
	}
	
	public static void registerShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tenebrae_Ingot, 9), new ItemStack(ModBlocks.tenebrae_Block));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.tenebrae_Block, 1), new ItemStack(ModBlocks.chiseled_Tenebrae));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.void_Talisman, 1), new ItemStack(ModItems.gold_Talisman), new ItemStack(ModItems.void_Gem));
		
	}
	
	public static void registerArmorRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Helmet), "III", "IEI", 'I', ModItems.tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Chestplate), "IEI", "III", "III", 'I', ModItems.tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Leggings), "III", "IEI", "IEI", 'I', ModItems.tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Boots), "IEI", "IEI", 'I', ModItems.tenebrae_Ingot);

	}
	
	public static void registerToolRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeSword), "NTN", "OTO", "NBN", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraePickaxe), "TTT", "NBN", "NON", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeAxe), "TTN", "TBN", "NON", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeAxe), "NTT", "NBT", "NON", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeShovel), "NTN", "NBN", "NON", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeHoe), "TTN", "NBN", "NON", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		GameRegistry.addShapedRecipe(new ItemStack(ModTools.tenebraeHoe), "NTT", "NBN", "NON", 'T', ModItems.tenebrae_Ingot, 'O', Blocks.obsidian, 'B', Items.blaze_rod);
		
	}
	
	public static void registerInfusionRecipes() {
		
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(ModBlocks.tenebrae_Block), new ItemStack(ModBlocks.infused_Tenebrae), 0, new ItemStack(Items.redstone, 5, 0), new ItemStack(Items.iron_ingot, 5, 0));
		
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(ModItems.unstable_Tenebrae_Core), new ItemStack(ModBlocks.empowered_Tenebrae_Core), 0, new ItemStack(Blocks.diamond_block, 1, 0), new ItemStack(ModBlocks.infused_Tenebrae, 1, 0));
		
	}
}
