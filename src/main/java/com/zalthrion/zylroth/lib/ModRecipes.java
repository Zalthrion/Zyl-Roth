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
		registerInfusionRecipes();
	}
	
	public static void registerSmeltingRecipes() {
		
		GameRegistry.addSmelting(ModBlocks.tenebrae_Ore, new ItemStack(ModItems.raw_Tenebrae), 0.5F);
		
		GameRegistry.addSmelting(ModItems.raw_Tenebrae_Ingot, new ItemStack(ModItems.tenebrae_Ingot), 0.1F);
		
	}
	
	public static void registerShapedRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebrae_Block), "III", "III", "III", 'I', ModItems.tenebrae_Ingot);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.raw_Tenebrae_Ingot), "RRR", 'R', ModItems.raw_Tenebrae);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.infuser_Idle), "DTD", "TCT", "DTD", 'D', Items.diamond, 'T', ModBlocks.tenebrae_Block, 'C', ModBlocks.tenebrae_Core);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tenebrae_Core), "BEB", "ECE", "BEB", 'B', ModBlocks.tenebrae_Block, 'E', ModItems.soul_Essence, 'C', ModItems.stable_Tenebrae_Core);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.void_Talisman), "VIV", "IEI", "VIV", 'V', ModItems.void_Gem, 'I', Items.gold_ingot, 'E', ModItems.void_Essence);
		
	}
	
	public static void registerShapelessRecipes() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tenebrae_Ingot, 9), new ItemStack(ModBlocks.tenebrae_Block));
		
	}
	
	public static void registerArmorRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Helmet), "III", "IEI", 'I', ModItems.tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Chestplate), "IEI", "III", "III", 'I', ModItems.tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Leggings), "III", "IEI", "IEI", 'I', ModItems.tenebrae_Ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModArmors.Tenebrae_Boots), "IEI", "IEI", 'I', ModItems.tenebrae_Ingot);

	}
	
	public static void registerInfusionRecipes() {
		
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(ModBlocks.tenebrae_Block), new ItemStack(ModBlocks.infused_Tenebrae), 0, new ItemStack(ModItems.raw_Tenebrae, 1, 0), new ItemStack(ModItems.soul_Essence, 1, 0));
		
		InfusionRecipeHandler.instance().addInfusion(new ItemStack(ModItems.unstable_Tenebrae_Core), new ItemStack(ModItems.stable_Tenebrae_Core), 0, new ItemStack(Blocks.diamond_block, 1, 0), new ItemStack(ModBlocks.infused_Tenebrae, 1, 0));
		
	}
}
